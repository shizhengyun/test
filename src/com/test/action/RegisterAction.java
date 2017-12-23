package com.test.action;


import com.opensymphony.xwork2.ActionSupport;
import com.test.dao.RegistryDao;
import com.test.entity.User;


public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user;
	
	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String execute() throws Exception {
		RegistryDao.add(user);
		return SUCCESS;
	}
//	public String execute2() throws Exception {
//		SearchDao.search(user);
//		return ERROR;
//	}
	

}
