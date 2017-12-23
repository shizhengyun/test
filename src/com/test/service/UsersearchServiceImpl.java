package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.AbstractDao;
import com.test.dao.UsersearchDao;
import com.test.entity.User;

@Service("usersearchService")
public class UsersearchServiceImpl extends AbstractServiceImpl<User> implements UsersearchService {
	@Autowired
	private UsersearchDao usersearchDao;

	@Override
	public AbstractDao<User> getAbstractDao() {
		return usersearchDao;
	}

	@Override
	public List<User> findByUsername(String username) {
//		HashMap<String,Object> params=new HashMap<String,Object>();
//		params.put("userName", username);
		return usersearchDao.findByUsername(username);
	}

}