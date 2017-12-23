package com.test.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.test.entity.Configuration_information_list;
import com.test.service.Configuration_information_listService;

@Component
@Scope("prototype")
public class Configuration_information_listAction {
	private int page;
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	private int pagesize;
	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	@Autowired
	private Configuration_information_listService configuration_information_listService;

	public String configuration_information_list() {

		ActionContext ac = ActionContext.getContext();
		List<Configuration_information_list> configuration_information_list = configuration_information_listService.findconfiguration_information_listAll();
		List<Configuration_information_list> configuration_information_listcolumnname = configuration_information_listService.findconfiguration_information_listAllcolumnname();
		ac.put("configuration_information_list", configuration_information_list);
		ac.put("configuration_information_listcolumnname", configuration_information_listcolumnname);
		

		
		
		return "configuration_information_list";
	
}}