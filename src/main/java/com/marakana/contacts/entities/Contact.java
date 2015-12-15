package com.marakana.contacts.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Contact {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;


	public Contact() {
	}

	public Contact(String name) {
		this.name = name;
		
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


}
