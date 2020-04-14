package com.Navinda.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Navinda.Customer.Model.Common_Property;

public interface Common_Property_Repository extends JpaRepository<Common_Property,Integer>{
	
	@Query(value="SELECT * FROM Common_Property WHERE key_one =?1",nativeQuery = true)
	public Common_Property getByKey(String key);

}
