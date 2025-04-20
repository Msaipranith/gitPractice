package redoc.service;

import java.util.List;

import redoc.entity.Customer;

public interface CustomerService {

	void saveCustomerDetails(Customer customer);

	List<Customer> getCustomerList();

}
