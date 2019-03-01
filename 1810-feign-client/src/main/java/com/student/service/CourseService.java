package com.student.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.Course;
import com.jt.pojo.PageBeanCourse;


@FeignClient("service-course")
public interface CourseService {
	// 查询全部课程
	@RequestMapping(value = "selectCos", method = RequestMethod.GET)
	@ResponseBody
	PageBeanCourse selectCos(@RequestParam(value = "pageNo") String pageNo,@RequestParam(value = "pageCount") String pageCount);

	// 修改课程
	 @RequestMapping(value = "editCos", method = RequestMethod.POST)
	 int editCos(@RequestBody Course course);
	// 查询单个课程
	@RequestMapping(value = "findOne", method = RequestMethod.GET)
	List<Course> findOne(@RequestParam(value = "courseID") int courseID);

	// 删除课程 -----成功
	@RequestMapping(value = "deleteCos", method = RequestMethod.GET)
	int deleteCos(@RequestParam("courseID") String courseID);
	//新增课程的查询，验证是否重复
	@RequestMapping(value = "selectOneCos", method = RequestMethod.POST)
	Course selectOneCos(@RequestBody Course course);
	//新增课程
	@RequestMapping(value = "addCos", method = RequestMethod.POST)
	int addCos(@RequestBody Course course);

}
