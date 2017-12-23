package com.test.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.dao.PeopleregistryDao;
import com.test.entity.People;

public class PeopleregisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private People people;	

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}
	
	public void Peopleregister() throws Exception {
		ActionContext ac = ActionContext.getContext();
        String result;
		HttpServletResponse response = ServletActionContext.getResponse();
		// 以下代码从JSON.java中拷过来的
		response.setContentType("text/html");
		PrintWriter out;
		out = response.getWriter();
		if(PeopleregistryDao.addpeople(people)){
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
