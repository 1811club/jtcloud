package com.student.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.pojo.Course;
import com.jt.pojo.PageBean;
import com.student.course.mapper.CourseMapper;

@Service
public class CourseService {
	@Autowired
	private CourseMapper courseMapper;

	// 查询一个课程
	public List<Course> findOne(int courseID) {
		List<Course> rs = courseMapper.findOne(courseID);
		return rs;
	}

	// 查询全部课程
	public PageBean selectCos(String pageNo, String pageCount) {

		int pageNoInt = 1;
		int pageCountInt = 5;
		if (pageNo != null) {
			pageNoInt = Integer.parseInt(pageNo);
		}
		if (pageCount != null) {
			pageCountInt = Integer.parseInt(pageCount);
		}
		List<Course> list = new ArrayList<Course>();
		list = courseMapper.courseFindAll((pageNoInt - 1) * pageCountInt, pageCountInt);
		int totalCount = courseMapper.queryCount();
		PageBean pb = new PageBean(list, totalCount, pageNoInt, pageCountInt);
		return pb;
	}

	// 修改一个课程
	public int editCos(Course course) {
		int rs = courseMapper.editCos(course);
		return rs;
	}

	public int deleteCos(int courseID) {
		int success = courseMapper.deleteCos(courseID);
		return success;
	}

	public Course selectOneCos(Course course) {
		return courseMapper.selectOneCos(course);
	}

	public int addCos(Course course) {
		return courseMapper.addCos(course);
	}

}
