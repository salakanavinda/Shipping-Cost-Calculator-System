package com.Navinda.Customer.Service;

import java.util.List;

import com.Navinda.Customer.Model.Common_Property;

public interface Common_Property_Service {
	
	Common_Property save(Common_Property common_Property);
	
	List<Common_Property> fetch();
	
	Common_Property fetchById(Integer id);
	
	Common_Property fetchByKey(String key);

}
