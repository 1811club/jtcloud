package com.jt.pojo;



public class User {
	
	private Integer userId;
	private String userNum;
	private String userName;
	private String password;
	private String phone;
	private Integer roleId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNum=" + userNum + ", userName=" + userName + ", password=" + password
				+ ", phone=" + phone + ", roleId=" + roleId + "]";
	}
	
	
	

}
