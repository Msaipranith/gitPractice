package redoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redoc.entity.Customer;
import redoc.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;
	

	@Override
	public void saveCustomerDetails(Customer customer) {
		// TODO Auto-generated method stub
		customerRepo.save(customer);
	}

}
