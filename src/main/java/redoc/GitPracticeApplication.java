package redoc;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import redoc.entity.Employee;
import redoc.repo.EmployeeRepo;

@SpringBootApplication
public class GitPracticeApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepo empRepo;

	public static void main(String[] args) {
		SpringApplication.run(GitPracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	    ArrayList<Employee> empList = new ArrayList<>();

	    // Array of random locations
	    String[] locations = {"hyd", "chennai", "madras", "bangalore", "mumbai", "delhi", "kolkata", "pune", "jaipur"};

	    // Adding 100 more data entries
	    for (int i = 1; i <= 100; i++) {
	        String empName = "user-" + i;
	        String empLocation = getRandomLocation(locations);
	        String empEmail = "user-" + i + "@gmail.com";
	        Double salary = i * 2500.0;

	        empList.add(new Employee((long) i, empName, empLocation, empEmail, salary));
	    }

	    empRepo.saveAll(empList);
	}

	// Method to get a random location from the array
	private String getRandomLocation(String[] locations) {
	    Random random = new Random();
	    int index = random.nextInt(locations.length);
	    return locations[index];
	}

}
