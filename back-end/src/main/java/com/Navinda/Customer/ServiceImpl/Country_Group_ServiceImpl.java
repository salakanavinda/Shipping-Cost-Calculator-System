package com.Navinda.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Country_Group;
import com.Navinda.Customer.Repository.Country_Group_Repository;
import com.Navinda.Customer.Service.Country_Group_Service;

@Service
public class Country_Group_ServiceImpl implements Country_Group_Service{

	@Autowired
	private Country_Group_Repository country_Group_Repository;
	
	@Override
	public Country_Group save(Country_Group country_Group) {
		
		return country_Group_Repository.save(country_Group);
	}

	@Override
	public List<Country_Group> fetch() {

		return country_Group_Repository.findAll();
	}

	@Override
	public Country_Group fetchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country_Group fetchByCountryName(String country) {
		
		return country_Group_Repository.getByCountryName(country);
	}

}
