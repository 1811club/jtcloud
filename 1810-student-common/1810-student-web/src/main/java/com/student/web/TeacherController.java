package com.student.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.Teacher;
import com.jt.pojo.User;
import com.student.service.TeacherService;



@Controller
public class TeacherController {
		
	@Autowired
    private TeacherService teacherService;
	
//	@RequestMapping("ServletaddTeacher")
//	@ResponseBody
//	public String addTeacher(Teacher teacher,User user) {
//		
//		int result=teacherService.addteacher(teacher,user);
//		if(result==1){
//			return "添加成功";
//		}else{
//			return "添加失败";
//		}
//	}
	
	@RequestMapping("ServletaddTeacher")
	@ResponseBody
	public String addTeacher(Teacher teacher) {
		
		int result=teacherService.addteacher(teacher);
		if(result==1){
			return "添加成功";
		}else{
			return "添加失败";
		}
	}
	@RequestMapping("ServletFindAllTea")
	public String selectTeacher(Model model) {
		
		List<Teacher> list=teacherService.selectTeacher();
		model.addAttribute("list",list);
		
		return "admin/teacherAllInfo";
	}
	
	
	
}
