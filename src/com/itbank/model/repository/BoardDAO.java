package com.itbank.model.repository;

import java.util.List;

import com.itbank.model.domain.Board;

public interface BoardDAO {
	public List selectAll(); //모든 게시물 가져오기
	public Board select(int board_id);//한건만 가져오기
	public void insert(Board board);
	public void update(Board board);
	public void delete(int board_id);
}



