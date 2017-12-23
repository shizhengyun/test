package com.test.service;

import java.util.List;

import com.test.entity.Configuration_information_list;

public interface Configuration_information_listService extends AbstractService<Configuration_information_list> {
	public List<Configuration_information_list> findconfiguration_information_listAll();
	public List<Configuration_information_list> findconfiguration_information_listAllcolumnname();
}