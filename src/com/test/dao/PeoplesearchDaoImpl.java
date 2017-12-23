package com.test.dao;

import org.springframework.stereotype.Repository;

import com.test.entity.People;

@Repository("peoplesearchDao")
public class PeoplesearchDaoImpl extends AbstractDaoImpl<People> implements PeoplesearchDao{

	@Override
	public Class<People> getEntityClass() {
		return People.class;
	}

}
