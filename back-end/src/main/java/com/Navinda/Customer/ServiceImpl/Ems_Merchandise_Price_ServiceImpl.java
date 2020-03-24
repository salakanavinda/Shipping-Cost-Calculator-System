package com.Navinda.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Ems_Merchandise_Price;
import com.Navinda.Customer.Repository.Ems_Merchandise_Price_Repository;
import com.Navinda.Customer.Service.Ems_Merchandise_Price_Service;

@Service
public class Ems_Merchandise_Price_ServiceImpl implements Ems_Merchandise_Price_Service{

	@Autowired
	private Ems_Merchandise_Price_Repository ems_Merchandise_Price_Repository;
	
	@Override
	public Ems_Merchandise_Price save(Ems_Merchandise_Price ems_Document_Price) {
		// TODO Auto-generated method stub
		return ems_Merchandise_Price_Repository.save(ems_Document_Price);
	}

	@Override
	public List<Ems_Merchandise_Price> fetch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ems_Merchandise_Price fetchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ems_Merchandise_Price fetchByName(String name) {
		// TODO Auto-generated method stub
		return ems_Merchandise_Price_Repository.getByName(name);
	}

}
