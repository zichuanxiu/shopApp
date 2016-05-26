package org.deepthought.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.deepthought.bean.Article;
import org.deepthought.bean.ArticleType;
import org.deepthought.bean.Order;
import org.deepthought.bean.Order_item;
import org.deepthought.bean.User;

public interface ArticleMapper {

	@Select("SELECT CODE,NAME FROM ec_article_type WHERE LENGTH(CODE)=4 ORDER BY CODE")
	List<ArticleType> getAllFirstArticleType();

	@Select("SELECT CODE,NAME FROM ec_article_type WHERE CODE LIKE #{code} AND LENGTH(CODE)=8 ORDER BY CODE")
	List<ArticleType> getSecondArticleType(String code);

	@Select("SELECT * FROM ec_article WHERE id=#{id}")
	Article getItemArticleById(String id);

	@Select("SELECT * FROM ec_user WHERE LOGIN_NAME = #{loginName} AND PASSWORD = #{password}")
	User getUserByNameAndPass(@Param("loginName") String loginName,
			@Param("password") String password);

	@Select("SELECT * FROM ec_user WHERE LOGIN_NAME = #{loginName}")
	User getUserByLoginName(String loginName);

	@Insert("INSERT INTO ec_order(order_code,create_date,STATUS,amount,user_id) VALUES(#{order_code},#{create_date},#{status},#{amount},#{user_id})")
	void createOrder(@Param("order_code") String order_code,
			@Param("create_date") String create_date,
			@Param("status") String status, @Param("amount") Double amount,
			@Param("user_id") int user_id);

	@Insert("INSERT INTO ec_order_item(order_id,article_id,order_num) VALUES(#{order_code},#{article_id},#{order_num})")
	void createOrderItem(@Param("order_code") String order_code,
			@Param("article_id") Integer goods_id,
			@Param("order_num") Integer goods_amount);

	@Delete("DELETE FROM ec_order WHERE order_code =#{order_code}")
	void deleteOrder(String order_code);

	@Select("SELECT * FROM ec_order WHERE user_id =#{user_id}")
	List<Order> getOrderbyUserId(String user_id);

	@Select("SELECT * FROM ec_order_item WHERE order_id = #{order_code}")
	List<Order_item> getOrderItemByOrderCode(String order_code);

	@Select("SELECT * FROM ec_article_type WHERE CODE LIKE #{searchCode}")
	List<ArticleType> getArticleTypeBySearchCode(String searchCode);

	@Delete("DELETE FROM ec_article_type WHERE CODE =#{deleteCode}")
	void deleteTypeCodeByDeleteCode(String deleteCode);

	@Insert("INSERT INTO ec_article (title,supplier,price,locality,PUTAWAY_DATE,STORAGE,image,description,TYPE_CODE,create_date) VALUES(#{title},#{supplier},#{price},#{locality},#{putawayDate},#{storage},#{image},#{description},#{code},#{create_date})")
	void addArticleInfo(@Param("title") String title,
			@Param("supplier") String supplier, @Param("price") String price,
			@Param("locality") String locality,
			@Param("putawayDate") String putawayDate,
			@Param("storage") String storage, @Param("image") String image,
			@Param("description") String description,
			@Param("code") String code, @Param("create_date") String create_date);

}
