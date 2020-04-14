package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Air_Parcel;

public interface Air_Parcel_Service {
	
    Air_Parcel save(Air_Parcel air_Parcel);
	
	List<Air_Parcel> fetch();
	
	Air_Parcel fetchById(Integer id);
	
	Air_Parcel fetchByName(String countryName);

}
