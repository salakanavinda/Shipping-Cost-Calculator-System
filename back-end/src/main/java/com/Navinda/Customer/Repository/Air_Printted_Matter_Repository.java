package com.Navinda.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Navinda.Customer.Model.Air_Letter;
import com.Navinda.Customer.Model.Air_Printted_Matter;

public interface Air_Printted_Matter_Repository extends JpaRepository<Air_Printted_Matter,Integer>{
	
	@Query(value="SELECT * FROM Air_Printted_Matter WHERE category =?1",nativeQuery = true)
	public Air_Printted_Matter getByCategory(int category);

}
