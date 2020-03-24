package com.Navinda.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Navinda.Customer.Model.Ems_Document_Price;

public interface Ems_Document_Price_Repository extends JpaRepository<Ems_Document_Price,Integer>{
	
	@Query(value="SELECT * FROM Ems_Document_Price WHERE name =?1",nativeQuery = true)
	public Ems_Document_Price getByName(String name);

}
