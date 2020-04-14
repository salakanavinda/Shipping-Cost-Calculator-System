package com.Navinda.Customer.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Air_Letter;
import com.Navinda.Customer.Model.Air_Parcel;
import com.Navinda.Customer.Model.Air_Printted_Matter;
import com.Navinda.Customer.Model.Air_Small_Packet;
import com.Navinda.Customer.Model.Common_Property;
import com.Navinda.Customer.Model.Country_Group;
import com.Navinda.Customer.Model.Ems_Common_Price;
import com.Navinda.Customer.Model.Ems_Country;
import com.Navinda.Customer.Model.Ems_Document_Price;
import com.Navinda.Customer.Model.Ems_Merchandise_Price;
import com.Navinda.Customer.Model.Sea_Parcel;
import com.Navinda.Customer.Service.Air_Letter_Service;
import com.Navinda.Customer.Service.Air_Parcel_Service;
import com.Navinda.Customer.Service.Air_Printted_Matter_Service;
import com.Navinda.Customer.Service.Air_Small_Packet_Service;
import com.Navinda.Customer.Service.Common_Property_Service;
import com.Navinda.Customer.Service.Country_Group_Service;
import com.Navinda.Customer.Service.Ems_Common_Price_Service;
import com.Navinda.Customer.Service.Ems_Country_Service;
import com.Navinda.Customer.Service.Ems_Document_Price_Service;
import com.Navinda.Customer.Service.Ems_Merchandise_Price_Service;
import com.Navinda.Customer.Service.Rate_Service;
import com.Navinda.Customer.Service.Sea_Parcel_Service;

@Service
public class Rate_ServiceImpl implements Rate_Service{

	@Autowired
	private Air_Letter_Service air_Letter_Service;
	
	@Autowired
	private Country_Group_Service country_Group_Service;
	
	@Autowired
	private Common_Property_Service common_Property_Service;
	
	@Autowired
	private Air_Printted_Matter_Service air_Printted_Matter_Service;
	
	@Autowired
	private Air_Small_Packet_Service air_Small_Packet_Service;
	
	@Autowired
	private Air_Parcel_Service air_Parcel_Service;
	
	@Autowired
	private Sea_Parcel_Service sea_Parcel_Service;
	
	@Autowired
	private Ems_Country_Service ems_Country_Service;
	
	@Autowired
	private Ems_Common_Price_Service ems_Common_Price_Service;
	
	@Autowired
	private Ems_Document_Price_Service ems_Document_Price_Service;
	
	@Autowired
	private Ems_Merchandise_Price_Service ems_Merchandise_Price_Service;
	
	
	

