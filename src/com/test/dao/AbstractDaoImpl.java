package com.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked" })
	public List<T> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("select * from student " );
		return q.list();
	}
	public List<T> findconfiguration_information_listAll() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("select * from configuration_information_list limit 20 ");
		return q.list();
	}
	@SuppressWarnings({ "unchecked" })
	public List<T> findconfiguration_information_listAllcolumnname() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("SELECT column_name FROM information_schema.columns WHERE table_name   = 'configuration_information_list'");
		return q.list();
	}
	@SuppressWarnings({ "unchecked" })
	public List<T> findAllcolumnname() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("SELECT column_name FROM information_schema.columns WHERE table_name   = 'student'");
		return q.list();
	}
	public List<T> findAllpeople() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("select * from people");
		return q.list();
	}
	@SuppressWarnings({ "unchecked" })
	public List<T> findAllpeoplecolumnname() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("SELECT column_name FROM information_schema.columns WHERE table_name   = 'people'");
		return q.list();
	}
	@SuppressWarnings({ "unchecked" })
	public List<T> findByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		if (username == null || username.isEmpty()) {
			username = "is not null";
		}
		else{
			username = "='" + username + "'";
		}
		Query q = session.createSQLQuery("select * from student where username " + username );
		return q.list();
	}
	@SuppressWarnings({ "unchecked" })
	public List<T> findByPeoplename(String peoplename) {
		Session session = sessionFactory.getCurrentSession();
		if (peoplename == null || peoplename.isEmpty()) {
			peoplename = "is not null";
		}
		else{
			peoplename = "='" + peoplename + "'";
		}
		Query q = session.createSQLQuery("select * from people where peoplename " + peoplename  );
		return q.list();
	}
	@SuppressWarnings({ "unchecked" })
	public List<T> findByConfiguration_information_list(String configuration_information_listtext,String configuration_information_listcondition,String configuration_information_listpage,String configuration_information_listpagesize) {
		Session session = sessionFactory.getCurrentSession();
		if (configuration_information_listtext == null || configuration_information_listtext.isEmpty()) {
			configuration_information_listtext = "is not null";
		}
		else{
			configuration_information_listtext = "='" + configuration_information_listtext + "'";
		}
		if (configuration_information_listcondition == null || configuration_information_listcondition.isEmpty()) {
			configuration_information_listcondition = " row_id ";
		}
		else{
			configuration_information_listtext =  configuration_information_listtext ;
		}
		Query q = session.createSQLQuery("select * from configuration_information_list where " + configuration_information_listcondition +" " +configuration_information_listtext+ " order by row_id" + " limit " + Integer.parseInt(configuration_information_listpagesize)+" " + "offset "+" "+Integer.parseInt(configuration_information_listpagesize)*(Integer.parseInt(configuration_information_listpage)-1));
		List myList = new ArrayList();
		myList=q.list();
		return q.list(); 
	}
	@SuppressWarnings({ "unchecked" })
	public List<T> findByConfiguration_information_listcount(String configuration_information_listtext,String configuration_information_listcondition) {
		Session session = sessionFactory.getCurrentSession();
		if (configuration_information_listtext == null || configuration_information_listtext.isEmpty()) {
			configuration_information_listtext = "is not null";
		}
		else{
			configuration_information_listtext = "='" + configuration_information_listtext + "'";
		}
		if (configuration_information_listcondition == null || configuration_information_listcondition.isEmpty()) {
			configuration_information_listcondition = " row_id ";
		}
		else{
			configuration_information_listtext =  configuration_information_listtext ;
		}
		Query q = session.createSQLQuery("select count(*) from configuration_information_list where " + configuration_information_listcondition +" " +configuration_information_listtext  );
		
		return q.list();
		
	}
	public abstract Class<T> getEntityClass();

}

