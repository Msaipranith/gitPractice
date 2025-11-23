package redoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	
	
	@GetMapping("/getCustomerDetails")
	public List<Customer> getMethodName() {
		return customerService.getCustomerList();
	}
	

	@GetMapping("/welcome-page")
	public String welcomePage(){

		return "Welcome to git";

	}

	@GetMapping("/cusomer/{id}")
	public Customer fetchCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCustomerById(@PathVariable int id){
		customerService.deleteCustomerById(id);
		return  "deleted ";
	}

	// this is customer controller
}
