# Define the project root directory
$projectRoot = Get-Location

# Define SQL keywords to search for
$searchPattern = '(?i)\b(SELECT|INSERT|UPDATE|DELETE)\b'

# Get all relevant source files, excluding the 'target' folder
$files = Get-ChildItem -Path $projectRoot -Recurse -Include "*.java", "*.xml", "*.sql" | Where-Object { $_.FullName -notmatch '\\target\\' }

# Initialize output data
$reportResults = @()
$queryResults = @()

# Iterate through each file and check for SQL queries (excluding comments)
foreach ($file in $files) {
    $content = Get-Content $file.FullName -Raw

    # Remove multi-line comments /* ... */
    $content = $content -replace '/\*.*?\*/', ''

    # Remove single-line comments (// and --)
    $content = $content -replace '(?m)^\s*//.*$', ''
    $content = $content -replace '(?m)^\s*--.*$', ''

    # Find SQL query occurrences
    $matches = [regex]::Matches($content, $searchPattern)

    # Extract queries properly (handling multi-line queries)
    $sqlQueries = [regex]::Matches($content, '(?is)(SELECT|INSERT|UPDATE|DELETE).*?;')

    if ($matches.Count -gt 0) {
        # Ensure the matches array is not empty before indexing
        $selectCount = ($matches | Where-Object { $_.Groups.Count -gt 1 -and $_.Groups[1].Value -match 'SELECT' }).Count
        $insertCount = ($matches | Where-Object { $_.Groups.Count -gt 1 -and $_.Groups[1].Value -match 'INSERT' }).Count
        $updateCount = ($matches | Where-Object { $_.Groups.Count -gt 1 -and $_.Groups[1].Value -match 'UPDATE' }).Count
        $deleteCount = ($matches | Where-Object { $_.Groups.Count -gt 1 -and $_.Groups[1].Value -match 'DELETE' }).Count

        # Total query count should be the sum of individual counts
        $totalQueryCount = $selectCount + $insertCount + $updateCount + $deleteCount

        # Add results to report array
        $reportResults += [PSCustomObject]@{
            "FILE PATH"         = $file.FullName
            "TOTAL QUERY COUNT" = $totalQueryCount
            "SELECT COUNT"      = $selectCount
            "INSERT COUNT"      = $insertCount
            "UPDATE COUNT"      = $updateCount
            "DELETE COUNT"      = $deleteCount
        }

        # Add extracted queries to queryResults array
        foreach ($query in $sqlQueries) {
            $queryResults += [PSCustomObject]@{
                "FILE PATH" = $file.FullName
                "QUERY"     = $query.Value.Trim()
            }
        }
    }
}

# Export report results
$reportResults | Export-Csv -Path "$projectRoot\sql_queries_report.csv" -NoTypeInformation

# Export extracted queries
$queryResults | Export-Csv -Path "$projectRoot\sql_queries_extracted.csv" -NoTypeInformation

# Final confirmation messages
Write-Host "SQL query report generated: sql_queries_report.csv"
Write-Host "SQL queries extracted: sql_queries_extracted.csv"
