package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

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
	public void modifyBoard(BoardVO vo) {
		
		dao.modify(vo);
		
	}
	
	
	
}
