package com.gglee.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gglee.domain.BoardVO;
import com.gglee.service.IBoardService;

/**
 * BoardService 테스트 클래스<br>
 * 각 테스트 메서드는 순차적으로 수행하고 실제 데이터베이스에 데이터를 조회하여
 * 기능이 적용되었는지 체크한다. 
 * 
 * @author gglee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/test/resources/mybatis-config.xml"})	
public class BoardServiceTest {

private static final Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	
	@Inject
	private IBoardService boardService;
	
	@Test
	public void testRegister() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("서비스 테스트");
		boardVO.setContent("서비스 테스트 내용");
		boardVO.setWriter("gglee");
		
		boardService.register(boardVO);
	}
	
	@Test
	public void testRead() throws Exception {
		logger.info(boardService.read(3).toString());
	}
	
	@Test
	public void testModify() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(3);
		boardVO.setTitle("수정된 서비스 테스트");
		boardVO.setContent("수정된 서비스 내용");
		
		boardService.modify(boardVO);
	}
	
	@Test
	public void testRemove() throws Exception {
		boardService.remove(3);
	}
}
