package com.marakana.contacts.entities;

import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

@Entity
public class Person extends Contact {
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	public Person() {}
	public Person(String name, Address address){
		super(name);
		this.address = address;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
