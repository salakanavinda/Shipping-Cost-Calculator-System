package com.Navinda.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Air_Printted_Matter;
import com.Navinda.Customer.Repository.Air_Printted_Matter_Repository;
import com.Navinda.Customer.Service.Air_Printted_Matter_Service;

@Service
public class Air_Printted_Matter_ServiceImpl implements Air_Printted_Matter_Service{

	@Autowired
	private Air_Printted_Matter_Repository air_Printted_Matter_Repository;
	
	@Override
	public Air_Printted_Matter save(Air_Printted_Matter air_Printted_Matter) {
		// TODO Auto-generated method stub
		return air_Printted_Matter_Repository.save(air_Printted_Matter);
	}

	@Override
	public List<Air_Printted_Matter> fetch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Air_Printted_Matter fetchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Air_Printted_Matter fetchByCategory(int category) {
		// TODO Auto-generated method stub
		return air_Printted_Matter_Repository.getByCategory(category);
	}

}
