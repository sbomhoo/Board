package com.gglee.service;

import java.util.List;

import com.gglee.domain.BoardVO;

/**
 * 게시글 관련 기능을 정의한 비즈니스 계층 인터페이스
 * 
 * @author gglee
 */
public interface IBoardService {
	
	/**
	 * 게시글을 등록한다.
	 * 
	 * @param board BoardVO
	 * @throws Exception
	 */
	public void register(BoardVO board) throws Exception;
	
	/**
	 * 게시글 번호를 이용해서 해당하는 게시글 객체 <code>BoardVO</code>를 찾아서 반환한다.
	 * 
	 * @param bno Integer 게시글 번호
	 * @return BoardVO
	 * @throws Exception
	 */
	public BoardVO read(Integer bno) throws Exception;
	
	/**
	 * 게시글을 수정한다.
	 * 
	 * @param board BoardVO
	 * @throws Exception
	 */
	public void modify(BoardVO board) throws Exception;
	
	/**
	 * 게시글 번호를 이용해서 해당하는 게시글을 삭제한다.
	 * 
	 * @param bno Integer 게시글 번호
	 * @throws Exception
	 */
	public void remove(Integer bno) throws Exception;
	
	/**
	 * 게시글 전체 목록을 <code>List</code> 컬렉션에 담아서 반환한다.
	 * 
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	public List<BoardVO> listAll() throws Exception;

}
