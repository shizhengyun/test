package com.test.dao;

import org.springframework.stereotype.Repository;

import com.test.entity.Configuration_information_list;
@Repository("configuration_information_listsearchDao")
public class Configuration_information_listsearchDaoImpl extends AbstractDaoImpl<Configuration_information_list> implements Configuration_information_listsearchDao {
	@Override
	public Class<Configuration_information_list> getEntityClass() {
		return Configuration_information_list.class;
	}
}
