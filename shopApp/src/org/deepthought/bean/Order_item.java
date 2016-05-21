package org.deepthought.bean;

/*
 * 
 * ('ORDER_ID',
        'ARTICLE_ID',
        'ORDER_NUM');
 */
public class Order_item {
	private String order_id;
	private String article_id;
	private String order_num;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getArticle_id() {
		return article_id;
	}
	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	@Override
	public String toString() {
		return "Order_item [order_id=" + order_id + ", article_id="
				+ article_id + ", order_num=" + order_num + "]";
	}
	
	
	
}
