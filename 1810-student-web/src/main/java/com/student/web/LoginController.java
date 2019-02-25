package com.student.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.service.SsoService;

@Controller
public class LoginController {
	
	@Autowired
	private SsoService hiService;
	
	@RequestMapping("login")
	public String login(String name) {
		String msString = hiService.sayHi(name);
		System.out.println(msString);
		return "/login/login";
	}

}
