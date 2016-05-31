package com.marakana.contacts.entities;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address extends BaseEntity {
	
	@Column(nullable =false)
	@NotBlank
	private String street;
	
	@Column(nullable =false)
	@NotBlank
	private String region;

	@Column(nullable =false,length=64)
	@NotBlank
	private String city;

	@Column(nullable =false,length=64)
	@NotBlank
	private String state;

	@Column(nullable =false,length=64)
	@NotBlank
	private String zip;

	public Address() {
	}

	public Address(String street, String city, String state, String zip, String region) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.region = region;
	}
	public String getRegion(){
		return region;
	}
	
	public void setRegion(String region) {
		this.region=region;
	}

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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
