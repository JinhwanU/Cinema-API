package kr.ac.kopo.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {

	private SqlSession sessionDB1;
	private SqlSession sessionDB2;
	private SqlSession sessionDB3;

	public MyBatisConfig() {
		try {
			String resourceDB1 = "mybatis-config-db1.xml";
			InputStream inputStreamDB1 = Resources.getResourceAsStream(resourceDB1);
			SqlSessionFactory sqlSessionFactoryDB1 = new SqlSessionFactoryBuilder().build(inputStreamDB1, "db1");
			sessionDB1 = sqlSessionFactoryDB1.openSession();

			// DB2 설정 로드
			String resourceDB2 = "mybatis-config-db2.xml";
			InputStream inputStreamDB2 = Resources.getResourceAsStream(resourceDB2);
			SqlSessionFactory sqlSessionFactoryDB2 = new SqlSessionFactoryBuilder().build(inputStreamDB2, "db2");
			sessionDB2 = sqlSessionFactoryDB2.openSession();

			// DB3 설정 로드
			String resourceDB3 = "mybatis-config-db3.xml";
			InputStream inputStreamDB3 = Resources.getResourceAsStream(resourceDB3);
			SqlSessionFactory sqlSessionFactoryDB3 = new SqlSessionFactoryBuilder().build(inputStreamDB3, "db3");
			sessionDB3 = sqlSessionFactoryDB3.openSession();

			// 입력 스트림 닫기
			inputStreamDB1.close();
			inputStreamDB2.close();
			inputStreamDB3.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SqlSession getInstanceDB1() {
		return sessionDB1;
	}

	public SqlSession getInstanceDB2() {
		return sessionDB2;
	}

	public SqlSession getInstanceDB3() {
		return sessionDB3;
	}
}
