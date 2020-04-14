package com.Navinda.Customer.Enum;

public enum Special_Service_Sub_Service {

	LETTER(0,"Letter (for every Rs 400.00 or Part thereof","Letter (for every Rs 400.00 or Part thereof"),
	
	PARCEL(1,"Parcel (foe every Rs 645.00 or part thereof","Parcel (foe every Rs 645.00 or part thereof");
	
	private int key;
	
	private String value;
	
	private String displayValue;

    Special_Service_Sub_Service(int key, String value, String displayValue) {
		this.key = key;
		this.value = value;
		this.displayValue = displayValue;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	
    
	
}
