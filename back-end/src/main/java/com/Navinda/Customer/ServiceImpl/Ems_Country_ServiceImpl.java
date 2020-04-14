package com.Navinda.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Ems_Country;
import com.Navinda.Customer.Repository.Ems_Country_Repository;
import com.Navinda.Customer.Service.Ems_Country_Service;

@Service
public class Ems_Country_ServiceImpl implements Ems_Country_Service{

	@Autowired
	private Ems_Country_Repository ems_Country_Repository;
	@Override
	public Ems_Country save(Ems_Country ems_Country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ems_Country> fetch() {
		// TODO Auto-generated method stub
		return ems_Country_Repository.findAll();
	}

	@Override
	public Ems_Country fetchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ems_Country fetchByName(String name) {
		// TODO Auto-generated method stub
		return ems_Country_Repository.getByName(name);
	}

}
