package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController extends WebSecurityConfigurerAdapter {
	@GetMapping("/testuser")
	public String user(@AuthenticationPrincipal OAuth2User oa2User) {
		return (String) oa2User.getAttributes().get("login");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			// "/"は、permit(許可)、ALL(すべて)
			// any(すべて)のリクエスト、authenticated(認証済み)であること
            .authorizeRequests(a -> a
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
            )
            // UNAUTHORIZED(401)
			.exceptionHandling(e -> e
					.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
				)
            // jsからcookieにアクセスするために設定
            .csrf(c -> c
          	      	.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
  			)
            // ログアウト成功時のURL("/")、permit(許可)、ALL(すべて)
            .logout(l -> l
            	.logoutSuccessUrl("/").permitAll()
            )
            // OAuth 2.0でログイン
            .oauth2Login();
		// @formatter:on
	}
}
