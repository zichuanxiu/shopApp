package org.deepthought.service;

import java.util.List;
import java.util.Map;

import org.deepthought.bean.Article;
import org.deepthought.bean.ArticleType;
import org.deepthought.bean.User;

public interface ArticleService {

	List<ArticleType> getAllFirstArticleType();

	List<ArticleType> getSecondArticleType(String str);

	Article getItemArticleById(String id);

	User getUserByNameAndPass(String loginName, String password);


}
