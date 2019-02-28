package com.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.Teacher;

import com.teacher.service.TeacherService;


@Controller
public class TeacherController {

	
    @Autowired
    private TeacherService teacherService;
	@RequestMapping(value="addTeacherInfo",method=RequestMethod.POST )
	@ResponseBody
	public Integer addTeacher(@RequestBody Teacher teacher) {
		
		System.out.println(teacher);
		int i=teacherService.addteacher(teacher);
		System.out.println(i);
		return i;
	}
	
	@RequestMapping(value = "selectTeacher",method=RequestMethod.GET)
	@ResponseBody
	public List<Teacher> selectTeacher(){
		List<Teacher> list = teacherService.selectTeacher();
		return list;
	}
	
//	@RequestMapping("addTeacherInfo")
//	@ResponseBody
//	public Integer addTeacher(Teacher teacher,User user) {
//		
//		
//		int i=teacherService.addteacher(teacher,user);
//		System.out.println(i);
//		return i;
//	}
//	
	//查询教师信息
//	@Autowired
//	private FindTeacherService findTeacherService;	
//	
//	@RequestMapping(value="findAllTeacherInfo",method=RequestMethod.POST )
//	@ResponseBody
//	public Teacher findAll (List list){
//		
//	List result= findTeacherService.findAllTeacherInfo(list);
//		
//		return null;
//	}
}

