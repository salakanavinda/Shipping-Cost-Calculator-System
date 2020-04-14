package com.Navinda.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Navinda.Customer.Model.Air_Letter;

public interface Air_Letter_Repository extends JpaRepository<Air_Letter,Integer>{
	
	@Query(value="SELECT * FROM Air_Letter WHERE category =?1",nativeQuery = true)
	public Air_Letter getByCategory(int category);

}
