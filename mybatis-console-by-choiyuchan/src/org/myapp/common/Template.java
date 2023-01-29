package org.myapp.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSqlSession() {
			
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		
		return sqlSession;
	}
}
