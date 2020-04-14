package com.Navinda.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Ems_Common_Price;
import com.Navinda.Customer.Repository.Ems_Common_Price_Repository;
import com.Navinda.Customer.Service.Ems_Common_Price_Service;

@Service
public class Ems_Common_Price_ServiceImpl implements Ems_Common_Price_Service{

	@Autowired
	private Ems_Common_Price_Repository ems_Common_Price_Repository;
	@Override
	public Ems_Common_Price save(Ems_Common_Price ems_Common_Price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ems_Common_Price> fetch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ems_Common_Price fetchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ems_Common_Price fetchByName(String name) {
		// TODO Auto-generated method stub
		return ems_Common_Price_Repository.getByName(name);
	}

}
