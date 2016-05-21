package org.deepthought.pageService.util;

import java.util.List;

import org.deepthought.bean.Article;
import org.deepthought.bean.ArticleType;
import org.deepthought.service.ArticleContextService;
import org.deepthought.service.ArticleContextServiceImpl;
import org.deepthought.service.ArticleService;
import org.deepthought.service.ArticleServiceImpl;
import org.deepthought.service.util.ServiceProxy;

public class PageService {


	//一级物品类型
	public static List<ArticleType> firstArticleType(){
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService)serviceProxy.bind(new ArticleServiceImpl());

		List<ArticleType> firstArticleType= articleService.getAllFirstArticleType();
		
		return firstArticleType;
	}
	
	//二级物品类型
	public static List<ArticleType> secondArticleType(List<ArticleType> firstArticleType,String articleTypeCode){
		ServiceProxy serviceProxy = new ServiceProxy();

		ArticleService articleService = (ArticleService)serviceProxy.bind(new ArticleServiceImpl());

		List<ArticleType> secondArticleType = articleService.getSecondArticleType(firstArticleType.get(Integer.parseInt(articleTypeCode==null?"1":articleTypeCode)-1).getCode()+"%");
	
		return secondArticleType;
	}
	
	//正文详细信息
	public static List<Article> articleContext(String firstCode){
		ServiceProxy serviceProxy = new ServiceProxy();
		
		ArticleContextService articleContextService=(ArticleContextService)serviceProxy.bind(new ArticleContextServiceImpl());
		
		List<Article> articleContext = articleContextService.getAllArticleContextByCode(firstCode+"%");
		
		return articleContext;
	}
	
	//物品详细信息
	public static Article getArticle(String id){
		ServiceProxy serviceProxy = new ServiceProxy();
		
		ArticleService articleService = (ArticleService)serviceProxy.bind(new ArticleServiceImpl());
		
		Article itemArticle = articleService.getItemArticleById(id);
		return itemArticle;
	}
	
	
	

}
