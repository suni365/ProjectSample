package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Supliers {

	

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int suplierId;
	private String supliersName;
	
	
	
	
	public Supliers() {
		
	}
	
	
	public Supliers(int suplierId, String supliersName) {
		this.suplierId = suplierId;
		this.supliersName = supliersName;
	}


	public int getSuplierId() {
		return suplierId;
	}
	public void setSuplierId(int suplierId) {
		this.suplierId = suplierId;
	}
	public String getSupliersName() {
		return supliersName;
	}
	public void setSupliersName(String supliersName) {
		this.supliersName = supliersName;
	} 
	
	
	
}
