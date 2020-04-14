package com.Navinda.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Sea_Parcel;
import com.Navinda.Customer.Repository.Sea_Parcel_Repository;
import com.Navinda.Customer.Service.Sea_Parcel_Service;

@Service
public class Sea_Parcel_ServiceImpl implements Sea_Parcel_Service{

	@Autowired
	private Sea_Parcel_Repository sea_Parcel_Repository;
	
	@Override
	public Sea_Parcel save(Sea_Parcel sea_Parcel) {
		return sea_Parcel_Repository.save(sea_Parcel);
	}

	@Override
	public List<Sea_Parcel> fetch() {
		// TODO Auto-generated method stub
		return sea_Parcel_Repository.findAll();
	}

	@Override
	public Sea_Parcel fetchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sea_Parcel fetchByName(String countryName) {
		return sea_Parcel_Repository.getByName(countryName);
	}

}
