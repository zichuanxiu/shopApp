package org.deepthought.bean;

public class ArticleType {
	
	private String code;
	private String name;
	private String remark;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "ArticleType [code=" + code + ", name=" + name + ", remark="
				+ remark + "]";
	}

	
	
	
	
}
