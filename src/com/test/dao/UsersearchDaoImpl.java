package com.test.dao;

import org.springframework.stereotype.Repository;

import com.test.entity.User;

@Repository("usersearchDao")
public class UsersearchDaoImpl extends AbstractDaoImpl<User> implements UsersearchDao{

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

}
