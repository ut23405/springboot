package com.example.test1.repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.test1.SyainDto;

@Repository
public class SyainRepository {
	private final JdbcTemplate jdbcTemplate;
	
	public SyainRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void insertSyain(SyainDto syain) {
		jdbcTemplate.update("INSERT INTO syain(id,name) Values(?,?)",
				syain.getId(),syain.getName());
	}
}