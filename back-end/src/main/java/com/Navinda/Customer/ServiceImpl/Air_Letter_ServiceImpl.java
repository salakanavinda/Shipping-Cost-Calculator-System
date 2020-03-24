package com.Navinda.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Air_Letter;
import com.Navinda.Customer.Repository.Air_Letter_Repository;
import com.Navinda.Customer.Service.Air_Letter_Service;

@Service
public class Air_Letter_ServiceImpl implements Air_Letter_Service{

	@Autowired
	private Air_Letter_Repository air_Letter_Repository;
	
	@Override
	public Air_Letter save(Air_Letter air_Letter) {
		// TODO Auto-generated method stub
		return air_Letter_Repository.save(air_Letter);
	}

	@Override
	public List<Air_Letter> fetch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Air_Letter fetchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Air_Letter fetchByCategory(int category) {
		// TODO Auto-generated method stub
		return air_Letter_Repository.getByCategory(category);
	}

	

}
