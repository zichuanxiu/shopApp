package org.deepthought.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.deepthought.bean.Article;
import org.deepthought.tag.Page;

public interface ArticleContextMapper {

	
	@Select("SELECT * FROM ec_article WHERE type_code LIKE #{code}")
	List<Article> getAllArticleContextByCode(String code);

	
	
	int getTotalNumber(@Param("typeCode")String typeCode,@Param("keyWord") String keyWord);



	List<Article> getArticleContext(@Param("typeCode")String typeCode,@Param("keyWord") String keyWord, @Param("page")Page page);


}
