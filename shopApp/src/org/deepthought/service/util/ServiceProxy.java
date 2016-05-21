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
					//��ȡĿ���������е�����
//					System.out.println("=========");
//					System.out.println(sqlSession);
					Field[] fields = obj.getClass().getDeclaredFields();
					
					for (Field field : fields) {
						OutoMapper outoMapper = field.getAnnotation(OutoMapper.class);
						if (outoMapper!=null&&outoMapper.required()) {
							//���������˽�е����ø����Կ��Է���
							if (!field.isAccessible()) {
								field.setAccessible(true);
							}
							//������ע��ֵ
							field.set(obj, sqlSession.getMapper(field.getType()));
						}
					}
//					System.out.println("����ִ��ǰ");
					Object result= method.invoke(obj, args);
//					System.out.println(result);
//					System.out.println("����ִ�к�");
					sqlSession.commit();
					
					return result;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("�ύʧ�ܣ����ݻع�");
					sqlSession.rollback();
				}finally{
//					System.out.println("���ӹ����ر�");
					Connection_Factory.closeSqlSession();
//					System.out.println("���ӹ����رճɹ�");
				}
				return null;
				//��ȡ����
			
			}
		});
		
		
	}
}