	@Override
	public double getPrice(int shipping_method, int item,double weight, String country) {
        
		double price=0;
		
		switch(shipping_method) {
		   
		   case 0 :
			   boolean sus = false;
			   Common_Property Common_Property =  common_Property_Service.fetchByKey("AIR_MAIL_SUSPENDED_COUNTRY_LIST");
				 String[] ss = Common_Property.getValue().split(",");
				   
				 for(String s : ss) {
					   if(s.equalsIgnoreCase(country)) {
						   price = -2;
						   sus = true;
					   }
				 }
				if(!sus) {
					
				switch(item) {
					 case 0 :
	 
					    Country_Group country_group = country_Group_Service.fetchByCountryName(country);
					    	    
					    if(country_group != null) {
					    	    	
			    	    	Air_Letter air_Letter = air_Letter_Service.fetchByCategory(country_group.getCategory());
							
							//price = air_Letter.getInitial_weight_price();
							
							//String initial_weight_type = air_Letter.getInitial_weight_type();
							int initial_weight = air_Letter.getInitial_weight();
							int initial_weight_price = air_Letter.getInitial_weight_price();
							
							//String additional_weight_type = air_Letter.getAdditional_weight_type();
							int additional_weight = air_Letter.getAdditional_weight();
							int additional_weight_price = air_Letter.getAdditional_weight_price();
							
							if(initial_weight >= weight) {
								
								price = initial_weight_price;
								
							}else {
								//need to check every weights
								double additonal = weight-initial_weight;
								double additional_price = (additonal/additional_weight)*additional_weight_price;
								price = initial_weight_price + additional_price;
							}
					    	    	
					   }else {
					     price = -1;
					   }
					       break;
					  case 1 :
					    Country_Group country_group_printted = country_Group_Service.fetchByCountryName(country);
					    	    
					    if(country_group_printted != null) {
					    	    	
			    	    	Air_Printted_Matter Air_Printted_Matter = air_Printted_Matter_Service.fetchByCategory(country_group_printted.getCategory());
							
							//String initial_weight_type = air_Letter.getInitial_weight_type();
							int air_Printted_initial_weight = Air_Printted_Matter.getInitial_weight();
							int air_Printted_initial_weight_price = Air_Printted_Matter.getInitial_weight_price();
							
							//String additional_weight_type = air_Letter.getAdditional_weight_type();
							int air_Printted_additional_weight = Air_Printted_Matter.getAdditional_weight();
							int air_Printted_additional_weight_price = Air_Printted_Matter.getAdditional_weight_price();
	 						
							if(air_Printted_initial_weight >= weight) {
								
								price = Air_Printted_Matter.getInitial_weight_price();
								
							}else {
								//need to check every weights
								double additonal = weight-air_Printted_initial_weight;
								double additional_price = (additonal/air_Printted_additional_weight)*air_Printted_additional_weight_price;
								price = air_Printted_initial_weight_price + additional_price;
							}
					    	    	
			    	    }else {
			    	    	price =-1;
			    	    }
					    	  break;
					  case 2 :
				    	  Common_Property Common_PropertyPost =  common_Property_Service.fetchByKey("AIR_POST_CARDS");
				    	  price = Double.valueOf(Common_PropertyPost.getValue().toString());
				    	  break;
					  case 3 :
				    	  Common_Property Common_PropertyAreo =  common_Property_Service.fetchByKey("AIR_AEROGRAMMES");
				    	  price = Double.valueOf(Common_PropertyAreo.getValue().toString());
				    	  break;
					  case 4 :
					    	  
			    	      Country_Group country_group_samall_packets = country_Group_Service.fetchByCountryName(country);
			    	  
			    	      if(country_group_samall_packets != null) {
			    		     Air_Small_Packet air_Small_Packet = air_Small_Packet_Service.fetchByCategory(country_group_samall_packets.getCategory());
				    	  
				    	     int air_Small_packet_initial_weight_price = air_Small_Packet.getInitial_weight_price();
				    	     int air_Small_packet_initial_weight = air_Small_Packet.getIntial_weight();
				    	     int air_Small_packet_from101to250 = air_Small_Packet.getFrom101to250();
				    	     int air_Small_packet_from251to500 = air_Small_Packet.getFrom251to500();
				    	     int air_Small_packet_from501to1000 = air_Small_Packet.getFrom501to1000();
				    	  
				    	     if(air_Small_packet_initial_weight >= weight) {
				    		    price = air_Small_packet_initial_weight_price;  
				    	     }else if((weight > 100) && (weight <= 250)) {
				    		    price = air_Small_packet_from101to250;
				    	     }else if((weight > 250) && (weight <= 500)) {
				    		    price = air_Small_packet_from251to500;
				    	     }else if((weight > 500) && (weight <= 1000)) {
				    		    price = air_Small_packet_from501to1000;
				    	     }else {
				    		  
				    	     }
			    		  
			    	      }else {
			    		      price = -1;
			    	      }
					       break;
					    }
				}else {
					price = -2;
				}
			   
			   break;
			   
		   case 1 :
			   
			   switch(item) {
			   case 0:
				   //Sea_Letter sea_Letter = sea_Letter_Service.fetch(1);
				   
				   if(20 >= weight) {
					   price = 55; 
				   }else if((weight > 20) && (weight <=50)) {
					   price = 90;  
				   }else if((weight > 50) && (weight <=100)) {
					   price = 150;
				   }else if((weight > 100) && (weight <=250)) {
					   price = 325;
				   }else if((weight > 250) && (weight <=500)) {
					   price = 620;
				   }else if((weight > 500) && (weight <=1000)) {
					   price = 1205;
				   }else if((weight > 1000) && (weight <=2000)) {
					   price = 2380;
				   }
				   
				   break;
			   case 1:
				   
				   if(20 >= weight) {
					   price = 50; 
				   }else if((weight > 20) && (weight <=50)) {
					   price = 85;  
				   }else if((weight > 50) && (weight <=100)) {
					   price = 145;
				   }else if((weight > 100) && (weight <=250)) {
					   price = 320;
				   }else if((weight > 250) && (weight <=500)) {
					   price = 615;
				   }else if((weight > 500) && (weight <=1000)) {
					   price = 1200;
				   }else if((weight > 1000) && (weight <=2000)) {
					   price = 2375;
				   }
				   
				   break;
			   case 2:
				   price = 35;
				   break;
			   case 3:
				   price =-4;
				   break;
			   case 4:
				   
				   if(100 >= weight) {
					   price = 165; 
				   }else if((weight > 100) && (weight <=250)) {
					   price = 340;  
				   }else if((weight > 250) && (weight <=500)) {
					   price = 635;
				   }else if((weight > 500) && (weight <=1000)) {
					   price = 1220;
				   }
				   
				   break;
			   }
			   break;   
		   case 2 :
			   switch(item) {
			   case 0:
				   sus = false;
				   Common_Property =  common_Property_Service.fetchByKey("EMS_SUSPENDED_CONTRY_LIST");
				   ss = Common_Property.getValue().split(",");
				   
				   for(String s : ss) {
					   if(s.equalsIgnoreCase(country)) {
						   price = -2;
						   sus = true;
					   }
				   }
				   if(!sus) {
					   Common_Property =  common_Property_Service.fetchByKey("EMS_MAX_WEIGHT_COUNTRY");
					   ss = Common_Property.getValue().split(",");
					   
					   for(String s : ss) {
						   if(s.equalsIgnoreCase(country)) {
							   if(weight>20) {
								   price = -3;
								   sus = true;
								   break;
							   }
						   }
					   }
				   if(!sus) {
					   
				   Ems_Country ems_countryD = ems_Country_Service.fetchByName(country);
				   
				   weight = weight*1000;
				   if(ems_countryD.isCommon()) {
					   Ems_Common_Price ems_Common_Price = ems_Common_Price_Service.fetchByName(country);
					   if(ems_Common_Price != null) {
					   if(weight<=250) {
						   price = ems_Common_Price.getFrist250gPrice(); 
					   }else if(weight >250 && weight <=500) {
						   price = ems_Common_Price.getFrom251to500();
					   }else if(weight >500 && weight <=1000) {
						   price = ems_Common_Price.getFrom501to1000();
					   }else {
						   double newweight = weight - 1000;
						   if(newweight >0 && newweight<=10000) {
							   price = ems_Common_Price.getFrom501to1000() + Math.ceil((newweight/500))*ems_Common_Price.getAddtionalabove1kgto10kg();
						   }else if(newweight > 10000 && newweight<=20000) {
							   price = ems_Common_Price.getFrom501to1000() + Math.ceil((newweight/500))*ems_Common_Price.getAdditionalabove10kgto20kg();
						   }else if(newweight > 20000 && newweight<=30000) {
							   price = ems_Common_Price.getFrom501to1000() + Math.ceil((newweight/500))*ems_Common_Price.getAdditionalabove20kgto30kg();
						   }
					   }
					   }else {
						   price = -1;
					   }
				   }else {
					   Ems_Document_Price ems_Document_Price = ems_Document_Price_Service.fetchByName(country);
					   if(ems_Document_Price != null) {
					   if(weight<=250) {
						   price = ems_Document_Price.getInitialdocumentPrice(); 
					   }else if(weight >250 && weight <=500) {
						   price = ems_Document_Price.getFrom251to500();
					   }else if(weight >500 && weight <=1000) {
						   price = ems_Document_Price.getFrom501to1000();
					   }else {
						   double newweight = weight - 1000;
						   if(newweight >0 && newweight<=10000) {
							   price = ems_Document_Price.getFrom501to1000() + Math.ceil((newweight/500))*ems_Document_Price.getAddtionalabove1kgto10kg();
							   
						   }else if(newweight > 10000 && newweight<=20000) {
							   price = ems_Document_Price.getFrom501to1000() + Math.ceil((newweight/500))*ems_Document_Price.getAdditionalabove10kgto20kg();
						   }else if(newweight > 20000 && newweight<=30000) {
							   price = ems_Document_Price.getFrom501to1000() + Math.ceil((newweight/500))*ems_Document_Price.getAdditionalabove20kgto30kg();
						   }
						   
					   }
					   }else {
						   price = -1;
					   }
				   }
				   }
				   }
				   break;
			   case 1:
				   sus = false;
				   Common_Property =  common_Property_Service.fetchByKey("EMS_SUSPENDED_CONTRY_LIST");
				   ss = Common_Property.getValue().split(",");
				   
				   for(String s : ss) {
					   if(s.equalsIgnoreCase(country)) {
						   price = -2;
						   sus = true;
						   break;
					   }
				   }
				   if(!sus) {
					   Common_Property =  common_Property_Service.fetchByKey("EMS_MAX_WEIGHT_COUNTRY");
					   ss = Common_Property.getValue().split(",");
					   
					   for(String s : ss) {
						   if(s.equalsIgnoreCase(country)) {
							   if(weight>20) {
								   price = -3;
								   sus = true;
								   break;
							   }
							   
						   }
					   }
				   if(!sus) {
				   Ems_Country ems_countryM = ems_Country_Service.fetchByName(country);
				   weight = weight*1000;
				   if(ems_countryM.isCommon()) {
					   
					   Ems_Common_Price ems_Common_Price = ems_Common_Price_Service.fetchByName(country);
					   if(ems_Common_Price != null) {
					   if(weight<=250) {
						   price = ems_Common_Price.getFrist250gPrice(); 
					   }else if(weight >250 && weight <=500) {
						   price = ems_Common_Price.getFrom251to500();
					   }else if(weight >500 && weight <=1000) {
						   price = ems_Common_Price.getFrom501to1000();
					   }else {
						   
						   double newweight = weight - 1000;
						   if(newweight >0 && newweight<=10000) {
							   price = ems_Common_Price.getFrom501to1000() + Math.ceil((newweight/500))*ems_Common_Price.getAddtionalabove1kgto10kg();
						   }else if(newweight > 10000 && newweight<=20000) {
							   price = ems_Common_Price.getFrom501to1000() + Math.ceil((newweight/500))*ems_Common_Price.getAdditionalabove10kgto20kg();
						   }else if(newweight > 20000 && newweight<=30000) {
							   price = ems_Common_Price.getFrom501to1000() + Math.ceil((newweight/500))*ems_Common_Price.getAdditionalabove20kgto30kg();
						   }
						   
					   }
					   }else {
						   price =-1;
					   }
					   
				   }else {
					   Ems_Merchandise_Price ems_Merchandise_Price = ems_Merchandise_Price_Service.fetchByName(country);
					   if(ems_Merchandise_Price != null) {
					   if(weight<=250) {
						   price = ems_Merchandise_Price.getInitialmerchantdisePrice(); 
					   }else if(weight >250 && weight <=500) {
						   price = ems_Merchandise_Price.getFrom251to500();
					   }else if(weight >500 && weight <=1000) {
						   price = ems_Merchandise_Price.getFrom501to1000();
					   }else {
						   
						   double newweight = weight - 1000;
						   if(newweight > 0 && newweight<=10000) {
							   price = ems_Merchandise_Price.getFrom501to1000() + Math.ceil((newweight/500))*ems_Merchandise_Price.getAddtionalabove1kgto10kg();
						   }else if(newweight > 10000 && newweight<=20000) {
							   price = ems_Merchandise_Price.getFrom501to1000() + Math.ceil((newweight/500))*ems_Merchandise_Price.getAdditionalabove10kgto20kg();
						   }else if(newweight > 20000 && newweight<=30000) {
							   price = ems_Merchandise_Price.getFrom501to1000() + Math.ceil((newweight/500))*ems_Merchandise_Price.getAdditionalabove20kgto30kg();
						   }
					   }
					   }else {
						   price =-1;
					   }
				   }
				   }
				   break;
			   
			   }
			   }
			   break;
		   case 3 :
			   sus = false;
			   Common_Property =  common_Property_Service.fetchByKey("AIR_PARCEL_MAX_WEIGHT");
			   String s = Common_Property.getValue();
			   if(weight> Double.valueOf(s)) {
				   price = -6;
			   }else {
			   
			   Air_Parcel air_Parcel = air_Parcel_Service.fetchByName(country);
			   weight = weight*1000;
			   if(air_Parcel != null) {
				   if(air_Parcel.getInitial_weight() >= weight) {
					   price = air_Parcel.getInitial_weight_price();
				   }else {
					   double additional = weight - air_Parcel.getInitial_weight();
					   price = air_Parcel.getInitial_weight_price() + Math.ceil((additional/air_Parcel.getAdditional_weight()))*air_Parcel.getAdditional_weight_price();
				   } 
			   }else {
				   price = -1;
			   }
			   }
			  
			   break;
		   case 4:
			   sus = false;
			   Common_Property =  common_Property_Service.fetchByKey("SEA_PARCEL_MAX_WEIGHT");
			   s = Common_Property.getValue();
			   if(weight> Double.valueOf(s)) {
				   price = -6;
			   }else {
			   Sea_Parcel sea_Parcel = sea_Parcel_Service.fetchByName(country);
			   weight = weight*1000;
			   if(sea_Parcel != null) {
				   if(sea_Parcel.getInitial_weight() >= weight) {
					   price = sea_Parcel.getInitial_weight_price();
				   }else {
					   double additional = weight - sea_Parcel.getInitial_weight();
					   price = sea_Parcel.getInitial_weight_price() + Math.ceil((additional/sea_Parcel.getAdditional_weight()))*sea_Parcel.getAdditional_weight_price();
				   }
				   
			   }else {
				   price =-1;
			   }
			   }
			 
			   break;
		}
		
		return price;
	}


