package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Ems_Merchandise_Price;

public interface Ems_Merchandise_Price_Service {

	Ems_Merchandise_Price save(Ems_Merchandise_Price ems_Document_Price);
	
	List<Ems_Merchandise_Price> fetch();
	
	Ems_Merchandise_Price fetchById(Integer id);
	
	Ems_Merchandise_Price fetchByName(String name);
}
