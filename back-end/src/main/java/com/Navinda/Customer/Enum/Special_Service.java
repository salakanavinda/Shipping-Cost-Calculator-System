package com.Navinda.Customer.Enum;

public enum Special_Service {
	
	WAREHOUSE_CHARGING(0,"Warehousing Chrges (Per day)","Warehousing Chrges (Per day)"),
	
	EXPRESS_CHARGES(1,"Express Charges","Express Charges"),
	
	WITHDRWAL_FROM_POST(2,"Withdrawal From The Post","Withdrawal From The Post"),
	
	PACKET_HANDLING_CHARGES(3,"Packets Handling Charges","Packets Handling Charges"),
	
	PARCEL_HNADLING_CHARGES(4,"Parcle Handling Charges","Parcle Handling Charges"),
	
	INQUERY_FEES(5,"Inquiry Fee (For Registered Articles,Parcel and EMS","Inquiry Fee (For Registered Articles,Parcel and EMS"),
	
	REGISTRATION_FEE(6,"Registration Fee (LMP - Art 29.8)","Registration Fee (LMP - Art 29.8)"),
	
	ADVICE_OF_DELEVERY(7,"Advice of Delivery for Registered article","Advice of Delivery for Registered article"),
	
	MINIMUM_SURCHANGE(8,"Minimum Surchange on Underpaid Articles","Minimum Surchange on Underpaid Articles"),
	
	INTERNATIONAL_REPLY_COUPONS_SELL(9,"International Reply Coupons (Selling Price)","International Reply Coupons (Selling Price)"),

	INTERNATIONAL_REPLY_COUPONS_ENHA(10,"International Reply Coupons (Encashment in stamps)","International Reply Coupons (Encashment in stamps)"),
	
	INSUERENCE_FEE(11,"Insurance Fees (up to 4000.00 )","Insurance Fees (up to 4000.00 )"),
	
	FUMIGATION_FEES(12,"Fumigation Fees","Fumigation Fees"),
	
	LATE_FEES_FOR_POSTING(13,"Late fees for posting (Per item)","Late fees for posting (Per item)");
	
	private int key;
	
	private String value;
	
	private String displayValue;

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

	Special_Service(int key, String value, String displayValue) {
		this.key = key;
		this.value = value;
		this.displayValue = displayValue;
	}
	
	
	
	
	
}
