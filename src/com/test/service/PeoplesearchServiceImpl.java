package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.AbstractDao;
import com.test.dao.PeoplesearchDao;
import com.test.entity.People;

@Service("peoplesearchService")
public class PeoplesearchServiceImpl extends AbstractServiceImpl<People> implements PeoplesearchService {
	@Autowired
	private PeoplesearchDao peoplesearchDao;

	@Override
	public AbstractDao<People> getAbstractDao() {
		return peoplesearchDao;
	}

	@Override
	public List<People> findByPeoplename(String peoplename) {
//		HashMap<String,Object> params=new HashMap<String,Object>();
//		params.put("peopleName", peoplename);
		return peoplesearchDao.findByPeoplename(peoplename);
	}

}
