package com.marakana.contacts.entities;

import javax.persistence.*;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	
	@Column
	private Long addressId;
	
	@Column 
	private String phoneNumber;

	public Contact() {
	}

	public Contact(String name,Long addressId) {
		this.name = name;
		this.addressId = addressId;
	}

	public Long getId(){
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddressId(Long addressId){
		this.addressId = addressId;
	}
	public long getAddressId() {
		return addressId;
	}
}
