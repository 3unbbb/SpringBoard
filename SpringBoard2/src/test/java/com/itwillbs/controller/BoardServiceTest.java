package com.itwillbs.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;
import com.itwillbs.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardServiceTest {
		
	//@Inject
	//private BoardDAO dao;
	//서비스에 dao가 있음
	
	@Inject
	private BoardService service;
	
	@Test
	public void 글쓰기서비스() {
		BoardVO vo = new BoardVO();
		vo.setTitle("1번 글");
		vo.setContent("1번 글 내용");
		vo.setWriter("작성자1");
		
		service.boardCreate(vo);
	}
	
	
}
