package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Ems_Document_Price;

public interface Ems_Document_Price_Service {

	Ems_Document_Price save(Ems_Document_Price ems_Document_Price);
	
	List<Ems_Document_Price> fetch();
	
	Ems_Document_Price fetchById(Integer id);
	
	Ems_Document_Price fetchByName(String name);
}
