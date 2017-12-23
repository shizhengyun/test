package com.test.service;

import java.util.List;

import com.test.entity.People;

public interface PeopleService extends AbstractService<People>{

	public List<People> findAllpeople();
	public List<People> findAllpeoplecolumnname();
}
