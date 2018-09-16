package com.gglee.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gglee.domain.Criteria;
import com.gglee.domain.ReplyVO;

/**
 * 댓글 데이터베이스 관련 처리를 정의한 <code>IReplyDAO</code> 인터페이스를
 * 구현한 클래스
 * 
 * @author gglee
 */
@Repository
public class ReplyDAOImpl implements IReplyDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.gglee.mapper.ReplyMapper";

	@Override
	public void create(ReplyVO reply) throws Exception {
		sqlSession.insert(namespace + ".create", reply);
	}

	@Override
	public void update(ReplyVO reply) throws Exception {
		sqlSession.update(namespace + ".update", reply);
	}

	@Override
	public void delete(Integer rno) throws Exception {
		sqlSession.delete(namespace + ".delete", rno);
	}

	@Override
	public List<ReplyVO> list(Integer bno) throws Exception {
		return sqlSession.selectList(namespace + ".list", bno);
	}

	@Override
	public List<ReplyVO> listPage(Integer bno, Criteria criteria) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("criteria", criteria);
		return sqlSession.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int count(Integer bno) throws Exception {
		return sqlSession.selectOne(namespace + ".count", bno);
	}

}
