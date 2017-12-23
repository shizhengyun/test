package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.AbstractDao;
import com.test.dao.PeopleDao;
import com.test.entity.People;
@Service("peopleService")
public class PeopleServiceImpl extends AbstractServiceImpl<People> implements PeopleService {
	@Autowired
	private PeopleDao peopleDao;

	@Override
	public AbstractDao<People> getAbstractDao() {
		return peopleDao;
	}
	@Override
	public List<People> findAllpeople() {
		
		return peopleDao.findAllpeople();
		
	}
	
	@Override
	public List<People> findAllpeoplecolumnname() {
		
		return peopleDao.findAllpeoplecolumnname();
		
	}

}
