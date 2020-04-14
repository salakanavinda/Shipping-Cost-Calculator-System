package com.Navinda.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Navinda.Customer.Model.Air_Parcel;

public interface Air_Parcel_Repository extends JpaRepository<Air_Parcel,Integer>{
	
	@Query(value="SELECT * FROM Air_Parcel WHERE country_name =?1",nativeQuery = true)
	public Air_Parcel getByName(String countryName);

}
