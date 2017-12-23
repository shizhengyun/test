package com.test.dao;

import org.springframework.stereotype.Repository;

import com.test.entity.User;

@Repository("UserDao")
public  class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao{

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

}
