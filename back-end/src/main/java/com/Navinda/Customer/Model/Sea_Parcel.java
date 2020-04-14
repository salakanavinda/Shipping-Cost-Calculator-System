package com.Navinda.Customer.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sea_Parcel")
public class Sea_Parcel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String countryName;
	
	private String initial_weight_type;
	
	private int initial_weight;
	
	private int initial_weight_price;
	
	private String additional_weight_type;
	
	private int additional_weight;
	
	private int additional_weight_price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getInitial_weight_type() {
		return initial_weight_type;
	}

	public void setInitial_weight_type(String initial_weight_type) {
		this.initial_weight_type = initial_weight_type;
	}

	public int getInitial_weight() {
		return initial_weight;
	}

	public void setInitial_weight(int initial_weight) {
		this.initial_weight = initial_weight;
	}

	public int getInitial_weight_price() {
		return initial_weight_price;
	}

	public void setInitial_weight_price(int initial_weight_price) {
		this.initial_weight_price = initial_weight_price;
	}

	public String getAdditional_weight_type() {
		return additional_weight_type;
	}

	public void setAdditional_weight_type(String additional_weight_type) {
		this.additional_weight_type = additional_weight_type;
	}

	public int getAdditional_weight() {
		return additional_weight;
	}

	public void setAdditional_weight(int additional_weight) {
		this.additional_weight = additional_weight;
	}

	public int getAdditional_weight_price() {
		return additional_weight_price;
	}

	public void setAdditional_weight_price(int additional_weight_price) {
		this.additional_weight_price = additional_weight_price;
	}

	@Override
	public String toString() {
		return "Air_Parcel [id=" + id + ", countryName=" + countryName + ", initial_weight_type=" + initial_weight_type
				+ ", initial_weight=" + initial_weight + ", initial_weight_price=" + initial_weight_price
				+ ", additional_weight_type=" + additional_weight_type + ", additional_weight=" + additional_weight
				+ ", additional_weight_price=" + additional_weight_price + "]";
	}

}
