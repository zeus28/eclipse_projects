package com.marakana.contacts.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

//import javax.persistence.EntityManager;
//import javax.persistence.Persistence;
import com.marakana.contacts.entities.Address;
public interface AddressRepository extends JpaRepository<Address, Long> {

}
/*
public class AddressRepository extends Repository<Address> {
	public AddressRepository() {
		super(Address.class);
	}
}*/
