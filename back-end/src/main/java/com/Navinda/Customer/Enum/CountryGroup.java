package com.Navinda.Customer.Enum;

public enum CountryGroup {
	
	A(0,"A","A"),
	
	B(1,"B","B"),
	
	C(2,"C","C"),
	
	D(3,"D","D"),
	
	E(4,"E","E"),
	
	F(5,"F","F"),
	
	G(6,"G","G");
	
	private int key;
	
	private String value;
	
	private String displayValue;

	private CountryGroup(int key, String value, String displayValue) {
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
