package com.Navinda.Customer.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Navinda.Customer.Model.Air_Parcel;
import com.Navinda.Customer.Model.Country_Group;
import com.Navinda.Customer.Model.Ems_Country;
import com.Navinda.Customer.Model.Sea_Parcel;
import com.Navinda.Customer.Service.Air_Parcel_Service;
import com.Navinda.Customer.Service.Country_Group_Service;
import com.Navinda.Customer.Service.Ems_Country_Service;
import com.Navinda.Customer.Service.Sea_Parcel_Service;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping(value="api/country")
public class CountryController {
	
	@Autowired
	private Country_Group_Service country_Group_Service;
	
	@Autowired
	private Sea_Parcel_Service sea_Parcel_Service;
	
	@Autowired
	private Air_Parcel_Service air_Parcel_Service;
	
	@Autowired
	private Ems_Country_Service ems_Country_Service;
	
	@RequestMapping(value="/air_mail/", method=RequestMethod.GET)
	public List<String> getAll(){
		List<Country_Group> temp = country_Group_Service.fetch();
		List<String> countryList = new ArrayList<>();
		for(Country_Group cc : temp) {
			countryList.add(cc.getName());
		}
		
		return countryList;
	}
	
	@RequestMapping(value="/air_parcel/", method=RequestMethod.GET)
	public List<String> getAllAirParcelCountry(){
		
		List<Air_Parcel> temp = air_Parcel_Service.fetch();
		List<String> countryList = new ArrayList<>();
		for(Air_Parcel cc : temp) {
			countryList.add(cc.getCountryName());
		}
		return countryList;
	}
	
	@RequestMapping(value="/sea_parcel/", method=RequestMethod.GET)
	public List<String> getAllSeaParcelCountry(){
		
		List<Sea_Parcel> temp = sea_Parcel_Service.fetch();
		List<String> countryList = new ArrayList<>();
		for(Sea_Parcel cc : temp) {
			countryList.add(cc.getCountryName());
		}
		return countryList;
	}
	
	@RequestMapping(value="/ems/", method=RequestMethod.GET)
	public List<String> getAllEmsCountry(){
		List<Ems_Country> temp = ems_Country_Service.fetch();
		List<String> countryList = new ArrayList<>();
		for(Ems_Country cc : temp) {
			countryList.add(cc.getName());
		}
		return countryList;
	}

}
