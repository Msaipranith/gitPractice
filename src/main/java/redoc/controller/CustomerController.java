package redoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import redoc.entity.Customer;
import redoc.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	CustomerService customerService;

	@PostMapping("/saveCustomerDetails")
	public String saveCustomerDetails(@RequestBody Customer customer) {
		customerService.saveCustomerDetails(customer);
		return "saved";
	}
	
	
}


//controller class- updated from b1


