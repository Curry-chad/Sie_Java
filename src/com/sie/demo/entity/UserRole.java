package com.sie.demo.entity;

public class UserRole {
	private Integer id;
	private Integer rid;
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", rid=" + rid + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}

}
