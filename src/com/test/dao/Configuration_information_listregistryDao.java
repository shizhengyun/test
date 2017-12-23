package com.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.entity.Configuration_information_list;
import com.test.sessionFactory.SessionFactoryUtil;

public class Configuration_information_listregistryDao {
	
	private static SessionFactory sessionFactory = null;

	public static String addconfiguration_information_list(Configuration_information_list configuration_information_list) {
		sessionFactory = SessionFactoryUtil.sessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Configuration_information_list configuration_information_list_add = configuration_information_list;
		
		
		session.save(configuration_information_list_add);
		
	
		String a = null;
		try{ 
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			 a = e.getCause().getCause().getLocalizedMessage();
			} 
		
		session.close();
		
		return a;
	}
}
