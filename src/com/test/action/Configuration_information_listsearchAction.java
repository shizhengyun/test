package com.test.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.test.entity.Configuration_information_list;
import com.test.service.Configuration_information_listsearchService;

public class Configuration_information_listsearchAction {
	private static final long serialVersionUID = 1L;
	private List<Configuration_information_list> myList;
	private String configuration_information_listtext;
	private String configuration_information_listcondition;
	private String configuration_information_listpage;
	private String configuration_information_listpagesize;
	private List<Configuration_information_list> mycount;
	@Autowired
	private Configuration_information_listsearchService configuration_information_listsearchService;
	
	/**
	 * 构造方法
	 */
	public Configuration_information_listsearchAction() {
		// 初始化Map对象
		 myList = new ArrayList<Configuration_information_list>();
		 mycount = new ArrayList<Configuration_information_list>();
	}



	public void configuration_information_listsearch() throws IOException{
		ActionContext ac = ActionContext.getContext();



		List<Configuration_information_list> configuration_information_list = configuration_information_listsearchService.findByConfiguration_information_list(configuration_information_listtext,configuration_information_listcondition,configuration_information_listpage,configuration_information_listpagesize);
		List<Configuration_information_list> configuration_information_listcount = configuration_information_listsearchService.findByConfiguration_information_listcount(configuration_information_listtext,configuration_information_listcondition);
		HttpServletResponse response = ServletActionContext.getResponse();
		// 以下代码从JSON.java中拷过来的
		response.setContentType("text/html");
		PrintWriter out;
		out = response.getWriter();
		myList = configuration_information_list;
		myList.addAll(configuration_information_listcount);		
		Gson gson = new Gson();		
		String datalist = gson.toJson(myList);		
		out.print(datalist);
		out.flush();
		out.close();
	}



	public String getConfiguration_information_listtext() {
		return configuration_information_listtext;
	}



	public void setConfiguration_information_listtext(
			String configuration_information_listtext) {
		this.configuration_information_listtext = configuration_information_listtext;
	}



	public String getConfiguration_information_listcondition() {
		return configuration_information_listcondition;
	}



	public void setConfiguration_information_listcondition(
			String configuration_information_listcondition) {
		this.configuration_information_listcondition = configuration_information_listcondition;
	}



	public String getConfiguration_information_listpage() {
		return configuration_information_listpage;
	}



	public void setConfiguration_information_listpage(
			String configuration_information_listpage) {
		this.configuration_information_listpage = configuration_information_listpage;
	}



	public String getConfiguration_information_listpagesize() {
		return configuration_information_listpagesize;
	}



	public void setConfiguration_information_listpagesize(
			String configuration_information_listpagesize) {
		this.configuration_information_listpagesize = configuration_information_listpagesize;
	}



	public Configuration_information_listsearchService getConfiguration_information_listsearchService() {
		return configuration_information_listsearchService;
	}

	public void setConfiguration_information_listsearchService(Configuration_information_listsearchService configuration_information_listsearchService) {
		this.configuration_information_listsearchService = configuration_information_listsearchService;
	}

	public List<Configuration_information_list> getDataList() {
		return myList;
	}


}
