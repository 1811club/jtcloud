package com.student.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.sso.pojo.User;



@FeignClient("service-sso")
public interface SsoService {
	
	/*@RequestMapping("user/check/{username}")
	public String checkUsername(@PathVariable String username);*/
	
	@RequestMapping("user/register")
	public String doRgister(User user);
	
	
	@RequestMapping("user/login")
	public String doLogin(@RequestParam(value="u")
	String userName,@RequestParam(value="p")
	String userPassword) throws Exception;
	
	/*@RequestMapping("user/query/{ticket}")
	public String queryTicket(@PathVariable String ticket,
			String callback) throws Exception;*/
	
	@RequestMapping(value = "user/checkLog" , method = RequestMethod.POST)
	public User checkLogin(@RequestBody User user) throws Exception;
	
	@RequestMapping("user/check")
	public User checkUsername(@RequestParam(value="userNum") String userNum);
	
	
	
}
