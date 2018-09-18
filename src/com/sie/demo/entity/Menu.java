package com.sie.demo.entity;

public class Menu {
	private Integer mid;
	private String menuName;
	private String lastMenu;
	private String address;
	private Integer signal;
	private String type;
	private String remark;
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", menuName=" + menuName + ", lastMenu=" + lastMenu + ", address=" + address
				+ ", signal=" + signal + ", type=" + type + ", remark=" + remark + "]";
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getLastMenu() {
		return lastMenu;
	}
	public void setLastMenu(String lastMenu) {
		this.lastMenu = lastMenu;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getSignal() {
		return signal;
	}
	public void setSignal(Integer signal) {
		this.signal = signal;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
