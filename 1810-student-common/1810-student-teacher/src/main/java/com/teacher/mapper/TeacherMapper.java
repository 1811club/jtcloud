package com.teacher.mapper;

import java.util.List;

import com.jt.pojo.Teacher;

public interface TeacherMapper  {

	int insert(Teacher teacher);

	void delete(Teacher teacher);

	List<Teacher> selectTeachers();


	
	
	

}
