package com.jt.pojo;



public class Teacher {
	
	private Integer teaId;
	private String  teaNum;
	private String teaName;
	private String teaSex;
	private Integer teaAge;
	private String teaCourse;
	private String major;
	private String department;
	private String password;
	private String phone;
	private Integer roleId;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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
	public Integer getTeaId() {
		return teaId;
	}
	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}
	public String getTeaNum() {
		return teaNum;
	}
	public void setTeaNum(String teaNum) {
		this.teaNum = teaNum;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getTeaSex() {
		return teaSex;
	}
	public void setTeaSex(String teaSex) {
		this.teaSex = teaSex;
	}
	public Integer getTeaAge() {
		return teaAge;
	}
	public void setTeaAge(Integer teaAge) {
		this.teaAge = teaAge;
	}
	public String getTeaCourse() {
		return teaCourse;
	}
	public void setTeaCourse(String teaCourse) {
		this.teaCourse = teaCourse;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Teacher [teaId=" + teaId + ", teaNum=" + teaNum + ", teaName=" + teaName + ", teaSex=" + teaSex
				+ ", teaAge=" + teaAge + ", teaCourse=" + teaCourse + ", major=" + major + ", department=" + department
				+ ", password=" + password + ", phone=" + phone + ", roleId=" + roleId + "]";
	}
	
	
	
	

}
