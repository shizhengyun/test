package com.test.dao;

import java.util.List;

public interface AbstractDao<T> {

	public List<T> findAll();
	public List<T> findconfiguration_information_listAll();
	public List<T> findAllcolumnname();
	public List<T> findconfiguration_information_listAllcolumnname();
	public List<T> findAllpeople();
	public List<T> findAllpeoplecolumnname();
	public List<T> findByUsername(String username);
	public List<T> findByPeoplename(String peoplename);
	public List<T> findByConfiguration_information_list(String configuration_information_listtext,String configuration_information_listcondition,String configuration_information_listpage,String configuration_information_listpagesize);
	public List<T> findByConfiguration_information_listcount(String configuration_information_listtext,String configuration_information_listcondition);
}
