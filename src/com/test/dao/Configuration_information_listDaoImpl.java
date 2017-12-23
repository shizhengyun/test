package com.test.dao;

import org.springframework.stereotype.Repository;

import com.test.entity.Configuration_information_list;

@Repository("Configuration_information_listDao")
public  class Configuration_information_listDaoImpl extends AbstractDaoImpl<Configuration_information_list> implements Configuration_information_listDao{

	@Override
	public Class<Configuration_information_list> getEntityClass() {
		return Configuration_information_list.class;
	}

}
