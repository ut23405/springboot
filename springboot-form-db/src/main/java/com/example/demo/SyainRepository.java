package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SyainRepository {
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SyainRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void insertSyain(Syain syain) {
		jdbcTemplate.update("INSERT INTO syain(id,name) Values(?,?)",
				syain.getId(),syain.getName());
	}
}