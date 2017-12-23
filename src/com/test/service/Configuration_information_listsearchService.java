package com.test.service;

import java.util.List;

import com.test.entity.Configuration_information_list;

public interface Configuration_information_listsearchService extends AbstractService<Configuration_information_list> {
	public List<Configuration_information_list> findByConfiguration_information_list(String configuration_information_listtext,String configuration_information_listcondition,String configuration_information_listpage,String configuration_information_listpagesize);

	public List<Configuration_information_list> findByConfiguration_information_listcount(
			String configuration_information_listtext,
			String configuration_information_listcondition);
}
