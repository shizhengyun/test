package com.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.entity.User;
import com.test.sessionFactory.SessionFactoryUtil;

public class RegistryDao {

	private static SessionFactory sessionFactory = null;

	public static void add(User user) {
		sessionFactory = SessionFactoryUtil.sessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		User user_add = user;
		session.saveOrUpdate(user_add);
		
		
		session.getTransaction().commit();
		
		session.close();
	}

	
}
