package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger log = 
			LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	//글쓰기 - GET
	//http://localhost:8088/board/register
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET() {
		log.info("registerGET() 호출");
	}
	
	// 글쓰기 - POST
		@RequestMapping(value = "/register",method = RequestMethod.POST)
		public String registerPOST(BoardVO vo, RedirectAttributes rttr) {
			log.info(" registerPOST() 호출 ");
			// 한글처리 (=> web.xml 필터로 처리) 
			// 전달된 정보 저장(글쓰기 정보)
			log.info(" 글쓰기 정보 : "+vo);
			
			// 서비스 동작 호출
			service.boardCreate(vo);
			log.info(" 글쓰기 완료! ");
			
			rttr.addFlashAttribute("result", "REGOK");
			//log.info("결과 : "+ msg);
			
					
			//return "/board/success";
			//return "redirect:/board/listAll?msg=ok";
			return "redirect:/board/listAll";
		}
		
		
		// http://localhost:8088/board/listAll
		//글목록
	@RequestMapping(value="/listAll", method = RequestMethod.GET)
	public void listAllGET(Model model, @ModelAttribute("result") String result) {
		log.info("listAllGET() 호출");
		
		//디비에 저장되어 있는 모든 글정보를 가져와서
		//=> 서비스 동작
		List<BoardVO> boardList = service.getBoardListAll();
		//log.info(boardList+"")
		
		//연결된 뷰 페이지에 출력
		model.addAttribute("boardList", boardList);
		model.addAttribute("result", result);
	}
	
	
	//http://localhost:8088/board/read?bno=1
	//글 본문보기
	@RequestMapping(value="/read", method=RequestMethod.GET)
	//public void readGET(@ModelAttribute("bno") int bno) {
		public void readGET(@RequestParam("bno") int bno, Model model) {
		//@RequestParam							=> request.getParameter("이름");
		//->문자열, 숫자, 날짜 등 자동 형변환 	-> 무조건 스트링으로 가져옴
		log.info("readGET() 호출");
		log.info("bno : "+bno);
		
		// 글 번호를 가지고 서비스 - 글 정보 가져오기
		BoardVO vo = service.getBoardContent(bno);
		
		//가져온 데이터를 연결된 뷰 페이지에 출력
		model.addAttribute("vo", vo);
		//model.addAttribute("vo", service.getBoardContent(bno));
		//model.addAttribute(service.getBoardContent(bno));
		
		
		
	}
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(@ModelAttribute("bno") int bno, Model model) {
		log.info(" modifyGET 호출");
		
		BoardVO vo = service.getBoardContent(bno);
		model.addAttribute("vo", vo);
	}
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO vo) {
		
		log.info(" modifyPOST 호출");
		log.info(vo+"");
		
		service.modifyBoard(vo);
		log.info("글쓰기 완료");
		
		return "redirect:/board/listAll";
	}
	
	
}