package com.example.demo;

public class TestException extends RuntimeException {

	private static final long serialVersionUID = 1L; 

	TestException(String msg){
		super(msg);
	}
}