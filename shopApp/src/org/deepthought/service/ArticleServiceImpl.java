package org.deepthought.service;

import java.util.List;

import org.deepthought.annotation.OutoMapper;
import org.deepthought.bean.Article;
import org.deepthought.bean.ArticleType;
import org.deepthought.mapper.ArticleMapper;

public class ArticleServiceImpl implements ArticleService {

	@OutoMapper()
	private ArticleMapper articleMapper;
	@Override
	public List<ArticleType> getAllFirstArticleType() {

		
		List<ArticleType> firstArticleTypeMap = articleMapper.getAllFirstArticleType();
//		System.out.println("777777777777777777");
//		System.out.println("firstArticleTypeMap");
		return firstArticleTypeMap;
	}
	@Override
	public List<ArticleType> getSecondArticleType(String code) {
		
		List<ArticleType> secondArticleType = articleMapper.getSecondArticleType(code);
		
		return secondArticleType;
	}
	@Override
	public Article getItemArticleById(String id) {
		
		Article ItemArticle = articleMapper.getItemArticleById(id);
		
		return ItemArticle;
	}
	
	
}
