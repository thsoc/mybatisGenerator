package cn.com.conn;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataConnect {
	// Mybatis≈‰÷√Œƒº˛
	private String resource = "SqlMapConfig.xml";
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() throws IOException{
		InputStream io = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(io);
		sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
