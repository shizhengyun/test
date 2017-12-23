package com.test.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.dao.Configuration_information_listregistryDao;
import com.test.entity.Configuration_information_list;

public class Configuration_information_listregisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Configuration_information_list configuration_information_list;	

	public Configuration_information_list getConfiguration_information_list() {
		return configuration_information_list;
	}

	public void setConfiguration_information_list(Configuration_information_list configuration_information_list) {
		this.configuration_information_list = configuration_information_list;
	}
	
	public void Configuration_information_listregister() throws Exception {
		ActionContext ac = ActionContext.getContext();
        String result;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		if(Configuration_information_listregistryDao.addconfiguration_information_list(configuration_information_list) != null){
			result = Configuration_information_listregistryDao.addconfiguration_information_list(configuration_information_list)+".  register false!";		
		}
		else {result = "register succesfully";}
		Gson gson = new Gson();
		String data = gson.toJson(result);
		out.println(data);
		out.flush();
		out.close();
	}

}
