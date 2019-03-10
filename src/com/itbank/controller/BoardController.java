package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.aop.Student;
import com.itbank.model.service.BoardService;

/*Controller ������̼��� ����ϸ�, �Ʒ��� Ŭ������ ���� xml�� ���
   ���� �ʴ���, ��Ʈ�ѷ����� ����ϴ� ȿ���� ����, spring 2.5���� ����..
   ���� �� ����� �е��� -- Spring Boot !!  */
@Controller
public class BoardController {
	//Autowired�� ����� ��ü�� , ������ �����̳ʰ� �˾Ƽ� ��ü�� ���Խ�����
	@Autowired
	private Student student;
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping("/board/list")
	public String selectAll(Model model) {
		//logger.debug("�Խ��� ����� ���Ͻô� ����!!");
		//student.getUp();
		List list=boardService.selectAll();
		model.addAttribute("boardList", list); //����!!!
		return "board/list";
	}
}













