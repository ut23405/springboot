package com.example.test1;

import java.io.Serializable;

public class Syain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;

	public Syain(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
