package org.deepthought.service;

import java.util.List;

import org.deepthought.bean.Article;

public interface ArticleSearchService {

	List<Article> getAllArticleContextBySearch(String typeCode1, String keyWord);
	
}
