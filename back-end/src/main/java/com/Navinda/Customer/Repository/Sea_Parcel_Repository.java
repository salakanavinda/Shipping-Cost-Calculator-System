package com.Navinda.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Navinda.Customer.Model.Sea_Parcel;

public interface Sea_Parcel_Repository extends JpaRepository<Sea_Parcel,Integer>{
	
	@Query(value="SELECT * FROM Sea_Parcel WHERE country_name =?1",nativeQuery = true)
	public Sea_Parcel getByName(String countryName);

}
