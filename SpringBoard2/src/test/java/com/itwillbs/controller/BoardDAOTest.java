package com.itwillbs.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BoardDAOTest {

	//DAO 객체 필요 => 객체 주입
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void 글쓰기동작() {
		BoardVO vo = new BoardVO();
		vo.setTitle("공지사항입니다.");
		vo.setContent("주말은 휴무");
		vo.setWriter("관리자");
		
		dao.create(vo);
		
	}
	
	
	
}
