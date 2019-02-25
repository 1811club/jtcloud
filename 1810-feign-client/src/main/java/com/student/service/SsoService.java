package com.student.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-sso")
public interface SsoService {
	@RequestMapping(value="hi",method=RequestMethod.GET)
	String sayHi(@RequestParam(value="name")String name);
}
