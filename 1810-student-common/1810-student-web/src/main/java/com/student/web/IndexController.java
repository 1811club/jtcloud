package com.student.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.service.SsoService;

@Controller
public class IndexController {
	
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("index")
	@ResponseBody
	public String indexString() {
		return "indexString";
	}
	
	@RequestMapping("login")
	public String login(String name) {
		return "/login/login";
	} 
	
	

}
