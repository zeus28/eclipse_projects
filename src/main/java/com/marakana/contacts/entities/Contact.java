package com.marakana.contacts.entities;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Contact extends UrlEntity {

	@Column(nullable=false)
	@NotBlank
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

	
			

}
