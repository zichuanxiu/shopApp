package org.deepthought.service;

import java.util.List;

import org.deepthought.annotation.OutoMapper;
import org.deepthought.bean.Article;
import org.deepthought.mapper.ArticleContextMapper;
import org.deepthought.tag.Page;

public class ArticleContextServiceImpl implements ArticleContextService {
	
	@OutoMapper()
	private ArticleContextMapper articleContextMapper;
	
	@Override
	public List<Article> getAllArticleContextByCode(String code) {

		List<Article> allArticleContextByCode =articleContextMapper.getAllArticleContextByCode(code);
		return allArticleContextByCode;
	}

	@Override
	public int getTotalNumber(String typeCode, String keyWord) {
		
		int totalNumber = articleContextMapper.getTotalNumber(typeCode,keyWord);
		
		return totalNumber;
	}

	@Override
	public List<Article> getArticleContext(String typeCode, String keyWord,
			Page page) {
	
		List<Article> articleContext= articleContextMapper.getArticleContext(typeCode,keyWord,
			page);
		
		return articleContext;
	}
	
	
}
