package com.Navinda.Customer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Navinda.Customer.Model.Air_Small_Packet;
import com.Navinda.Customer.Service.Air_Small_Packet_Service;

@RestController
@RequestMapping(value="/api/small_packet")
public class Air_Small_Packet_Controller {
	
	@Autowired
	private Air_Small_Packet_Service air_Small_Packet_Service;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Air_Small_Packet saveAir_Small_Packet(@RequestBody Air_Small_Packet air_Small_Packet) {
		return air_Small_Packet_Service.save(air_Small_Packet);
	}

}
