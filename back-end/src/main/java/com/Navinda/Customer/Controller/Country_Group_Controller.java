package com.Navinda.Customer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Navinda.Customer.Model.Country_Group;

import com.Navinda.Customer.Service.Country_Group_Service;

@RestController
@RequestMapping(value="/api/country_group")
public class Country_Group_Controller {
	
	@Autowired
	private Country_Group_Service country_Group_Service;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Country_Group saveCountry_Group(@RequestBody Country_Group country_Group) {
		return country_Group_Service.save(country_Group);
	}

}
