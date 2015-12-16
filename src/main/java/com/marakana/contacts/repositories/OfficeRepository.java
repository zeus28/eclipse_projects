package com.marakana.contacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

/*
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;*/
import com.marakana.contacts.entities.Office;

/*public class ContactRepository extends Repository<Contact> {
	public ContactRepository() {
		super(Contact.class);
	}
	
	
}*/
public interface OfficeRepository extends JpaRepository<Office, Long> {

}