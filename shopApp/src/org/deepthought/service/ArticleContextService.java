package org.deepthought.service;

import java.util.List;

import org.deepthought.bean.Article;

public interface ArticleContextService {

	List<Article> getAllArticleContextByCode(String code);
}
