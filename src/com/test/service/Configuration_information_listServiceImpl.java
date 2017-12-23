package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.AbstractDao;
import com.test.dao.Configuration_information_listDao;
import com.test.entity.Configuration_information_list;

@Service("configuration_information_listService")
public class Configuration_information_listServiceImpl extends AbstractServiceImpl<Configuration_information_list> implements Configuration_information_listService {
	@Autowired
	private Configuration_information_listDao configuration_information_listDao;

	@Override
	public AbstractDao<Configuration_information_list> getAbstractDao() {
		return configuration_information_listDao;
	}

	@Override
	public List<Configuration_information_list> findconfiguration_information_listAll() {
		
		return configuration_information_listDao.findconfiguration_information_listAll();
		
	}
	
	@Override
	public List<Configuration_information_list> findconfiguration_information_listAllcolumnname() {
		
		return configuration_information_listDao.findconfiguration_information_listAllcolumnname();
		
	}

}
