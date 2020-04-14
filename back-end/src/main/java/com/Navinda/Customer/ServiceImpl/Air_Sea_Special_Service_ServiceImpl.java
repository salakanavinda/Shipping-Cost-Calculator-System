package com.Navinda.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Air_Sea_Special_Service;
import com.Navinda.Customer.Repository.Air_Sea_Special_Service_Repository;
import com.Navinda.Customer.Service.Air_Sea_Special_Service_Service;

@Service
public class Air_Sea_Special_Service_ServiceImpl implements Air_Sea_Special_Service_Service{

	@Autowired
	private Air_Sea_Special_Service_Repository air_Sea_Special_Service_Repository;
	@Override
	public Air_Sea_Special_Service save(Air_Sea_Special_Service air_Sea_Special_Service) {
		return air_Sea_Special_Service_Repository.save(air_Sea_Special_Service);
	}

	@Override
	public List<Air_Sea_Special_Service> fetch() {
		return air_Sea_Special_Service_Repository.findAll();
	}

	@Override
	public Air_Sea_Special_Service fetchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
