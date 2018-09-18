package com.sie.demo.entity;

import java.util.Date;

public class SysUser {
	

	private Integer id;
	
	private Integer WN;
	
	public Integer getWN() {
		return WN;
	}

	public void setWN(Integer wN) {
		WN = wN;
	}
	private String loginName;
	
	private String name;
	
	private String password;
	
	private String sex;
	
	private String email;
	
	private Date createTime;
	
	private String detail;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", WN=" + WN + ", loginName=" + loginName + ", name=" + name + ", password="
				+ password + ", sex=" + sex + ", email=" + email + ", createTime=" + createTime + ", detail=" + detail
				+ "]";
	}
	
	

}
