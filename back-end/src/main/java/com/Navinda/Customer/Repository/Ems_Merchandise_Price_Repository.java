package com.Navinda.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Navinda.Customer.Model.Ems_Merchandise_Price;

public interface Ems_Merchandise_Price_Repository extends JpaRepository<Ems_Merchandise_Price,Integer>{
	
	@Query(value="SELECT * FROM Ems_Merchandise_Price WHERE name =?1",nativeQuery = true)
	public Ems_Merchandise_Price getByName(String name);

}
