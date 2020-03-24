package com.Navinda.Customer.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Sea_Letter;
import com.Navinda.Customer.Repository.Sea_Letter_Repository;
import com.Navinda.Customer.Service.Sea_Letter_Service;

@Service
public class Sea_Letter_ServiceImpl implements Sea_Letter_Service{

	@Autowired
	private Sea_Letter_Repository sea_Letter_Repository;
	
	@Override
	public Sea_Letter fetch(Integer id) {
		return sea_Letter_Repository.getOne(id);
	}

}
