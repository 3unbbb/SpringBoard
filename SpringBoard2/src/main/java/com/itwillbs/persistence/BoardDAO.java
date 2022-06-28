package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

public interface BoardDAO {
	
	//글쓰기 동작(create)
	public void create(BoardVO vo);
	
	//글리스트(select - list)
	public List<BoardVO> listAll();

	//글 정보
	public BoardVO content(Integer bno);
	
	//글 수정
	public void updateBoard(BoardVO vo);
	
	//글 삭제
	public void removeBoard(Integer bno);
	
	//조회수 증가
	public void updateBoardCnt(int bno);
	
	//글 페이징 처리
	public List<BoardVO> listPage();

	public List<BoardVO> listPage(int page, int size);
	public List<BoardVO> listPage(Criteria cri);

	//글 전체 개수 조회
	public Integer getTotalCnt();
	
	
}