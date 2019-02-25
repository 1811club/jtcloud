package com.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Logincontrller {
	
	@RequestMapping(value="hi",method=RequestMethod.GET)
	@ResponseBody
	public String login(String name) {
		return "调用成功" + name;
	}

}
