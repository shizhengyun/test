package com.test.service;

import com.test.dao.AbstractDao;

public abstract class AbstractServiceImpl<T> implements AbstractService<T> {

	public abstract AbstractDao<T> getAbstractDao();

}
