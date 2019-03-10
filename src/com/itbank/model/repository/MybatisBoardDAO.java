package com.itbank.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itbank.exception.RegistFailException;
import com.itbank.model.domain.Board;

@Repository
public class MybatisBoardDAO implements BoardDAO{
	
	//mybatis �������� �����ϴ� ��ü�̰�, mybatis �� ������ �����ֵ���
	//�����ϴ� ���ø� Ŭ����!!
	//�� ��ü�� ��������, ���� ���Ͽ��� bean���� ����ؾ� �Ѵ�!!
	@Autowired
	private SqlSessionTemplate sessionTemplate; 
	
	@Override
	public List selectAll() {
		System.out.println("DAO�� selectAll ȣ��");
		List list=sessionTemplate.selectList("Board.selectAll");
		return list;
	}

	@Override
	public Board select(int board_id) {
		return sessionTemplate.selectOne("Board.select", board_id);
	}

	/*�����ڰ� �Ϻη� ���ܸ� ����Ų ������?
	 * ������ �߻������� ȣ��α��� �����ϱ� �����̴�..�� �����Ϸ���, 
	 * ���⼭ ���ܸ� ����(catch)����, �޼��� ȣ���ڿ��� å���� ���ѱ���..
	 * */
	public void insert(Board board) throws RegistFailException{
		int result=sessionTemplate.insert("Board.insert", board);
		if(result==0) {
			throw new RegistFailException("��Ͽ���");
		}
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
