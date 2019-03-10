package com.itbank.model.service;

import java.util.List;

import com.itbank.model.domain.Board;

//������ ���� ����, �� ��ü�� ������ ��ü���� �ݵ�� ���Ѿ��� ��ɸ���
//���
public interface BoardService {
	public List selectAll(); //��� �Խù� ��������
	public Board select(int board_id);//�ѰǸ� ��������
	public void insert(Board board);
	public void update(Board board);
	public void delete(int board_id);
}







