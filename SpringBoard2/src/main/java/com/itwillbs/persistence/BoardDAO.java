package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	
	//글쓰기 동작(create)
	public void create(BoardVO vo);
	
	//글리스트(select - list)
	public List<BoardVO> listAll();

	//글 정보
	public BoardVO content(Integer bno);
	
	//글 수정
	public void modify(BoardVO vo);
	
	
	

}