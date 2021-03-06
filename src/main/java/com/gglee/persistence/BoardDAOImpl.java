package com.gglee.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gglee.domain.BoardVO;
import com.gglee.domain.Criteria;

/**
 * IBoardDAO 인터페이스를 구현한 클래스<br>
 * 인터페이스에 정의된 기능을 실제 수행할 수 있도록 구현한다. SqlSession 객체를 주입 받아서
 * 데이터베이스 작업을 수행한다.
 * 
 * @author gglee
 */
@Repository
public class BoardDAOImpl implements IBoardDAO {
	
	@Inject
	private SqlSession sqlSession;

	/**
	 * board mapper 이름
	 */
	private static String namespace = "com.gglee.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO board) throws Exception {
		sqlSession.insert(namespace + ".create", board);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return sqlSession.selectOne(namespace + ".read", bno);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		sqlSession.delete(namespace + ".delete", bno);
	}

	@Override
	public void update(BoardVO board) throws Exception {
		sqlSession.update(namespace + ".update", board);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return sqlSession.selectList(namespace + ".listAll");
	}
	
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}

		page = (page - 1) * 10;

		return sqlSession.selectList(namespace + ".listPage", page);
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception {
		return sqlSession.selectList(namespace + ".listCriteria", criteria);
	}
	
	@Override
	public int countPaging(Criteria criteria) throws Exception {
		return sqlSession.selectOne(namespace + ".countPaging", criteria);
	}

	@Override
	public List<BoardVO> listSearch(Criteria criteria) throws Exception {
		return sqlSession.selectList(namespace + ".listSearch", criteria);
	}

	@Override
	public int listSearchCount(Criteria criteria) throws Exception {
		return sqlSession.selectOne(namespace + ".listSearchCount", criteria);
	}

}
