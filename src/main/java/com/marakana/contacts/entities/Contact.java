package com.marakana.contacts.entities;

import javax.persistence.*;

@Entity
public class Contact {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@Column
	private String phoneNumber;

	public Contact() {
	}

	public Contact(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return this.address;
	}
}
