package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Customer;

public interface CustomerService {
	
	Customer save(Customer customer);
	List<Customer> fetch();
	Customer fetch(Integer id);
	void deleteCustomerById(Integer id);//add delete service

}
