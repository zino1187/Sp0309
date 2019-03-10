package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.aop.Student;
import com.itbank.exception.RegistFailException;
import com.itbank.model.domain.Board;
import com.itbank.model.service.BoardService;

/*Controller 어노테이션을 명시하면, 아래의 클래스는 빈설정 xml에 등록
   하지 않더라도, 컨트롤러임을 등록하는 효과가 난다, spring 2.5부터 등장..
   지금 이 방법이 압도적 -- Spring Boot !!  */
@Controller
@RequestMapping("/board")
public class BoardController {
	//Autowired를 명시한 객체는 , 스프링 컨테이너가 알아서 객체를 주입시켜줌
	@Autowired
	private Student student;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list")
	public String selectAll(@RequestParam(required=false,defaultValue="1") int currentPage ,Model model) {
		System.out.print("currentPage="+currentPage);
		
		//student.getUp();
		List list=boardService.selectAll();
		model.addAttribute("boardList", list); //저장!!!
		model.addAttribute("currentPage", currentPage);
		return "board/list";
	}
	
	//글등록 요청 처리 
	//스프링은 클라이언트가 전송한 파라미터들을 Board 에 담아준다.
	//단 조건은 파라미터명과 Board 의 멤버변수명이 동일해야 한다. 
	@RequestMapping("/insert")
	public String insert(Board board) {
		//jsp 에서의 forwarding으로 처리하게되면 요청이 유지되므로 주소창에는 여전히
		///board/insert 가 남아있어, 실제적으로 보이는건 목록이지만 새로고침 누르면
		//board/insert 를 의도하게 되므로 게시물이 계속 추가된다..
		//결론: 요청 끊고 새롭게 요청을 시도해야 함!!
		boardService.insert(board);
		return "redirect:/board/list";
	}
	
	//상세요청 처리 
	@RequestMapping(value="/content" , method=RequestMethod.GET)
	public String select(int board_id, Model model){
		Board board=boardService.select(board_id);
		model.addAttribute("board", board);//담기!!
		return "board/content";
	}
	
	@RequestMapping("/delete")
	public String delete(int board_id) {
		
		return "redirect:/board/list"; //재접속!!
	}
	
	//스프링에서 컨트롤러가 요청을 처리시 예외가 발생하면 이를 인지하여 호출해주는
	//메서드를 정의할 수 있다. 
	@ExceptionHandler(RegistFailException.class)
	public ModelAndView handle(RegistFailException e) {
		//ModelAndView 는 Model 과 View가 합쳐진 형태의 객체 
		//Model 에는 객체를 담을 수 있다. jsp에서 request.setAttribute() 와 동일 
		ModelAndView mav = new ModelAndView("board/error");
		mav.addObject("errorObject", e);
		return mav;
	}
}






















