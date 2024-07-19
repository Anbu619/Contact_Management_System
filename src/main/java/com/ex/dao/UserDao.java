package com.ex.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ex.config.EMFSingleton;
import com.ex.entity.User;

public class UserDao {
	
	public boolean addUser(User user) {
		EntityManager em = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
			em.persist(user);
			
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
	public User findUserById(int userId) {
		EntityManager em = EMFSingleton.getFactory().createEntityManager();
		
		User user = em.find(User.class, userId);
		
		em.close();
		
		return user;
	}
	public boolean updateUser(User user) {
		EntityManager em = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
			em.merge(user);
			
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
	public boolean deleteUser(int userId) {
		EntityManager em = EMFSingleton.getFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
			User user = em.find(User.class, userId);
			em.remove(user);
			
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
	public User findUserByEmailAndPassword(String email, String password) {
		EntityManager em =EMFSingleton.getFactory().createEntityManager();
		
		User user = null;
		
		try {
			Query query = em.createQuery("from User where email= :email and password= :pwd");
			query.setParameter("email", email);
			query.setParameter("pwd", password);
			
			user = (User) query.getSingleResult();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return user;
		
	}
}
