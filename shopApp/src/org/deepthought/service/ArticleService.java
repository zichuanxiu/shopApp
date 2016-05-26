package org.deepthought.service;

import java.util.List;
import java.util.Map;

import org.deepthought.bean.Article;
import org.deepthought.bean.ArticleType;
import org.deepthought.bean.Order;
import org.deepthought.bean.Order_item;
import org.deepthought.bean.User;

public interface ArticleService {

	List<ArticleType> getAllFirstArticleType();

	List<ArticleType> getSecondArticleType(String str);

	Article getItemArticleById(String id);

	User getUserByNameAndPass(String loginName, String password);

	User getUserByLoginName(String loginName);

	void createOrder(String order_code, String create_date, String status,
			Double amount, int user_id);

	void createOrderItem(String order_code, Integer goods_id,
			Integer goods_amount);

	void deleteOrder(String order_code);

	List<Order> getOrderbyUserId(String user_id);

	List<Order_item> getOrderItemByOrderCode(String order_code);

	List<ArticleType> getArticleTypeBySearchCode(String searchCode);

	void deleteTypeCodeByDeleteCode(String deleteCode);

	void addArticleInfo(String title, String supplier, String price,
			String locality, String putawayDate, String storage, String image,
			String description, String code, String create_date);


}
