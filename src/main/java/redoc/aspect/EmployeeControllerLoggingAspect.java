package redoc.aspect;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import redoc.entity.Employee;

@Aspect
@Component
public class EmployeeControllerLoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeControllerLoggingAspect.class);

	@Before("execution(public java.util.List<redoc.entity.Employee> findAllEmp())")
    public void logBeforeMethodExecution() {
        LOGGER.info("Method findAllEmp() is about to be called. Preparing to fetch all employees.");
    }

    @AfterThrowing(pointcut = "execution(public java.util.List<redoc.entity.Employee> findAllEmp())", throwing = "ex")
    public void logExceptionThrown(Exception ex) {
        LOGGER.error("Exception occurred during the execution of findAllEmp(). Exception message: {}", ex.getMessage());
    }

    @AfterReturning(pointcut = "execution(public java.util.List<redoc.entity.Employee> findAllEmp())", returning = "result")
    public void logAfterSuccessfulExecution(List<Employee> result) {
        LOGGER.info("Method findAllEmp() executed successfully. Total employees fetched: {}", result.size());
    }

    @After("execution(public java.util.List<redoc.entity.Employee> findAllEmp())")
    public void logAfterMethodCompletion() {
        LOGGER.info("Method findAllEmp() has completed execution.");
    }

}
