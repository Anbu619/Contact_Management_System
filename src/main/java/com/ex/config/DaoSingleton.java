package com.ex.config;

import com.ex.dao.ContactDao;
import com.ex.dao.UserDao;

public class DaoSingleton {

	private static UserDao userdao;
	private static ContactDao contactdao;
	
	private DaoSingleton() {
		
	}
	
	public static synchronized UserDao getUserDao() {
		if(userdao == null)
		{
			userdao = new UserDao();
		}
		return userdao;
	}
	public static synchronized ContactDao getContactDao() {
		if(contactdao == null)
		{
			contactdao = new ContactDao();
		}
		return contactdao;
	}
}
