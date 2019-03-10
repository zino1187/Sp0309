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

/*Controller ������̼��� ����ϸ�, �Ʒ��� Ŭ������ ���� xml�� ���
   ���� �ʴ���, ��Ʈ�ѷ����� ����ϴ� ȿ���� ����, spring 2.5���� ����..
   ���� �� ����� �е��� -- Spring Boot !!  */
@Controller
@RequestMapping("/board")
public class BoardController {
	//Autowired�� ����� ��ü�� , ������ �����̳ʰ� �˾Ƽ� ��ü�� ���Խ�����
	@Autowired
	private Student student;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list")
	public String selectAll(@RequestParam(required=false,defaultValue="1") int currentPage ,Model model) {
		System.out.print("currentPage="+currentPage);
		
		//student.getUp();
		List list=boardService.selectAll();
		model.addAttribute("boardList", list); //����!!!
		model.addAttribute("currentPage", currentPage);
		return "board/list";
	}
	
	//�۵�� ��û ó�� 
	//�������� Ŭ���̾�Ʈ�� ������ �Ķ���͵��� Board �� ����ش�.
	//�� ������ �Ķ���͸�� Board �� ����������� �����ؾ� �Ѵ�. 
	@RequestMapping("/insert")
	public String insert(Board board) {
		//jsp ������ forwarding���� ó���ϰԵǸ� ��û�� �����ǹǷ� �ּ�â���� ������
		///board/insert �� �����־�, ���������� ���̴°� ��������� ���ΰ�ħ ������
		//board/insert �� �ǵ��ϰ� �ǹǷ� �Խù��� ��� �߰��ȴ�..
		//���: ��û ���� ���Ӱ� ��û�� �õ��ؾ� ��!!
		boardService.insert(board);
		return "redirect:/board/list";
	}
	
	//�󼼿�û ó�� 
	@RequestMapping(value="/content" , method=RequestMethod.GET)
	public String select(int board_id, Model model){
		Board board=boardService.select(board_id);
		model.addAttribute("board", board);//���!!
		return "board/content";
	}
	
	@RequestMapping("/delete")
	public String delete(int board_id) {
		
		return "redirect:/board/list"; //������!!
	}
	
	//���������� ��Ʈ�ѷ��� ��û�� ó���� ���ܰ� �߻��ϸ� �̸� �����Ͽ� ȣ�����ִ�
	//�޼��带 ������ �� �ִ�. 
	@ExceptionHandler(RegistFailException.class)
	public ModelAndView handle(RegistFailException e) {
		//ModelAndView �� Model �� View�� ������ ������ ��ü 
		//Model ���� ��ü�� ���� �� �ִ�. jsp���� request.setAttribute() �� ���� 
		ModelAndView mav = new ModelAndView("board/error");
		mav.addObject("errorObject", e);
		return mav;
	}
}






















