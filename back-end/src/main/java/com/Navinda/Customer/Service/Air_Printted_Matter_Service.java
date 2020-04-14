package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Air_Printted_Matter;

public interface Air_Printted_Matter_Service {
	
	    Air_Printted_Matter save(Air_Printted_Matter air_Printted_Matter);
		
		List<Air_Printted_Matter> fetch();
		
		Air_Printted_Matter fetchById(Integer id);
		
		Air_Printted_Matter fetchByCategory(int category);

}
