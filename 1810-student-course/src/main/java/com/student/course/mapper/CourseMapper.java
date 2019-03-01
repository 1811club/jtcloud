package com.student.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.pojo.Course;


public interface CourseMapper {

	List<Course> findOne(@Param("courseID") int courseID);

	List<Course> courseFindAll(@Param("pageNoInt") int pageNoInt, @Param("pageCountInt") int pageCountInt);

	int queryCount();

	int editCos(Course course);

	int deleteCos(@Param("courseID") int courseID);

	Course selectOneCos(Course course);

	int addCos(Course course);

}
