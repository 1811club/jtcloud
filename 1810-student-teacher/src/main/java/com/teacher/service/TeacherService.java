package com.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.pojo.Teacher;
import com.jt.pojo.User;
import com.teacher.mapper.TeacherMapper;
import com.teacher.mapper.UserMapper;

@Service
public class TeacherService {
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private UserMapper userMapper;
//	public int addteacher(Teacher teacher) {
//		
//		
//		return teacherMapper.insert(teacher);
//		
//	
//	}

	//执行teacher添加操作
public int addteacher(Teacher teacher) {
		teacher.setRoleId(1);
		int tm = 0,um=0;
		try {tm= teacherMapper.insert(teacher);
		   um=userMapper.insert(teacher);	   
		} catch (Exception e) {
				e.printStackTrace();
			 if(tm==1){
				 teacherMapper.delete(teacher);
			 }
			 if(um==1){
				 userMapper.delete(teacher);
			 }		
		}
		if(tm==1&&um==1){
			return 1;
		}
 
	return 0;
	}

//执行查询操作
public List<Teacher> selectTeacher() {
	
	return teacherMapper.selectTeachers();
}

//执行删除操作
public int deleteTeacher(String teanum) {
	
	return teacherMapper.deleteTeacher(teanum);
	
}


}
