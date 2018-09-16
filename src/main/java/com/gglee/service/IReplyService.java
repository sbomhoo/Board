package com.gglee.service;

import java.util.List;

import com.gglee.domain.Criteria;
import com.gglee.domain.ReplyVO;

/**
 * 댓글 관련 기능을 정의한 비즈니스 계층 인터페이스
 * 
 * @author gglee
 */
public interface IReplyService {
	
	/**
	 * 댓글을 추가한다.
	 * 
	 * @param reply ReplyVO
	 * @throws Exception
	 */
	public void addReply(ReplyVO reply) throws Exception;
	
	/**
	 * 댓글을 수정한다.
	 * 
	 * @param reply ReplyVO
	 * @throws Exception
	 */
	public void modifyReply(ReplyVO reply) throws Exception;
	
	/**
	 * 댓글을 삭제한다.
	 * 
	 * @param rno Integer
	 * @throws Exception
	 */
	public void removeReply(Integer rno) throws Exception;
	
	/**
	 * 댓글 목록을 조회한다.
	 * 
	 * @param bno Integer 게시글 번호
	 * @return List<ReplyVO>
	 * @throws Exception
	 */
	public List<ReplyVO> listReply(Integer bno) throws Exception;
	
	/**
	 * 페이징 처리가 적용된 댓글 목록을 반환한다.
	 * 
	 * @param bno Integer
	 * @param criteria Criteria
	 * @return List<ReplyVO>
	 * @throws Exception
	 */
	public List<ReplyVO> listReplyPage(Integer bno, Criteria criteria) throws Exception;
	
	/**
	 * 인자로 전달된 게시번 번호에 등록된 댓글의 총 개수를 반환한다.
	 * 
	 * @param bno Integer
	 * @return int
	 */
	public int count(Integer bno) throws Exception;

}
