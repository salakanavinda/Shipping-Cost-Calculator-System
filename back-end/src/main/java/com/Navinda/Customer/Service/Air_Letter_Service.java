package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Air_Letter;

public interface Air_Letter_Service {
	
    Air_Letter save(Air_Letter air_Letter);
	
	List<Air_Letter> fetch();
	
	Air_Letter fetchById(Integer id);
	
	Air_Letter fetchByCategory(int category);

}
