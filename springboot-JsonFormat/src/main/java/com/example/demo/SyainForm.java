package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SyainForm {

	private String name;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate localDate;

	private LocalTime localtime;

	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss.SSS")
	private LocalDateTime localDateTime;

//	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss.SSS")
//	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date date;
}