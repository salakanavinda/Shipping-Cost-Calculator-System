package com.Navinda.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Navinda.Customer.Model.Air_Small_Packet;

public interface Air_Small_Packet_Repository extends JpaRepository<Air_Small_Packet,Integer>{
	
	@Query(value="SELECT * FROM Air_Small_Packet WHERE category =?1",nativeQuery = true)
	public Air_Small_Packet getByCategory(int category);

}
