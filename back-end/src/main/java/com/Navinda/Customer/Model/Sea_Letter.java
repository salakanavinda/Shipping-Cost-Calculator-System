package com.Navinda.Customer.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sea_Letter")
public class Sea_Letter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int initial_weight;
	
	private int initial_weight_price;
	
	private int from21to50;
	
	private int from51to100;
	
	private int from100to250;
	
	private int from251to500;
	
	private int from501to1000;
	
	private int from1001to2000;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getFrom21to50() {
		return from21to50;
	}

	public void setFrom21to50(int from21to50) {
		this.from21to50 = from21to50;
	}

	public int getFrom51to100() {
		return from51to100;
	}

	public void setFrom51to100(int from51to100) {
		this.from51to100 = from51to100;
	}

	public int getFrom100to250() {
		return from100to250;
	}

	public void setFrom100to250(int from100to250) {
		this.from100to250 = from100to250;
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

	public int getFrom1001to2000() {
		return from1001to2000;
	}

	public void setFrom1001to2000(int from1001to2000) {
		this.from1001to2000 = from1001to2000;
	}

	@Override
	public String toString() {
		return "Sea_Letter [id=" + id + ", initial_weight=" + initial_weight + ", initial_weight_price="
				+ initial_weight_price + ", from21to50=" + from21to50 + ", from51to100=" + from51to100
				+ ", from100to250=" + from100to250 + ", from251to500=" + from251to500 + ", from501to1000="
				+ from501to1000 + ", from1001to2000=" + from1001to2000 + "]";
	}
	
	

}
