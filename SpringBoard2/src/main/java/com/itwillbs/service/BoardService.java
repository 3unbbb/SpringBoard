package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {
	
	public void boardCreate(BoardVO vo);
	
	public List<BoardVO> getBoardListAll();

	public BoardVO getBoardContent(int bno);

	public void modifyBoard(BoardVO vo);

}