package org.deepthought.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.deepthought.bean.Article;

public interface ArticleContextMapper {

	
	@Select("SELECT * FROM ec_article WHERE type_code LIKE #{code}")
	List<Article> getAllArticleContextByCode(String code);


}
