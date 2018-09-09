package com.gglee.persistence;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * DataSource 테스트 클래스
 * 
 * @author gglee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DataSourceTest {

	@Inject
	private DataSource dataSource;
	
	@Test
	public void testDbConnection() throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			// 유효한 Connection 객체인지 확인한다.
			assertNotNull(connection);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
