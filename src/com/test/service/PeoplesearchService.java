package com.test.service;

import java.util.List;

import com.test.entity.People;

public interface PeoplesearchService extends AbstractService<People> {
	public List<People> findByPeoplename(String peoplename);
}
