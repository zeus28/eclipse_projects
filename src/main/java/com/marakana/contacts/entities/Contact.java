package com.marakana.contacts.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Contact extends BaseEntity {

	@Column
	private String name;

	public Contact() {
	}

	public Contact(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract String getUrl();
			

}
