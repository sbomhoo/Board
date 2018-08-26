package com.gglee.persistence;

import java.util.List;

import com.gglee.domain.BoardVO;

/**
 * 게시글 데이터베이스 관련 기능을 정의한 인터페이스<br>
 * 게시판의 게시글 생성, 삭제, 조회, 수정 기능을 지원한다.
 * 
 * @author gglee
 */
public interface IBoardDAO {

	/**
	 * 게시글 정보를 담은 객체를 전달 받아서 게시글을 새로 생성한다.
	 * 
	 * @param board BoardVO
	 * @throws Exception
	 */
	public void create(BoardVO board) throws Exception;

	/**
	 * 게시글 번호를 전달 받아서 게시글 정보를 조회하고 반환한다.
	 * 
	 * @param bno Integer 게시글 번호
	 * @return BoardVO
	 * @throws Exception
	 */
	public BoardVO read(Integer bno) throws Exception;

	/**
	 * 게시글 번호를 전달 받아서 게시글을 삭제한다.
	 * 
	 * @param bno Integer 게시글 번호
	 * @throws Exception
	 */
	public void delete(Integer bno) throws Exception;

	/**
	 * 게시글 정보를 담은 객체를 전달 받아서 게시글 정보를 수정한다.
	 * 
	 * @param board BoardVO
	 * @throws Exception
	 */
	public void update(BoardVO board) throws Exception;
	
	/**
	 * 게시글 전체 목록을 조회하고 List 형태로 반환한다.
	 * 
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	public List<BoardVO> listAll() throws Exception;

}
