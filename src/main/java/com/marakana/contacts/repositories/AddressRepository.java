package com.marakana.contacts.repositories;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import com.marakana.contacts.entities.Address;
public class AddressRepository {

	
	private final EntityManager em = Persistence.createEntityManagerFactory("training").createEntityManager();

	public Address find(long id){
		return em.find(Address.class, id);
	}

	public void save(Address address) {
		em.merge(address);
	}

	public void delete(Address address) {
		em.remove(address);
	}

}
