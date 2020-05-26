package com.etoak.exception;
//自定义异常
public class ParamException extends RuntimeException{
	/**
	 * 继承RuntimeException super(message); 父类的
	 */
	private static final long serialVersionUID = 1L;

	public ParamException(String message) {
		super(message);
	}
}
