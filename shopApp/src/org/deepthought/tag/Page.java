package org.deepthought.tag;

public class Page {
	
	private int pageIndex;//当前页面
	
	private int pageSize;//每页显示的记录数

	private int totalNumber;//总记录数
	
	/**
	 * @param pageIndex
	 * @param pageSize
	 */
	public Page(int pageSize,int pageIndex) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
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

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	
	//计算开始索引值    （页码-1）* 每页显示记录
	public int getStartIndex(){
		return (this.pageIndex-1)*this.pageSize;
	}
	
	//计算尾页
	public int getTotalPage(){
		int totalPage = this.totalNumber%this.pageSize==0?this.totalNumber/this.pageSize:this.totalNumber/this.pageSize+1;
		return totalPage;
	}
}
