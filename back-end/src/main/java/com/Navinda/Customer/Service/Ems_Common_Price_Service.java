package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Ems_Common_Price;

public interface Ems_Common_Price_Service {
	
	Ems_Common_Price save(Ems_Common_Price ems_Common_Price);
	
	List<Ems_Common_Price> fetch();
	
	Ems_Common_Price fetchById(Integer id);
	
	Ems_Common_Price fetchByName(String name);

}
