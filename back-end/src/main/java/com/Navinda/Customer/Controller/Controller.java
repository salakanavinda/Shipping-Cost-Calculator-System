package com.Navinda.Customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Navinda.Customer.Model.Customer;
import com.Navinda.Customer.Service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/cus-cloud")
public class Controller {

	@Autowired
	CustomerService customrService;
	
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customrService.save(customer);
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.GET)
	public List<Customer> getAll(){
		return customrService.fetch();
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET)
	public ResponseEntity<Customer> findById(@PathVariable Integer id){
		if(id<=0) {
			return ResponseEntity.badRequest().build();
		}else {
			Customer customer = customrService.fetch(id);
			if(customer==null) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(customer);
			}
		}
	}
	//delete customer 
	@RequestMapping(value="/customer/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
		customrService.deleteCustomerById(id);
		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
	
}

