package com.marakana.contacts.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Repository<E> {

	private final EntityManager em = Persistence.createEntityManagerFactory("training").createEntityManager();
	private final Class<E> entityClass;
	
	Repository (Class<E> entityClass){
		this.entityClass = entityClass;
	}
	
	public E find(long id) {
		return em.find(entityClass, id);
	}

	public void save(E entity) {
		em.merge(entity);
	}

	public void delete(E entity) {
		em.remove(entity);
	}
	public List<E> findAll() {
		return em.createQuery("from " + this.entityClass.getSimpleName(),entityClass).getResultList();
	}
}
