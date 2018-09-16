package com.gglee.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gglee.domain.Criteria;
import com.gglee.domain.ReplyVO;
import com.gglee.persistence.IReplyDAO;

/**
 * 댓글 관련 비즈니스 계층 구현 클래스<br>
 * IReplyService 구현 객체를 주입 받아서 작업을 실행한다.
 * 
 * @author gglee
 */
@Service
public class ReplyServiceImpl implements IReplyService {

	@Inject
	private IReplyDAO replyDAO;
	
	@Override
	public void addReply(ReplyVO reply) throws Exception {
		replyDAO.create(reply);
	}

	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		replyDAO.update(reply);
	}

	@Override
	public void removeReply(Integer rno) throws Exception {
		replyDAO.delete(rno);
	}

	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
		return replyDAO.list(bno);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer bno, Criteria criteria) throws Exception {
		return replyDAO.listPage(bno, criteria);
	}

	@Override
	public int count(Integer bno) throws Exception {
		return replyDAO.count(bno);
	}

}
