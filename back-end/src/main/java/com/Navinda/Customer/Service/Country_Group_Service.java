package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Country_Group;

public interface Country_Group_Service {
	
    Country_Group save(Country_Group country_Group);
	
	List<Country_Group> fetch();
	
	Country_Group fetchById(Integer id);
	
	Country_Group fetchByCountryName(String country);

}
