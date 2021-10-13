package com.example.demo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Test1Form {

	@Pattern(regexp = "^[0-9]+$", message = "数値を入力してください")
	private String id;

	@Size(min = 3, max = 6, message = "3文字から6文字で入力して下さい")
	private String name;
	
	@NotBlank(message="必須項目です")
	private String romaji;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRomaji() {
		return romaji;
	}

	public void setRomaji(String romaji) {
		this.romaji = romaji;
	}
}