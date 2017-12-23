package com.test.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.entity.User;
import com.test.service.UsersearchService;

@Component
@Scope("prototype")
public class UsersearchAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<User> myList;
	private String username;
	@Autowired
	private UsersearchService usersearchService;
	
	/**
	 * 构造方法
	 */
	public UsersearchAction() {
		// 初始化Map对象
		 myList = new ArrayList<User>();
	}



	public void usersearch() throws IOException{
		ActionContext ac = ActionContext.getContext();

		if (username == null || username.isEmpty()) {
			username = "";
		}

		List<User> users = usersearchService.findByUsername(username);
		HttpServletResponse response = ServletActionContext.getResponse();
		// 以下代码从JSON.java中拷过来的
		response.setContentType("text/html");
		PrintWriter out;
		out = response.getWriter();
		myList = users;
		Gson gson = new Gson();
		String data = gson.toJson(myList);
		out.println(data);
		out.flush();
		out.close();
		
//		ac.put("users", users);
//		return "main";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UsersearchService getUsersearchService() {
		return usersearchService;
	}

	public void setUsersearchService(UsersearchService usersearchService) {
		this.usersearchService = usersearchService;
	}

	public List<User> getDataList() {
		return myList;
	}


}
