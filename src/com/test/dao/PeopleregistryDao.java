package com.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.entity.People;
import com.test.sessionFactory.SessionFactoryUtil;

public class PeopleregistryDao {
	
	private static SessionFactory sessionFactory = null;

	public static boolean addpeople(People people) {
		sessionFactory = SessionFactoryUtil.sessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		People people_add = people;
		session.saveOrUpdate(people_add);
		
		
		session.getTransaction().commit();
		
		session.close();
		return true;
	}


}
