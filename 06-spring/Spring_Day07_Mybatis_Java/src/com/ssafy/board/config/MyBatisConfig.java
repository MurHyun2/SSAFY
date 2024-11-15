package com.ssafy.board.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
	
	// 공장을 세워서 쓰기 위함
	private static SqlSessionFactory factory;
		
	static {
		//공장을 세워야하는데 그 자원(설정파일) 위치
		String resource = "mybatis-config.xml";
		try(InputStream inputStream = Resources.getResourceAsStream(resource)) {
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("Factory Construction Completed");
		} catch (IOException e) {
			System.out.println("Factory Construction Failure");
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
