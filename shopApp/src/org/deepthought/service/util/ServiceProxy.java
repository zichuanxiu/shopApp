package org.deepthought.service.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.session.SqlSession;
import org.deepthought.annotation.OutoMapper;

import org.deepthought.util.Connection_Factory;



public class ServiceProxy {
	@SuppressWarnings("unchecked")
	public <T> T  bind(final Object obj){
		return (T)Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public  Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				SqlSession sqlSession=null;
				
				try {
					sqlSession = Connection_Factory.getSqlSession();
					//获取目标类中所有的属性
//					System.out.println("=========");
//					System.out.println(sqlSession);
					Field[] fields = obj.getClass().getDeclaredFields();
					
					for (Field field : fields) {
						OutoMapper outoMapper = field.getAnnotation(OutoMapper.class);
						if (outoMapper!=null&&outoMapper.required()) {
							//如果属性是私有的设置该属性可以访问
							if (!field.isAccessible()) {
								field.setAccessible(true);
							}
							//给属性注入值
							field.set(obj, sqlSession.getMapper(field.getType()));
						}
					}
//					System.out.println("方法执行前");
					Object result= method.invoke(obj, args);
//					System.out.println(result);
//					System.out.println("方法执行后");
					sqlSession.commit();
					
					return result;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("提交失败，数据回滚");
					sqlSession.rollback();
				}finally{
//					System.out.println("连接工厂关闭");
					Connection_Factory.closeSqlSession();
//					System.out.println("连接工厂关闭成功");
				}
				return null;
				//获取连接
			
			}
		});
		
		
	}
}
