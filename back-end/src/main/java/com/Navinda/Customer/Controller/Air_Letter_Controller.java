package com.Navinda.Customer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Navinda.Customer.Model.Air_Letter;
import com.Navinda.Customer.Service.Air_Letter_Service;

@RestController
@RequestMapping(value="/api/air_letter")
public class Air_Letter_Controller {
	
	@Autowired
	private Air_Letter_Service air_Letter_Service;
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Air_Letter saveAir_letter(@RequestBody Air_Letter air_Letter) {
		return air_Letter_Service.save(air_Letter);
	}
	
	@RequestMapping(value="/{category}", method=RequestMethod.GET)
	public ResponseEntity<Air_Letter> getByCategory(@PathVariable Integer category) {
		Air_Letter air_Letter = air_Letter_Service.fetchByCategory(category);
		
		return new ResponseEntity<Air_Letter>(air_Letter,HttpStatus.OK);
	}

}
