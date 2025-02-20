package redoc;

import java.util.ArrayList;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

import redoc.entity.Employee;
import redoc.repo.EmployeeRepo;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableCaching
public class GitPracticeApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(GitPracticeApplication.class);

	@Autowired
	EmployeeRepo empRepo;

	public static void main(String[] args) {
		SpringApplication.run(GitPracticeApplication.class, args);
	}
  
	@Cacheable("empList") // Cache results of this method with the name "empList"
	@Override
	public void run(String... args) throws Exception {
//		LOGGER.info("Starting data population process...");
//
//		ArrayList<Employee> empList = new ArrayList<>();
//
//		// Array of random locations
//		String[] locations = { "hyd", "chennai", "madras", "bangalore", "mumbai", "delhi", "kolkata", "pune",
//				"jaipur" };
//
//		// Adding 100 more data entries
//		for (int i = 1; i <= 100; i++) {
//			String empName = "user-" + i;
//			String empLocation = getRandomLocation(locations);
//			String empEmail = "user-" + i + "@gmail.com";
//			Double salary = i * 2500.0;
//
//			empList.add(new Employee((long) i, empName, empLocation, empEmail, salary));
//		}
//
//		empRepo.saveAll(empList);
//
//		LOGGER.info("Data population process completed.");
//	}
//
//	// Method to get a random location from the array
//	private String getRandomLocation(String[] locations) {
//		LOGGER.debug("Generating a random location...");
//		Random random = new Random();
//		int index = random.nextInt(locations.length);
//		String location = locations[index];
//		LOGGER.debug("Random location generated: {}", location);
//		return location;
}

}
