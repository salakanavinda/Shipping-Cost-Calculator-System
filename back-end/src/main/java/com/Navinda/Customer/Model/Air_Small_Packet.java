package com.Navinda.Customer.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Air_Small_Packet")
public class Air_Small_Packet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String initial_weigth_type;
	
	private int intial_weight;
	
	private int initial_weight_price;
	
	private int from101to250;
	
	private int from251to500;
	
	private int from501to1000;
	
	private int category;

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInitial_weigth_type() {
		return initial_weigth_type;
	}

	public void setInitial_weigth_type(String initial_weigth_type) {
		this.initial_weigth_type = initial_weigth_type;
	}

	public int getIntial_weight() {
		return intial_weight;
	}

	public void setIntial_weight(int intial_weight) {
		this.intial_weight = intial_weight;
	}

	public int getInitial_weight_price() {
		return initial_weight_price;
	}

	public void setInitial_weight_price(int initial_weight_price) {
		this.initial_weight_price = initial_weight_price;
	}

	public int getFrom101to250() {
		return from101to250;
	}

	public void setFrom101to250(int from101to250) {
		this.from101to250 = from101to250;
	}

	public int getFrom251to500() {
		return from251to500;
	}

	public void setFrom251to500(int from251to500) {
		this.from251to500 = from251to500;
	}

	public int getFrom501to1000() {
		return from501to1000;
	}

	public void setFrom501to1000(int from501to1000) {
		this.from501to1000 = from501to1000;
	}

	@Override
	public String toString() {
		return "Air_Small_Packet [id=" + id + ", initial_weigth_type=" + initial_weigth_type + ", intial_weight="
				+ intial_weight + ", initial_weight_price=" + initial_weight_price + ", from101to250=" + from101to250
				+ ", from251to500=" + from251to500 + ", from501to1000=" + from501to1000 + ", category=" + category
				+ "]";
	}

}
