package com.student.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.pojo.Course;
import com.jt.pojo.PageBeanCourse;
import com.student.service.CourseService;


@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;

	// 查询全部课程
	@RequestMapping("ServletFindAllCos")
	public String selectCos(String pageNo, String pageCount, Model model) {
		PageBeanCourse list = courseService.selectCos(pageNo, pageCount);
		model.addAttribute("list", list);
		return "admin/courseAllInfo";
	}
	
	//添加课程
	@RequestMapping("ServletaddCourse")
	public String addCourse(Course course,Model model){
		Course cos=courseService.selectOneCos(course);
		if(cos==null){
			int rs=courseService.addCos(course);
			if(rs==0){
				model.addAttribute("msg", "新增成功~");
				return "admin/courseAllInfo";
			}else{
				model.addAttribute("msg", "失败，请重试");
				return "admin/addCourse";
			}
		}else{
			model.addAttribute("msg", "新增课程已存在！");
			return "admin/addCourse";
		}
	}
	
	
	//编辑课程
	@RequestMapping("ServletEditCos")
	public void editCos(Course course,Model model){
		int rs=courseService.editCos(course);
		if(rs==0){
			model.addAttribute("msg", "修改成功~");
			courseService.selectCos("1", "5");
		}else{
			model.addAttribute("msg", "修改失败!");
			courseService.findOne(course.getCourseID());
		}
	}

	// 查询单个课程信息
	@RequestMapping("ServletSelectCos")
	public String findOne(Model model,String courseID) throws java.text.ParseException {
		int courseId = Integer.parseInt(courseID);

		List<Course> rs = courseService.findOne(courseId);
		model.addAttribute("list", rs);
		return "admin/editCourse";
	}

	// 删除课程
	@RequestMapping("ServletDeleteCos")
	public String deleteCos(String courseID, Model model) {
		int success = courseService.deleteCos(courseID);
		if (success == 1) {
			model.addAttribute("msg", "删除成功！");
			return "admin/courseAllInfo";
		} else {
			model.addAttribute("msg", "删除失败！请重试~");
			return "admin/courseAllInfo";
		}
	}
}
