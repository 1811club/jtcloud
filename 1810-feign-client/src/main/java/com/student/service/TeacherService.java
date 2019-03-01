package com.student.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jt.pojo.Teacher;




@FeignClient("service-teacher")
public interface TeacherService {
	
//	@RequestMapping("ServletFindAllTear")
//	public String findAll(@RequestParam(value="")Model model);

//	@RequestMapping(value = "addTeacherInfo")
//	public Integer addteacher(@RequestParam(value="teacher")Teacher teacher, @RequestParam(value="user") User user);
	//添加教师信息
	@RequestMapping(value = "addTeacherInfo",method=RequestMethod.POST)
	public Integer addteacher(@RequestBody Teacher teacher);
    //查询教师
	@RequestMapping(value = "selectTeacher",method=RequestMethod.GET)
	public List<Teacher> selectTeacher();
	//查询教师后删除
	@RequestMapping(value = "deleteTeacher",method=RequestMethod.GET)
	public int deleteTeacher(@RequestParam(value="teanum") String teanum);
	
}
