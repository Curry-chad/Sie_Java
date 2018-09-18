package com.sie.demo.entity;

public class Role {
	
	private Integer rid;
	private String role;
	private String detail;
	private Integer WN;
	public Integer getWN() {
		return WN;
	}
	public void setWN(Integer wN) {
		WN = wN;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Role [id=" + rid + ", role=" + role + ", detail=" + detail + "]";
	}

}
