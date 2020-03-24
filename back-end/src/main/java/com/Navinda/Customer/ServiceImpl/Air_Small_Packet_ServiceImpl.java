package com.Navinda.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Air_Small_Packet;
import com.Navinda.Customer.Repository.Air_Small_Packet_Repository;
import com.Navinda.Customer.Service.Air_Small_Packet_Service;

@Service
public class Air_Small_Packet_ServiceImpl implements Air_Small_Packet_Service{

	@Autowired
	private Air_Small_Packet_Repository air_Small_Packet_Repository;
	
	@Override
	public Air_Small_Packet save(Air_Small_Packet air_Small_Packet) {
		
		return air_Small_Packet_Repository.save(air_Small_Packet);
	}

	@Override
	public List<Air_Small_Packet> fetch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Air_Small_Packet fetchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Air_Small_Packet fetchByCategory(int category) {
		
		return air_Small_Packet_Repository.getByCategory(category);
	}

}
