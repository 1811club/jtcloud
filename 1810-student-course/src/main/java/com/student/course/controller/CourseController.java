package com.student.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Course;
import com.jt.pojo.PageBean;
import com.student.course.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	// 查询全部课程
	@RequestMapping(value = "selectCos", method = RequestMethod.GET)
	public PageBean selectCos(String pageNo, String pageCount) {
		PageBean list = courseService.selectCos(pageNo, pageCount);
		return list;

	}

	// 修改课程
	@RequestMapping(value = "editCos", method = RequestMethod.POST)
	@ResponseBody
	public int editCos(@RequestBody Course course) {
		int rs = courseService.editCos(course);
		return rs;
	}

	// 查询单个课程
	@RequestMapping(value = "findOne", method = RequestMethod.GET)
	@ResponseBody
	public List<Course> findOne(int courseID) {
		List<Course> list = courseService.findOne(courseID);
		return list;
	}
	//新增课程的查询
	@RequestMapping(value = "selectOneCos", method = RequestMethod.POST)
	@ResponseBody
	public Course selectOneCos(@RequestBody Course course){
		return courseService.selectOneCos(course);
	}
	//新增课程
	@RequestMapping(value = "addCos", method = RequestMethod.POST)
	@ResponseBody
	public int addCos(@RequestBody Course course){
		return courseService.addCos(course);
	}
	// 删除课程
	@RequestMapping(value = "deleteCos", method = RequestMethod.GET)
	public int deleteCos(String courseID) {
		int success = courseService.deleteCos(Integer.parseInt(courseID));
		return success;
	}
}
