package com.itbank.aop;

import org.springframework.stereotype.Component;
//��� ��ü�� Component �� ǥ���� �� �ִ�!!
@Component
public class Student {
	//Bell bell=new Bell(); //�������� ������ Ż���ϱ� ���ؼ��� 
	//DI ������ ������ �ʿ䰡 �ִ�..
	
	public void getUp() {
		//bell.sound();
		System.out.println("���ð��̿���");
	}
	public void goSchool() {
		//bell.sound();
		System.out.println("��մϴ�");
	}
	public void study() {
		//bell.sound();
		System.out.println("������ �����մϴ�");
	}
	public void haveLunch() {
		//bell.sound();
		System.out.println("������ �Ծ��");
	}
	public void goHome() {
		//bell.sound();
		System.out.println("�ϱ��մϴ�");
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






