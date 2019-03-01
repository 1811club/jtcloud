package com.teacher.mapper;

import java.util.List;

import com.jt.pojo.Teacher;

import feign.Param;

public interface TeacherMapper  {

	int insert(Teacher teacher);

	void delete(Teacher teacher);

	List<Teacher> selectTeachers();//查询教师数据

	int deleteTeacher(@Param(value="teanum") String teanum);//查询后删除数据
	

	String selectTeaEid(); //执行编辑


	
	
	

}
