package com.itbank.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.exception.RegistFailException;
import com.itbank.model.domain.Board;
import com.itbank.model.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List selectAll() {
		System.out.println("서비스의 selectAll 호출");
		List list=boardDAO.selectAll();
		return list;
	}

	@Override
	public Board select(int board_id) {
		return boardDAO.select(board_id);
	}

	@Override
	public void insert(Board board) throws RegistFailException{
		boardDAO.insert(board);
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int board_id) {
		// TODO Auto-generated method stub
		
	}
	
}
