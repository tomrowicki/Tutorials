package org.javabrains.koushik.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // tells Hibernate objects of this class will be embedded inside other objects
public class Address {

	private String street;
	@Column(name="City_Name")
	private String city;
	private String state;
	private String pincode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}		
}
