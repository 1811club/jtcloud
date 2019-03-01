package com.student.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.Teacher;
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
	
	//教师添加数据操作
	@RequestMapping("ServletaddTeacher")
	//@ResponseBody
	public String addTeacher(Teacher teacher,Model model) {
		
		List<Teacher> list=teacherService.selectTeacher();
		model.addAttribute("list",list);
		
		int result=teacherService.addteacher(teacher);
		
	
		if(result==1){
			model.addAttribute("list",list);
			model.addAttribute("msg","添加成功");
		
			return "admin/teacherAllInfo";  
			
			
		}else{
			model.addAttribute("msg","删除成功");
			model.addAttribute("list",list);
			return "admin/teacherAllInfo";  
		}
	}
	//教师管理的查询操作
	@RequestMapping("ServletFindAllTea")
	//@ResponseBody
	public String selectTeacher(Model model) {
		
		List<Teacher> list=teacherService.selectTeacher();
		model.addAttribute("list",list);
		
		return "admin/teacherAllInfo";
	}
	
	//教师删除操作
	
	@RequestMapping("ServletDeleteTea")
	public String deleteTeacher(String teanum,Model model){              
        
		int rs = teacherService.deleteTeacher(teanum);
		
		List<Teacher> list=teacherService.selectTeacher();
		model.addAttribute("list",list);
		                                                                
		if(rs==1){  
		
			model.addAttribute("list",list);
			return "admin/teacherAllInfo";                               	                                                            
		}else{                                                          
			model.addAttribute("msg","删除失败");                           
			model.addAttribute("list",list);                                                           
			return "admin/teacherAllInfo";	
			}

}
	
//教师修改
	
@RequestMapping("ServletSelectTea")	

public String selectTeacherEdit(Teacher teacher,Model model){
	
	return "admin/teacherAllInfo";	
			
			
}

	
}
