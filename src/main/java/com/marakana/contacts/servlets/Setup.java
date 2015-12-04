package com.marakana.contacts.servlets;

//import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/*
import com.marakana.contacts.repositories.AddressRepository;
import com.marakana.contacts.repositories.ContactRepository;
import com.marakana.contacts.entities.*;
*/

@WebListener
public class Setup implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	
	public void contextInitialized(ServletContextEvent sce) {
		
		/*
		try {
			//ContactRepository contactRepository = new ContactRepository();
			//AddressRepository addressRepository = new AddressRepository();
			////contactRepository.init();
			//addressRepository.init();
			//Contact contact = new Contact("Kyriacos",(long)2);
			//Address address = new Address("Ermou 18", "Lmassol", "ddd", "2536");
			//addressRepository.create(address);
			//new AddressRepository().init();
			/*
			new ContactRepository().init();
			new ContactRepository().create(new Contact("Kyriacos",12L));
			new ContactRepository().create(new Contact("Michalis",13L));
			new ContactRepository().create(new Contact("Markos",14L));
			new ContactRepository().create(new Contact("Thanasis",15L));
			new ContactRepository().create(new Contact("Natasa",16L));
			*/
			
		
		//} catch (SQLException e) {
			//e.printStackTrace();
		//}
		
		
		
		

	}


}
