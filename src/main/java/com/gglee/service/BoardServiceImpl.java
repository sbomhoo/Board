package com.gglee.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gglee.domain.BoardVO;
import com.gglee.persistence.IBoardDAO;

/**
 * 게시글 관련 비즈니스 계층 구현 클래스<br>
 * IBoardDAO 구현 객체를 주입 받아서 작업을 실행한다.
 * 
 * @author gglee
 */
@Service
public class BoardServiceImpl implements IBoardService {
	
	@Inject
	private IBoardDAO boardDAO;

	@Override
	public void register(BoardVO board) throws Exception {
		boardDAO.create(board);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return boardDAO.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		boardDAO.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		boardDAO.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardDAO.listAll();
	}

}
