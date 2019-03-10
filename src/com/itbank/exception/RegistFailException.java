package com.itbank.exception;
/*
 * Exception 유형 
 * 1) Catched Exception 개발자로 하여금 반드시 예외처리를 강요하는 방식
 *      try 안하면 빨간줄 가는 경우..강요된 예외..
 * 2) RuntimeException
 * */
public class RegistFailException extends RuntimeException{
	public RegistFailException(String msg) {
		super(msg);
	}
}




