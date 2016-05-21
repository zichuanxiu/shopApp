package org.deepthought.bean;

public class ShopCar {
	
	private Integer id;
	private Integer user_id;
	private Integer goods_id;
	private Integer goods_amount;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_idI(Integer user_idI) {
		this.user_id = user_idI;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getGoods_amount() {
		return goods_amount;
	}
	public void setGoods_amount(Integer goods_amount) {
		this.goods_amount = goods_amount;
	}
	@Override
	public String toString() {
		return "ShopCar [id=" + id + ", user_id=" + user_id + ", goods_id="
				+ goods_id + ", goods_amount=" + goods_amount + "]";
	}
	
	
}
