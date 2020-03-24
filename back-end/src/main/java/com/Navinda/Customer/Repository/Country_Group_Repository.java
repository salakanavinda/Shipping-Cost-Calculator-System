package com.Navinda.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Navinda.Customer.Model.Country_Group;

public interface Country_Group_Repository extends JpaRepository<Country_Group,Integer>{
	
	@Query(value="SELECT * FROM Country_Group WHERE name =?1",nativeQuery = true)
	public Country_Group getByCountryName(String name);

}
