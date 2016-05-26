package org.deepthought.pageService.util;

import java.util.List;

import org.deepthought.bean.Article;
import org.deepthought.bean.ArticleType;
import org.deepthought.bean.Order;
import org.deepthought.bean.Order_item;
import org.deepthought.bean.User;
import org.deepthought.service.ArticleContextService;
import org.deepthought.service.ArticleContextServiceImpl;
import org.deepthought.service.ArticleService;
import org.deepthought.service.ArticleServiceImpl;
import org.deepthought.service.util.ServiceProxy;
import org.deepthought.tag.Page;

public class PageService {

	// 一级物品类型
	public static List<ArticleType> firstArticleType() {
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());

		List<ArticleType> firstArticleType = articleService
				.getAllFirstArticleType();

		return firstArticleType;
	}

	// 二级物品类型
	public static List<ArticleType> secondArticleType(
			List<ArticleType> firstArticleType, String articleTypeCode) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());

		List<ArticleType> secondArticleType = articleService
				.getSecondArticleType(firstArticleType.get(
						Integer.parseInt(articleTypeCode == null ? "1"
								: articleTypeCode) - 1).getCode()
						+ "%");

		return secondArticleType;
	}

	// 首页正文详细信息
	public static List<Article> articleContext(String firstCode) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleContextService articleContextService = (ArticleContextService) serviceProxy
				.bind(new ArticleContextServiceImpl());

		List<Article> articleContext = articleContextService
				.getAllArticleContextByCode(firstCode + "%");

		return articleContext;
	}

	// 物品详细信息
	public static Article getArticle(String id) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());

		Article itemArticle = articleService.getItemArticleById(id);
		return itemArticle;
	}
	//根据typeCode和keyWord搜索到的物品的数量
	public static int getTotalNumber(String typeCode, String keyWord) {

		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleContextService articleContextService = (ArticleContextService) serviceProxy
				.bind(new ArticleContextServiceImpl());

		int totalNumber = articleContextService.getTotalNumber(typeCode,keyWord);
		
		
		
		return totalNumber;
	}
	
	//根据typeCode keyWord page搜索到的分页信息
	public static List<Article> articleContext(String typeCode, String keyWord,
			Page page) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleContextService articleContextService = (ArticleContextService) serviceProxy
				.bind(new ArticleContextServiceImpl());
		
		List<Article> ArticleContext=articleContextService.getArticleContext(typeCode,keyWord,page);
		return ArticleContext;
	}
	
	
	//登录信息查询
	public static User getUserByNameAndPass(String loginName, String password) {
		
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());
		
		User user = articleService.getUserByNameAndPass(loginName,password);
		
		return user;
	}
	//通过loginName异步校验用户名
	public static User getUserByLoginName(String loginName) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());
		
		User user = articleService.getUserByLoginName(loginName);
		return user;
	}
	//将订单数据插入数据库ec_order表中
	public static void createOrder(String order_code, String create_date,
			String status, Double amount, int user_id) {
		
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());
		
		articleService.createOrder(order_code,create_date,status,amount,user_id);
		
	}
	//将订单内的物品信息，物品id和数量保存在数据表ec_order_item中
	public static void createOrderItem(String order_code, Integer goods_id,
			Integer goods_amount) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());
		articleService.createOrderItem(order_code,goods_id,goods_amount);
		
	}

	//根据order_code删除订单数据
	public static void deleteOrder(String order_code) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());
		articleService.deleteOrder(order_code);
		
	}

	//根据user_id找全部订单数据的集合
	public static List<Order> getOrderbyUserId(String user_id) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());
		
		List<Order> orderList = articleService.getOrderbyUserId(user_id);
			
			
		return orderList;
	}

	//根据order_code找全部Order_item的集合
	public static List<Order_item> getOrderItemByOrderCode(String order_code) {

		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());
		
		List<Order_item> order_itemList =articleService.getOrderItemByOrderCode(order_code);
		
		return order_itemList;
	}

	
	//后台管理员页面 根据searchCode 查找物品类型信息
	public static List<ArticleType> getArticleTypeBySearchCode(String searchCode) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());
		List<ArticleType>  articleType =articleService.getArticleTypeBySearchCode(searchCode);
		
		return articleType;
	}

	//后台管理员页面 根据deleteCode 删除物品类型信息
	public static void deleteTypeCodeByDeleteCode(String deleteCode) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());
		articleService.deleteTypeCodeByDeleteCode(deleteCode);
	}
	
	//后台管理页面物品管理插入物品信息
	public static void addArticleInfo(String title, String supplier,
			String price, String locality, String putawayDate, String storage,
			String image, String description, String code, String create_date) {
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService) serviceProxy
				.bind(new ArticleServiceImpl());
		articleService.addArticleInfo(title,supplier,price,locality,putawayDate,storage,image,description,code,create_date);
	}

}
