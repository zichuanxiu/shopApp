package org.deepthought.service;

import java.util.List;

import org.deepthought.annotation.OutoMapper;
import org.deepthought.bean.Article;
import org.deepthought.mapper.ArticleContextMapper;

public class ArticleContextServiceImpl implements ArticleContextService {
	
	@OutoMapper()
	private ArticleContextMapper articleContextMapper;
	
	@Override
	public List<Article> getAllArticleContextByCode(String code) {

		List<Article> allArticleContextByCode =articleContextMapper.getAllArticleContextByCode(code);
		return allArticleContextByCode;
	}
	
	
}
