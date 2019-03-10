package com.itbank.aop;

import org.springframework.stereotype.Component;
//모든 객체는 Component 로 표현될 수 있다!!
@Component
public class Student {
	//Bell bell=new Bell(); //의존성을 완전히 탈피하기 위해서는 
	//DI 마져도 개선할 필요가 있다..
	
	public void getUp() {
		//bell.sound();
		System.out.println("기상시간이에요");
	}
	public void goSchool() {
		//bell.sound();
		System.out.println("등교합니다");
	}
	public void study() {
		//bell.sound();
		System.out.println("수업을 시작합니다");
	}
	public void haveLunch() {
		//bell.sound();
		System.out.println("점심을 먹어요");
	}
	public void goHome() {
		//bell.sound();
		System.out.println("하교합니다");
	}
	public static void main(String[] args) {
		Student st = new Student();
		st.getUp();
		st.goSchool();
		st.study();
		st.haveLunch();
		st.goHome();
	}
}






