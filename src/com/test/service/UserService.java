package com.test.service;

import java.util.List;

import com.test.entity.User;

public interface UserService extends AbstractService<User> {
	public List<User> findAll();
	public List<User> findAllcolumnname();
}
