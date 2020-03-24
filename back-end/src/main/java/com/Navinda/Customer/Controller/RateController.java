package com.Navinda.Customer.Controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Navinda.Customer.Service.Rate_Service;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping(value="/api/rate")
public class RateController {

	@Autowired
	private Rate_Service Rate_Service;
	
	@RequestMapping(value="/{shipping_method}/{item}/{weight}/{country}", method=RequestMethod.GET)
	public double getByCategory(@PathVariable Integer shipping_method,@PathVariable Integer item,
		            @PathVariable double weight,@PathVariable String country) {
		
		double price = Rate_Service.getPrice(shipping_method, item, weight, country);
		
		return price;
	}
	
	@RequestMapping(value="/service/{shipping_method}/{item}/{itemType}/{itemSubType}", method=RequestMethod.GET)
	public double getByService(@PathVariable Integer shipping_method,@PathVariable Integer item,
			@PathVariable int itemType,@PathVariable int itemSubType) {
		
		double price = Rate_Service.getPriceForService(shipping_method, item, itemType, itemSubType);
		
		return price;
	}	
	
}
