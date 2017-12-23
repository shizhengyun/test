package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.AbstractDao;
import com.test.dao.Configuration_information_listsearchDao;
import com.test.entity.Configuration_information_list;
@Service("configuration_information_listsearchService")
public class Configuration_information_listsearchServiceImpl extends AbstractServiceImpl<Configuration_information_list> implements Configuration_information_listsearchService {
	@Autowired
	private Configuration_information_listsearchDao configuration_information_listsearchDao;

	@Override
	public AbstractDao<Configuration_information_list> getAbstractDao() {
		return configuration_information_listsearchDao;
	}

	@Override
	public List<Configuration_information_list> findByConfiguration_information_list(String configuration_information_listtext,String configuration_information_listcondition,String configuration_information_listpage,String configuration_information_listpagesize) {
//		HashMap<String,Object> params=new HashMap<String,Object>();
//		params.put("peopleName", peoplename);
		return configuration_information_listsearchDao.findByConfiguration_information_list(configuration_information_listtext,configuration_information_listcondition,configuration_information_listpage,configuration_information_listpagesize);
	}

	@Override
	public List<Configuration_information_list> findByConfiguration_information_listcount(
			String configuration_information_listtext,
			String configuration_information_listcondition) {
		// TODO 自動生成されたメソッド・スタブ
		return configuration_information_listsearchDao.findByConfiguration_information_listcount(configuration_information_listtext,configuration_information_listcondition);
	}
}
