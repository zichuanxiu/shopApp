package org.deepthought.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.deepthought.bean.Article;

public interface ArticleSearchMapper {

//	@Select("SELECT * FROM ec_article WHERE type_code LIKE #{typeCode1} AND title LIKE #{keyWord}")
	List<Article> getAllArticleContextBySearch(@Param("typeCode1")String typeCode1,@Param("keyWord")String keyWord);
}
