package com.itbank.model.service;

import java.util.List;

import com.itbank.model.domain.Board;

//로직을 담지 말고, 이 객체를 구현할 객체들이 반드시 지켜야할 기능만을
//명시
public interface BoardService {
	public List selectAll(); //모든 게시물 가져오기
	public Board select(int board_id);//한건만 가져오기
	public void insert(Board board);
	public void update(Board board);
	public void delete(int board_id);
}







