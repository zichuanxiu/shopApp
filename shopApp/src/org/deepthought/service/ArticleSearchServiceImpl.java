package org.deepthought.service;

import java.util.List;

import org.deepthought.annotation.OutoMapper;
import org.deepthought.bean.Article;
import org.deepthought.mapper.ArticleSearchMapper;

public class ArticleSearchServiceImpl implements ArticleSearchService {

	@OutoMapper()
	private ArticleSearchMapper articleSearchMapper;
	
	@Override
	public List<Article> getAllArticleContextBySearch(String typeCode1,String keyWord) {
		
		List<Article> articleContextBySearch=articleSearchMapper.getAllArticleContextBySearch(typeCode1, keyWord);
		return articleContextBySearch;
	}

}
