package com.Navinda.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Navinda.Customer.Model.Ems_Common_Price;

public interface Ems_Common_Price_Repository extends JpaRepository<Ems_Common_Price,Integer>{
	
	@Query(value="SELECT * FROM Ems_Common_Price WHERE name =?1",nativeQuery = true)
	public Ems_Common_Price getByName(String name);

}
