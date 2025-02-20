package redoc.utility;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import redoc.controller.EmployeeController;
import redoc.dto.EmployeePojo;
import redoc.entity.Employee;

public class Utility {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	public static List<EmployeePojo> mapToPojoList(List<Employee> empList) {
		LOGGER.info("Mapping Employee entities to EmployeePojo list");

		List<EmployeePojo> empPojoList = new ArrayList<>();

		for (Employee employee : empList) {
			EmployeePojo empPojo = new EmployeePojo();
			BeanUtils.copyProperties(employee, empPojo);
			empPojoList.add(empPojo);
		}

		return empPojoList;
	}

}
  