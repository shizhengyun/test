package com.test.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.test.entity.Configuration_information_list;
import com.test.entity.People;
import com.test.entity.User;
import com.test.service.Configuration_information_listService;
import com.test.service.PeopleService;
import com.test.service.UserService;
@Component
@Scope("prototype")
public class UserAction {
	@Autowired
	private UserService userService;
	@Autowired
	private PeopleService peopleService;
	@Autowired
	private Configuration_information_listService configuration_information_listService;
	public String execute() throws IOException {

		ActionContext ac = ActionContext.getContext();
		List<User> users = userService.findAll();
		List<User> userscolumnname = userService.findAllcolumnname();
		ac.put("users", users);
		ac.put("userscolumnname", userscolumnname);
		
		List<People> peoples = peopleService.findAllpeople();
		List<People> peoplescolumnname = peopleService.findAllpeoplecolumnname();
//		System.out.println(peoplescolumnname);
		
		ac.put("peoples", peoples);
		ac.put("peoplescolumnname", peoplescolumnname);
		
		List<Configuration_information_list> configuration_information_list = configuration_information_listService.findconfiguration_information_listAll();
		List<Configuration_information_list> configuration_information_listcolumnname = configuration_information_listService.findconfiguration_information_listAllcolumnname();
//		System.out.println(peoplescolumnname);
		
		ac.put("configuration_information_list", configuration_information_list);
		ac.put("configuration_information_listcolumnname", configuration_information_listcolumnname);
		
		
		return "main";
	
}}
