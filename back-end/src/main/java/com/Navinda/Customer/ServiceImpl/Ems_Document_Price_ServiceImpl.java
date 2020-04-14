package com.Navinda.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Ems_Document_Price;
import com.Navinda.Customer.Repository.Ems_Document_Price_Repository;
import com.Navinda.Customer.Service.Ems_Document_Price_Service;

@Service
public class Ems_Document_Price_ServiceImpl implements Ems_Document_Price_Service{

	@Autowired
	private Ems_Document_Price_Repository ems_Document_Price_Repository;
	@Override
	public Ems_Document_Price save(Ems_Document_Price ems_Document_Price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ems_Document_Price> fetch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ems_Document_Price fetchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ems_Document_Price fetchByName(String name) {
		// TODO Auto-generated method stub
		return ems_Document_Price_Repository.getByName(name);
	}

}
