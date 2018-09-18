package com.sie.demo.entity;

public class MenuRole {
	private Integer rid;
	private Integer mid;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "MenuRole [rid=" + rid + ", mid=" + mid + "]";
	}

}
