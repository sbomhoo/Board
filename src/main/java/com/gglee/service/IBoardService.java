package com.gglee.service;

import java.util.List;

import com.gglee.domain.BoardVO;
import com.gglee.domain.Criteria;

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
	
	/**
	 * 검색 조건 정보를 담은 <code>Criteria</code> 객체를 이용해서 특정 범위의
	 * 게시글 목록만 가져와서 반환한다.
	 * 
	 * <p>게시글 목록 조회에서 페이징 처리를 하기 위해서 사용한다.</p>
	 * 
	 * @param criteria Criteria
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception;

	/**
	 * 게시글 전체 목록 숫자를 반환한다.
	 * 
	 * @param criteria Criteria
	 * @return int
	 * @throws Exception
	 */
	public int listCountCriteria(Criteria criteria) throws Exception;
}
