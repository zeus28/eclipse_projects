package com.marakana.contacts.entities;

import javax.persistence.*;

@Entity
public class Office extends UrlEntity {

	@Column(nullable = false, length = 64)
	private String name;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(optional = false)
	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Office() {
	}

	public Office(String name, Address address, Company company) {
		this.address = address;
		this.company = company;
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
