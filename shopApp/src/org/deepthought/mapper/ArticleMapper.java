package org.deepthought.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.deepthought.bean.Article;
import org.deepthought.bean.ArticleType;
import org.deepthought.bean.User;

public interface ArticleMapper {

	
	@Select("SELECT CODE,NAME FROM ec_article_type WHERE LENGTH(CODE)=4 ORDER BY CODE")
	List<ArticleType> getAllFirstArticleType();
	
	@Select("SELECT CODE,NAME FROM ec_article_type WHERE CODE LIKE #{code} AND LENGTH(CODE)=8 ORDER BY CODE")
	List<ArticleType> getSecondArticleType(String code);

	@Select("SELECT * FROM ec_article WHERE id=#{id}")
	Article getItemArticleById(String id);

	@Select("SELECT * FROM ec_user WHERE LOGIN_NAME = #{loginName} AND PASSWORD = #{password}")
	User getUserByNameAndPass(@Param("loginName")String loginName,@Param("password") String password);
	
	@Select("SELECT * FROM ec_user WHERE LOGIN_NAME = #{loginName}")
	User getUserByLoginName(String loginName);
	
}
