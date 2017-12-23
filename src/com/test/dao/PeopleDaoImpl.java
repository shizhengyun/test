package com.test.dao;

import org.springframework.stereotype.Repository;

import com.test.entity.People;

@Repository("PeopleDao")
public class PeopleDaoImpl extends AbstractDaoImpl<People> implements PeopleDao{
	@Override
	public Class<People> getEntityClass() {
		return People.class;
	}


}
