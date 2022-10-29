package com.example.demo;
import java.io.Serializable;

public class Syain implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private  String bangou;
	private  String name;
	
	public String getBangou() {
		return bangou;
	}
	public void setBangou(String bangou) {
		this.bangou = bangou;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}