package com.Navinda.Customer.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ems_Document_Price")
public class Ems_Document_Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private int initialdocumentPrice;
	
	private int from251to500;
	
	private int from501to1000;
	
    private int addtionalabove1kgto10kg;
	
	private int additionalabove10kgto20kg;
	
	private int additionalabove20kgto30kg;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInitialdocumentPrice() {
		return initialdocumentPrice;
	}

	public void setInitialdocumentPrice(int initialdocumentPrice) {
		this.initialdocumentPrice = initialdocumentPrice;
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

	public int getAddtionalabove1kgto10kg() {
		return addtionalabove1kgto10kg;
	}

	public void setAddtionalabove1kgto10kg(int addtionalabove1kgto10kg) {
		this.addtionalabove1kgto10kg = addtionalabove1kgto10kg;
	}

	public int getAdditionalabove10kgto20kg() {
		return additionalabove10kgto20kg;
	}

	public void setAdditionalabove10kgto20kg(int additionalabove10kgto20kg) {
		this.additionalabove10kgto20kg = additionalabove10kgto20kg;
	}

	public int getAdditionalabove20kgto30kg() {
		return additionalabove20kgto30kg;
	}

	public void setAdditionalabove20kgto30kg(int additionalabove20kgto30kg) {
		this.additionalabove20kgto30kg = additionalabove20kgto30kg;
	}
	
	

}
