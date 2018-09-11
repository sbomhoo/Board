package com.gglee.persistence;

import java.util.List;

import com.gglee.domain.BoardVO;
import com.gglee.domain.Criteria;

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
	
	/**
	 * 페이징 처리를 위해서 사용한다. 인자로 전달 받는 <code>page</code> 값을 이용해서 
	 * 특정 범위의 게시글 목록만 가져와서 반환한다.
	 * 
	 * <p>page 값에 따라 목록 10개씩 가져온다.</p>
	 * 
	 * @param page int
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	public List<BoardVO> listPage(int page) throws Exception;
	
	/**
	 * 검색 조건 정보를 담은 <code>Criteria</code> 객체를 인자로 받아서 특정 범위의
	 * 게시글 목록만 가져와서 반환한다.
	 * 
	 * @param criteria Criteria
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception;

	/**
	 * 게시글 전체 목록 개수를 반환한다.
	 * 
	 * @param criteria Criteria
	 * @return int
	 * @throws Exception
	 */
	public int countPaging(Criteria criteria) throws Exception;
}
