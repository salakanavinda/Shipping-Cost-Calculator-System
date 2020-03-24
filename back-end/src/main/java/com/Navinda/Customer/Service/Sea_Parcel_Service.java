package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Sea_Parcel;

public interface Sea_Parcel_Service {
	
	    Sea_Parcel save(Sea_Parcel sea_Parcel);
		
		List<Sea_Parcel> fetch();
		
		Sea_Parcel fetchById(Integer id);
		
		Sea_Parcel fetchByName(String countryName);

}
