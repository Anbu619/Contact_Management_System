package com.ex.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ex.config.EMFSingleton;
import com.ex.entity.Contact;
import com.ex.entity.User;

public class ContactDao {

	public boolean addConatct(Contact contact) {
		EntityManager em = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
			em.persist(contact);
			
			et.commit();
		
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
	public Contact findContactById(int contactId) {
		EntityManager em = EMFSingleton.getFactory().createEntityManager();
		
		Contact contact = em.find(Contact.class, contactId);
		
		em.close();
		
		return contact;
	}
	public boolean updateContact(Contact contact) {
		EntityManager em = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
			em.merge(contact);
			
			et.commit();
		
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
	public boolean deleteContact(int contactId) {
		EntityManager em = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
			Contact contact = em.find(Contact.class, contactId);
			em.remove(contact);
			
			et.commit();
		
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
	}
 
}
