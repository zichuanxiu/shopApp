package org.deepthought.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Connection_Factory {

	private static SqlSessionFactory sqlSessionFactory;
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
	
	//类加载的时候初始化连接池
	static{
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//获取连接
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession==null){
			sqlSession = sqlSessionFactory.openSession();
			threadLocal.set(sqlSession);
		}
		return sqlSession;
	} 
	
	
	//关闭连接
	public static void closeSqlSession(){
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession!=null){
           sqlSession.close();
         }
		threadLocal.remove();
	} 
}
