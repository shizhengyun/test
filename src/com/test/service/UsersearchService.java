package com.test.service;

import java.util.List;

import com.test.entity.User;

public interface UsersearchService extends AbstractService<User> {
	public List<User> findByUsername(String username);
}
