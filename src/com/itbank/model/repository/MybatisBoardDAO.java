package com.itbank.model.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itbank.exception.RegistFailException;
import com.itbank.model.domain.Board;

@Repository
public class MybatisBoardDAO implements BoardDAO{
	
	//mybatis 스프링이 지원하는 객체이고, mybatis 를 간단히 쓸수있도록
	//지원하는 템플릿 클래스!!
	//이 객체를 얻으려면, 빈설정 파일에서 bean으로 등록해야 한다!!
	@Autowired
	private SqlSessionTemplate sessionTemplate; 
	
	@Override
	public List selectAll() {
		System.out.println("DAO의 selectAll 호출");
		List list=sessionTemplate.selectList("Board.selectAll");
		return list;
	}

	@Override
	public Board select(int board_id) {
		return sessionTemplate.selectOne("Board.select", board_id);
	}

	/*개발자가 일부러 예외를 일으킨 이유는?
	 * 에러가 발생햇음을 호출부까지 전달하기 위함이다..즉 전달하려면, 
	 * 여기서 예외를 잡지(catch)말고, 메서드 호출자에게 책임을 떠넘기자..
	 * */
	public void insert(Board board) throws RegistFailException{
		int result=sessionTemplate.insert("Board.insert", board);
		if(result==0) {
			throw new RegistFailException("등록에러");
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
