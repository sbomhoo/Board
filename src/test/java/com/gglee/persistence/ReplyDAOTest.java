package com.gglee.persistence;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gglee.domain.Criteria;
import com.gglee.domain.ReplyVO;

/**
 * ReplyDAO 테스트 클래스
 * 
 * <p>각 테스트 메서드는 순차적으로 수행하고 실제 데이터베이스에 데이터를 조회하여
 * 기능이 적용되었는지 체크한다.</p>
 * 
 * @author gglee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })	

public class ReplyDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@Inject
	private IReplyDAO replyDAO;
	
	@Test
	public void testCreate() throws Exception {
		ReplyVO reply = new ReplyVO();
		reply.setBno(458736);
		reply.setReplytext("댓글 내용");
		reply.setReplyer("gglee");
		
		replyDAO.create(reply);
	}
	
	@Test
	public void testUpdate() throws Exception {
		ReplyVO reply = new ReplyVO();
		reply.setRno(3);
		reply.setReplytext("수정된 댓글 내용");
		
		replyDAO.update(reply);
	}
	
	@Test
	public void testDelete() throws Exception {
		replyDAO.delete(3);
	}
	
	@Test
	public void testReplyList() throws Exception {
		List<ReplyVO> replyItems = replyDAO.list(458736);
		for (ReplyVO reply : replyItems) {
			logger.info(reply.getBno() + " : " + reply.getRno() + " : " + reply.getReplytext());
		}
	}
	
	@Test
	public void testReplyListPage() throws Exception {
		List<ReplyVO> replyItems = replyDAO.listPage(458736, new Criteria());
		for (ReplyVO reply : replyItems) {
			logger.info(reply.getBno() + " : " + reply.getRno() + " : " + reply.getReplytext());
		}
	}
	
	@Test
	public void testCount() throws Exception {
		int count = replyDAO.count(458736);
		assertEquals(3, count);
	}

}
