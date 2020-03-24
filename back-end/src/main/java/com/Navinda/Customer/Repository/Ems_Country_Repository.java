package com.Navinda.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Navinda.Customer.Model.Ems_Country;

public interface Ems_Country_Repository extends JpaRepository<Ems_Country,Integer>{
	
	@Query(value="SELECT * FROM Ems_Country WHERE name =?1",nativeQuery = true)
	public Ems_Country getByName(String name);

}
