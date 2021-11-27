package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityTestConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.anyRequest().authenticated();
		http.formLogin()
			.loginProcessingUrl("/test1/testform")
			.loginPage("/test1/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.successForwardUrl("/test1/testform")
			.failureUrl("/?error");
		http.logout()
			.logoutSuccessUrl("/?logout").permitAll();
	}
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder enc = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
				// .withUser("1").password("2").roles("USER");
				.withUser("test1").password(enc.encode("1")).roles("USER");
	}
}