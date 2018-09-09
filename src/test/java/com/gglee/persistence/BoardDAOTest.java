package com.gglee.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gglee.domain.BoardVO;

/**
 * BoardDAO 테스트 클래스<br>
 * 각 테스트 메서드는 순차적으로 수행하고 실제 데이터베이스에 데이터를 조회하여
 * 기능이 적용되었는지 체크한다. 
 * 
 * @author gglee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })	
public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Inject
	private IBoardDAO boardDAO;
	
	@Test
	public void testCreate() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("제목");
		boardVO.setContent("내용");
		boardVO.setWriter("이광기");
		
		boardDAO.create(boardVO);
	}
	
	@Test
	public void testRead() throws Exception {
		logger.info(boardDAO.read(1).toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(2);
		boardVO.setTitle("수정된 제목");
		boardVO.setContent("수정된 내용");
		
		boardDAO.update(boardVO);
	}
	
	@Test
	public void testDelete() throws Exception {
		boardDAO.delete(1);
	}

}
