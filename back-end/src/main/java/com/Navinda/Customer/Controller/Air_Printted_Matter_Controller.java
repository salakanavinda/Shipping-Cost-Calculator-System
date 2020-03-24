package com.Navinda.Customer.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Navinda.Customer.Model.Air_Printted_Matter;
import com.Navinda.Customer.Service.Air_Printted_Matter_Service;

@RestController
@RequestMapping(value="/api/printted_matter")
public class Air_Printted_Matter_Controller {
	
	private Air_Printted_Matter_Service air_Printted_Matter_Service;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Air_Printted_Matter saveAir_Printted_Matter(@RequestBody Air_Printted_Matter air_Printted_Matter) {
		return air_Printted_Matter_Service.save(air_Printted_Matter);
	}

}