	@Override
	public double getPriceForService(int shipping_method, int item, int itemType, int itemSubType) {
		double price =0;
		if((shipping_method == 0) || (shipping_method == 1)) {
			switch(item) {
			  case 5:
				  switch(itemType) {
				   case 0:
			    	   price = 50;
			    	   break;
			       case 1:
			    	   price = 160;
			    	   break;
			       case 2:
			    	   price = 130;
			    	   break;
			       case 3:
			    	   price = 90;
			    	   break;
			       case 4:
			    	   price = 160;
			    	   break;
			       case 5:
			    	   price = -4;
			    	   break;
			       case 6:
			    	   price = 200;
			    	   break;
			       case 7:
			    	   price = 90;
			    	   break;
			       case 8:
			    	   price = 35;
			    	   break;
			       case 9:
			    	   price = 350;
			    	   break;
			       case 10:
			    	   price = 110;
			    	   break;
			       case 11:
			    	   switch(itemSubType) {
			    	   case 0:
			    		   price = 65;
			    		   break;
			    	   case 1:
			    		   price = 65;
			    		   break;
			    	   }
			    	   break;
			       case 12:
			    	   price = -5;
			    	   break;
			       case 13:
			    	   price = 20;
			    	   break;
				   }
				break;
			}
		}
		return price;
	}


