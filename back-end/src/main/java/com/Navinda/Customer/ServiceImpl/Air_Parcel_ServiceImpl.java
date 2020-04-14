package com.Navinda.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Air_Parcel;
import com.Navinda.Customer.Repository.Air_Parcel_Repository;
import com.Navinda.Customer.Service.Air_Parcel_Service;

@Service
public class Air_Parcel_ServiceImpl implements Air_Parcel_Service{

	@Autowired
	private Air_Parcel_Repository air_Parcel_Repository;
	
	@Override
	public Air_Parcel save(Air_Parcel air_Parcel) {
		return air_Parcel_Repository.save(air_Parcel);
	}

	@Override
	public List<Air_Parcel> fetch() {
		// TODO Auto-generated method stub
		return air_Parcel_Repository.findAll();
	}

	@Override
	public Air_Parcel fetchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Air_Parcel fetchByName(String countryName) {
		return air_Parcel_Repository.getByName(countryName);
	}

}
