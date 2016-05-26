package org.deepthought.service;

import java.util.List;

import org.deepthought.annotation.OutoMapper;
import org.deepthought.bean.Article;
import org.deepthought.bean.ArticleType;
import org.deepthought.bean.Order;
import org.deepthought.bean.Order_item;
import org.deepthought.bean.User;
import org.deepthought.mapper.ArticleMapper;

public class ArticleServiceImpl implements ArticleService {

	@OutoMapper()
	private ArticleMapper articleMapper;
	@Override
	public List<ArticleType> getAllFirstArticleType() {

		
		List<ArticleType> firstArticleTypeMap = articleMapper.getAllFirstArticleType();
		return firstArticleTypeMap;
	}
	@Override
	public List<ArticleType> getSecondArticleType(String code) {
		
		List<ArticleType> secondArticleType = articleMapper.getSecondArticleType(code);
		
		return secondArticleType;
	}
	@Override
	public Article getItemArticleById(String id) {
		
		Article ItemArticle = articleMapper.getItemArticleById(id);
		
		return ItemArticle;
	}
	@Override
	public User getUserByNameAndPass(String loginName, String password) {

		User user = articleMapper.getUserByNameAndPass(loginName,password);
		return user;
	}
	@Override
	public User getUserByLoginName(String loginName) {
		User user = articleMapper.getUserByLoginName(loginName);
		return user;
	}
	@Override
	public void createOrder(String order_code, String create_date,
			String status, Double amount, int user_id) {
		articleMapper.createOrder(order_code,create_date,status,amount,user_id);
	}
	@Override
	public void createOrderItem(String order_code, Integer goods_id,
			Integer goods_amount) {
		
		articleMapper.createOrderItem(order_code,goods_id,goods_amount);
	}
	@Override
	public void deleteOrder(String order_code) {
		
		articleMapper.deleteOrder(order_code);
	}
	@Override
	public List<Order> getOrderbyUserId(String user_id) {
		
		List<Order> orderList=articleMapper.getOrderbyUserId(user_id);
		
		return orderList;
	}
	@Override
	public List<Order_item> getOrderItemByOrderCode(String order_code) {
		
		List<Order_item> order_itemList =articleMapper.getOrderItemByOrderCode(order_code);
		
		return order_itemList;
	}
	
	@Override
	public List<ArticleType> getArticleTypeBySearchCode(String searchCode) {
		List<ArticleType> articleType = articleMapper.getArticleTypeBySearchCode(searchCode);
		return articleType;
	}
	@Override
	public void deleteTypeCodeByDeleteCode(String deleteCode) {
		articleMapper.deleteTypeCodeByDeleteCode(deleteCode);
		
	}
	@Override
	public void addArticleInfo(String title, String supplier, String price,
			String locality, String putawayDate, String storage, String image,
			String description, String code, String create_date) {
		articleMapper.addArticleInfo(title,supplier,price,locality,putawayDate,storage,image,description,code,create_date);
		
	}
	
	
}