	@Override
	public double getPriceForSeaMail(int shipping_method, int item, double weight) {
	
	 double price =0;
	 
     switch(item) {
	   case 0:
		   //Sea_Letter sea_Letter = sea_Letter_Service.fetch(1);
		   
		   if(20 >= weight) {
			   price = 55; 
		   }else if((weight > 20) && (weight <=50)) {
			   price = 90;  
		   }else if((weight > 50) && (weight <=100)) {
			   price = 150;
		   }else if((weight > 100) && (weight <=250)) {
			   price = 325;
		   }else if((weight > 250) && (weight <=500)) {
			   price = 620;
		   }else if((weight > 500) && (weight <=1000)) {
			   price = 1205;
		   }else if((weight > 1000) && (weight <=2000)) {
			   price = 2380;
		   }
		   
		   break;
	   case 1:
		   
		   if(20 >= weight) {
			   price = 50; 
		   }else if((weight > 20) && (weight <=50)) {
			   price = 85;  
		   }else if((weight > 50) && (weight <=100)) {
			   price = 145;
		   }else if((weight > 100) && (weight <=250)) {
			   price = 320;
		   }else if((weight > 250) && (weight <=500)) {
			   price = 615;
		   }else if((weight > 500) && (weight <=1000)) {
			   price = 1200;
		   }else if((weight > 1000) && (weight <=2000)) {
			   price = 2375;
		   }
		   
		   break;
	   case 2:
		   price = 35;
		   break;
	   case 3:
		   price =-4;
		   break;
	   case 4:
		   
		   if(100 >= weight) {
			   price = 165; 
		   }else if((weight > 100) && (weight <=250)) {
			   price = 340;  
		   }else if((weight > 250) && (weight <=500)) {
			   price = 635;
		   }else if((weight > 500) && (weight <=1000)) {
			   price = 1220;
		   }
		   
		   break;
	   }
	
		return price;
	}


