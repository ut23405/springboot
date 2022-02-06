package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SyainForm {

	private String name;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate localDate;

	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime localTime;

	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss.SSS")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss.SSS")
	private LocalDateTime localDateTime;

	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss.SSS")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss.SSS")
	private Date date;
}