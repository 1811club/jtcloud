package com.student.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jt.pojo.Teacher;
import com.jt.pojo.User;



@FeignClient("service-teacher")
public interface TeacherService {
	
//	@RequestMapping("ServletFindAllTear")
//	public String findAll(@RequestParam(value="")Model model);

//	@RequestMapping(value = "addTeacherInfo")
//	public Integer addteacher(@RequestParam(value="teacher")Teacher teacher, @RequestParam(value="user") User user);
	
	@RequestMapping(value = "addTeacherInfo",method=RequestMethod.POST)
	public Integer addteacher(@RequestBody Teacher teacher);

	@RequestMapping(value = "selectTeacher",method=RequestMethod.GET)
	public List<Teacher> selectTeacher();

}
