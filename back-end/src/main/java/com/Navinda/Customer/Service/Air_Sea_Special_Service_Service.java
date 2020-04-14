package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Air_Sea_Special_Service;

public interface Air_Sea_Special_Service_Service {
	
	Air_Sea_Special_Service save(Air_Sea_Special_Service air_Letter);
	
	List<Air_Sea_Special_Service> fetch();
	
	Air_Sea_Special_Service fetchById(Integer id);

}
