package com.itbank.exception;
/*
 * Exception ���� 
 * 1) Catched Exception �����ڷ� �Ͽ��� �ݵ�� ����ó���� �����ϴ� ���
 *      try ���ϸ� ������ ���� ���..����� ����..
 * 2) RuntimeException
 * */
public class RegistFailException extends RuntimeException{
	public RegistFailException(String msg) {
		super(msg);
	}
}




