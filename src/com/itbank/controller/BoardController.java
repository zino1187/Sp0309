package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.aop.Student;
import com.itbank.model.service.BoardService;

/*Controller 어노테이션을 명시하면, 아래의 클래스는 빈설정 xml에 등록
   하지 않더라도, 컨트롤러임을 등록하는 효과가 난다, spring 2.5부터 등장..
   지금 이 방법이 압도적 -- Spring Boot !!  */
@Controller
public class BoardController {
	//Autowired를 명시한 객체는 , 스프링 컨테이너가 알아서 객체를 주입시켜줌
	@Autowired
	private Student student;
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping("/board/list")
	public String selectAll(Model model) {
		//logger.debug("게시판 목록을 원하시는 군요!!");
		//student.getUp();
		List list=boardService.selectAll();
		model.addAttribute("boardList", list); //저장!!!
		return "board/list";
	}
}