	@Override
	public double getPriceForParcel(int shipping_method, double weight, String country) {
		
		double price =0;
		
		switch(shipping_method) {
		     case 3 :
			   Air_Parcel air_Parcel = air_Parcel_Service.fetchByName(country);
			   
			   if(air_Parcel != null) {
				   if(air_Parcel.getInitial_weight() >= weight) {
					   price = air_Parcel.getInitial_weight_price();
				   }else {
					   double additional = weight - air_Parcel.getInitial_weight();
					   price = air_Parcel.getInitial_weight_price() + (additional/air_Parcel.getAdditional_weight())*air_Parcel.getAdditional_weight_price();
				   } 
			   }else {
				   price = -1;
			   }
			  
			   break;
		   case 4:
			   Sea_Parcel sea_Parcel = sea_Parcel_Service.fetchByName(country);
			   
			   if(sea_Parcel != null) {
				   
				   if(sea_Parcel.getInitial_weight() >= weight) {
					   price = sea_Parcel.getInitial_weight_price();
				   }else {
					   double additional = weight - sea_Parcel.getInitial_weight();
					   price = sea_Parcel.getInitial_weight_price() + (additional/sea_Parcel.getAdditional_weight())*sea_Parcel.getAdditional_weight_price();
				   }
				   
			   }else {
				   price =-1;
			   }
			 
			   break;
		}
		return price;
	}

}
