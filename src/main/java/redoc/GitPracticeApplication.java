package redoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GitPracticeApplication{
    public static void main(String[] args) {
        SpringApplication.run(GitPracticeApplication.class, args);
    } 
}
