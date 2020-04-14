package com.Navinda.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Navinda.Customer.Model.Common_Property;
import com.Navinda.Customer.Repository.Common_Property_Repository;
import com.Navinda.Customer.Service.Common_Property_Service;

@Service
public class Common_Property_ServiceImpl implements Common_Property_Service{

	@Autowired
	private Common_Property_Repository common_Property_Repository;
	
	@Override
	public Common_Property save(Common_Property common_Property) {
		
		return common_Property_Repository.save(common_Property);
	}

	@Override
	public List<Common_Property> fetch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Common_Property fetchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Common_Property fetchByKey(String key) {
		
		return common_Property_Repository.getByKey(key);
	}

}
