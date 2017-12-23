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
import com.test.entity.People;
import com.test.service.PeoplesearchService;

public class PeoplesearchAction {
	private static final long serialVersionUID = 1L;
	private List<People> myList;
	private String peoplename;
	@Autowired
	private PeoplesearchService peoplesearchService;
	
	/**
	 * 构造方法
	 */
	public PeoplesearchAction() {
		// 初始化Map对象
		 myList = new ArrayList<People>();
	}



	public void peoplesearch() throws IOException{
		ActionContext ac = ActionContext.getContext();

		if (peoplename == null || peoplename.isEmpty()) {
			peoplename = "";
		}

		List<People> peoples = peoplesearchService.findByPeoplename(peoplename);
		HttpServletResponse response = ServletActionContext.getResponse();
		// 以下代码从JSON.java中拷过来的
		response.setContentType("text/html");
		PrintWriter out;
		out = response.getWriter();
		myList = peoples;
		Gson gson = new Gson();
		String data = gson.toJson(myList);
		out.println(data);
		out.flush();
		out.close();
		
//		ac.put("peoples", peoples);
//		return "main";
	}

	public String getPeoplename() {
		return peoplename;
	}

	public void setPeoplename(String peoplename) {
		this.peoplename = peoplename;
	}

	public PeoplesearchService getPeoplesearchService() {
		return peoplesearchService;
	}

	public void setPeoplesearchService(PeoplesearchService peoplesearchService) {
		this.peoplesearchService = peoplesearchService;
	}

	public List<People> getDataList() {
		return myList;
	}


}
