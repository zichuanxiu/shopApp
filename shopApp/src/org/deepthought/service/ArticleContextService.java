package org.deepthought.service;

import java.util.List;

import org.deepthought.bean.Article;
import org.deepthought.tag.Page;

public interface ArticleContextService {

	List<Article> getAllArticleContextByCode(String code);

	int getTotalNumber(String typeCode, String keyWord);

	List<Article> getArticleContext(String typeCode, String keyWord, Page page);
}
