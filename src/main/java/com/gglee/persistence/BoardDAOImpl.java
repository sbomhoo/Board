package com.gglee.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gglee.domain.BoardVO;

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

}
