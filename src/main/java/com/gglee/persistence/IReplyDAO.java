package com.gglee.persistence;

import java.util.List;

import com.gglee.domain.Criteria;
import com.gglee.domain.ReplyVO;

/**
 * 댓글 데이터베이스 관련 기능을 정의한 인터페이스<br>
 * 댓글 생성, 수정, 삭제, 목록 조회 기능을 지원한다.
 * 
 * @author gglee
 */
public interface IReplyDAO {
	
	/**
	 * 댓글을 새로 생성한다.
	 * 
	 * @param reply ReplyVO
	 * @throws Exception
	 */
	public void create(ReplyVO reply) throws Exception;
	
	/**
	 * 기존 댓글을 수정한다.
	 * 
	 * @param reply ReplyVO
	 * @throws Exception
	 */
	public void update(ReplyVO reply) throws Exception;
	
	/**
	 * 댓글을 삭제한다.
	 * 
	 * @param rno Integer 댓글 번호
	 * @throws Exception
	 */
	public void delete(Integer rno) throws Exception;
	
	/**
	 * 댓글 목록을 조회한다.
	 * 
	 * @param bno Integer
	 * @return List<ReplyVO>
	 * @throws Exception
	 */
	public List<ReplyVO> list(Integer bno) throws Exception;
	
	/**
	 * 페이징 처리가 된 댓글 목록을 반환한다.
	 * 
	 * @param bno Integer
	 * @param criteria Criteria
	 * @return List<ReplyVO>
	 * @throws Exception
	 */
	public List<ReplyVO> listPage(Integer bno, Criteria criteria) throws Exception;
	
	/**
	 * 페이징 처리가 적용된 댓글 목록 개수를 반환한다.
	 * 
	 * @param bno Integer
	 * @return int
	 * @throws Exception
	 */
	public int count(Integer bno) throws Exception;

}
