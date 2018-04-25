package com.qytkj.lysk.common.util;

/**
 * 工具类---分页（PageUtil）
 */
public class PageUtil {
	//每页行数
	private int count;
	//第几页
	private int pageIndex;
	//每页显示数据数
	private int pageSize;
	//总页数
	private int totalSize;
	//从第几页开始
	private int startNum;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	
	
}
