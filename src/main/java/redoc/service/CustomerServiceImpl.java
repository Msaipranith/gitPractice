package redoc.service;

import java.util.List;

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


	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public void deleteById(int id) {
		customerRepo.deleteById(id);
	}


}
