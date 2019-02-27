package com.student.sso.mapper;

import com.student.sso.pojo.User;

public interface UserMapper {
	
	int checkUserName(String userName);

	int insertUser(User user);

	User checkLogin(User user);
	
	User checkLog(User user);

	User queryUserNum(String userNum);

}
