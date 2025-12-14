package redoc.service;

import java.util.List;

import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redoc.controller.EmployeeController;
import redoc.entity.Customer;
import redoc.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public void saveCustomerDetails(Customer customer) {
		// TODO Auto-generated method stub
		customerRepo.save(customer);
	}


	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerRepo.findById(id).get();
	}

	@Override
	public void deleteCustomerById(int id) {
			throw new RuntimeException(" id not found " + id);
	}

}
