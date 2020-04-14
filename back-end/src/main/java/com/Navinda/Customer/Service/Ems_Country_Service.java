package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Ems_Country;

public interface Ems_Country_Service {
	
	Ems_Country save(Ems_Country ems_Country);
	
	List<Ems_Country> fetch();
	
	Ems_Country fetchById(Integer id);
	
	Ems_Country fetchByName(String name);

}
