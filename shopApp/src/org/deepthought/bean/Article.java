package org.deepthought.bean;

import java.text.DecimalFormat;
import java.util.Date;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/*
 * 'ID',
        'TITLE',
        'SUPPLIER',
        'PRICE',
        'DISCOUNT',
        'LOCALITY',
        'PUTAWAY_DATE',
        'STORAGE',
        'IMAGE',
        'DESCRIPTION',
        'TYPE_CODE',
        'CREATE_DATE',
        'DISABLED');
 * 
 * 
 */
public class Article {
	private Integer id;
	private String title;
	private String supplier;
	private double price;
	private double discount;
	private String locality;
	private Date putaway_date;
	private int storage;
	private String image;
	private String description;
	private String type_code;
	private Date create_date;
	private boolean disabled;
	
	private Integer buyNum;
	public Integer getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public Date getPutaway_date() {
		return putaway_date;
	}
	public void setPutaway_date(Date putaway_date) {
		this.putaway_date = putaway_date;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType_code() {
		return type_code;
	}
	public void setType_code(String type_code) {
		this.type_code = type_code;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	public String getDiscountPrice(){
		DecimalFormat df = new DecimalFormat("0.00");
		String discountPrice =df.format(this.price*this.discount);
		return discountPrice;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", supplier="
				+ supplier + ", price=" + price + ", discount=" + discount
				+ ", locality=" + locality + ", putaway_date=" + putaway_date
				+ ", storage=" + storage + ", image=" + image
				+ ", description=" + description + ", type_code=" + type_code
				+ ", create_date=" + create_date + ", disabled=" + disabled
				+ ", buyNum=" + buyNum + "]";
	}
	
	
	
	
	
	
	
	
}
