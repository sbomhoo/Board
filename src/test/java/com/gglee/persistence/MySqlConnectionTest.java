package com.gglee.persistence;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

/**
 * MySql Database 연결 테스트
 * 
 * @author gglee
 */
public class MySqlConnectionTest {

	// 데이터베이스 연결 정보
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/spring_study";
	private static final String USER = "gglee";
	private static final String PASSWORD = "gglee";

	@Test
	public void testDbConnection() throws Exception {
		// 드라이버 로드
		Class.forName(DRIVER);

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			// 유효한 Connection 객체인지 확인한다.
			assertNotNull(connection);
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
