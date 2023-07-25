package redoc.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import redoc.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {


	List<Employee> findBySalary(BigDecimal salary);

}
