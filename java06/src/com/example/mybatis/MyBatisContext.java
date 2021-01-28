package com.example.mybatis;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisContext {
	private static SqlSession session;

	public static SqlSession getSqlSession() {
		try {
			String resource = "com/example/mybatis/mybatisconfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

			session = sqlMapper.openSession();
			return session;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}


	
