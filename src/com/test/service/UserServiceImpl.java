package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.AbstractDao;
import com.test.dao.UserDao;
import com.test.entity.User;

@Service("userService")
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public AbstractDao<User> getAbstractDao() {
		return userDao;
	}

	@Override
	public List<User> findAll() {
		
		return userDao.findAll();
		
	}
	
	@Override
	public List<User> findAllcolumnname() {
		
		return userDao.findAllcolumnname();
		
	}

}
