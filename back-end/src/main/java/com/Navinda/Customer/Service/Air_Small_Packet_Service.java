package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Air_Small_Packet;

public interface Air_Small_Packet_Service {
	
	Air_Small_Packet save(Air_Small_Packet air_Small_Packet);
	
	List<Air_Small_Packet> fetch();
	
	Air_Small_Packet fetchById(Integer id);
	
	Air_Small_Packet fetchByCategory(int category);

}
