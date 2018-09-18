package com.sie.demo.entity;

public class PageInfo {
	private Integer offset;
	private Integer max;
	private Integer pagesize=10;
	private Integer currentPage;
	public PageInfo(Integer currentPage) {
		this.currentPage = currentPage;
		this.offset=(currentPage-1)*pagesize+1;
		this.max=currentPage*pagesize;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "PageInfo [offset=" + offset + ", max=" + max + ", pagesize=" + pagesize + ", currentPage=" + currentPage
				+ "]";
	}
	
 
	
}
