package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	//DAO객체 주입
	@Inject
	private BoardDAO dao;
	
	
	@Override
	public void boardCreate(BoardVO vo) {
		dao.create(vo);
	}
	
	@Override
	public List<BoardVO> getBoardListAll(){
		List<BoardVO> boardList = dao.listAll();
		
		return boardList;
	}

	@Override
	public BoardVO getBoardContent(int bno) {
		
		BoardVO vo = dao.content(bno);
		
		
		return vo;
	}

	@Override
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
		
	}

	@Override
	public void deleteBoard(Integer bno) {
		dao.removeBoard(bno);
		
	}

	@Override
	public void updateBoardCnt(int bno) {
		dao.updateBoardCnt(bno);
		
	}


	
	
	
}
