package com.ssafy.exam.member.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	/**
	 * DB 접속에 필요한 url을 작성한다. url은
	 * jdbc:mysql://[host][:port]/[database][?propertyName1][=propertyValue1]형태로
	 * 작성한다. serverTimezone=UTC 설정이 없으면 오류가 발생하므로 주의한다.
	 */
	private static final String url = "jdbc:mysql://localhost:3306/prj4?serverTimezone=UTC";
	private static final String username = "ssafy";
	private static final String password = "ssafy";
	private static final String driverName = "com.mysql.cj.jdbc.Driver";
	private static DBUtil instance = new DBUtil();

	static {
		// JDBC 드라이버를 로딩한다. 드라이버 로딩은 객체 생성 시 한번만 진행하도록 하자.
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getInstance() {
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public void close(AutoCloseable... objs) {
		if (objs != null) {
			for (AutoCloseable obj : objs) {
				if (obj != null) {
					try {
						obj.close(); // 각 AutoCloseable 객체를 닫음
					} catch (Exception e) {
						e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
					}
				}
			}
		}
	}

	public void close(ResultSet rs, Statement stmt, Connection conn) {
		close(rs, stmt, conn);
	}
}