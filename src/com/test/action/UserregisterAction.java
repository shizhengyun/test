package com.test.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.dao.UserregistryDao;
import com.test.entity.User;

public class UserregisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user;	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void Userregister() throws Exception {
		ActionContext ac = ActionContext.getContext();
        String result;
		HttpServletResponse response = ServletActionContext.getResponse();
		// 以下代码从JSON.java中拷过来的
		response.setContentType("text/html");
		PrintWriter out;
		out = response.getWriter();
		if(UserregistryDao.adduser(user)){
			result = "register successfully";		
		}
		else {result = "register falsely";}
		Gson gson = new Gson();
		String data = gson.toJson(result);
		out.println(data);
		out.flush();
		out.close();
	}

}
