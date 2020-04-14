package com.Navinda.Customer.Service;



public interface Rate_Service {
	
	double getPrice(int shipping_method,int item,double weight,String country);
	
	double getPriceForSeaMail(int shipping_method,int item,double weight);
	
	double getPriceForService(int shipping_method,int item,int itemType,int itemSubType);
	
	double getPriceForParcel(int shipping_method,double weight,String country);

}
