package com.Navinda.Customer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Navinda.Customer.Model.Air_Letter;
import com.Navinda.Customer.Model.Common_Property;
import com.Navinda.Customer.Service.Common_Property_Service;

@RestController
@RequestMapping(value="api/reference_data")
public class Referrenc_Data_Controller {
	
	@Autowired
	private Common_Property_Service common_Property_Service;

	@RequestMapping(value="/block_country/{shipping_method}", method=RequestMethod.GET)
	public ResponseEntity<Common_Property> getBlockCountry(@PathVariable Integer shipping_method) {
		String method = null;
		
		if(shipping_method == 0) {
			
			method = "AIR_MAIL_SUSPENDED_COUNTRY_LIST";
			
		}else if(shipping_method == 1) {
			
		}else if(shipping_method == 2) {
			
		}
		
		Common_Property Common_Property = common_Property_Service.fetchByKey(method);
		
		return new ResponseEntity<Common_Property>(Common_Property,HttpStatus.OK);
	}
}
