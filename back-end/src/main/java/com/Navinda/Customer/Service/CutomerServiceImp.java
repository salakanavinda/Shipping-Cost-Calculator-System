package com.Navinda.Customer.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Customer;
import com.Navinda.Customer.Repository.CustomerRepository;

@Service
public class CutomerServiceImp implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) {

		return customerRepository.save(customer);//since this autowired to service
	}

	@Override
	public List<Customer> fetch() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer fetch(Integer id) {
		//since cannot convert to customer getting from repository
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteCustomerById(Integer id) {
		customerRepository.deleteById(id);
	}

}
