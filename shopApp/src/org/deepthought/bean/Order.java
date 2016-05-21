package org.deepthought.bean;
/*
 * 
 * 'ID',
        'ORDER_CODE',
        'CREATE_DATE',
        'SEND_DATE',
        'STATUS',
        'AMOUNT',
        'USER_ID');
 */
public class Order {
	private String id;
	private String order_code;
	private String create_date;
	private String send_date;
	private String status;
	private String amount;
	private String user_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getSend_date() {
		return send_date;
	}
	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", order_code=" + order_code
				+ ", create_date=" + create_date + ", send_date=" + send_date
				+ ", status=" + status + ", amount=" + amount + ", user_id="
				+ user_id + "]";
	}
	
	
	
}
