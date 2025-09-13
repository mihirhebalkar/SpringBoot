package com.example.SpringBasicSecurity.config;

import com.example.SpringBasicSecurity.SpringBasicSecurityApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
		throws Exception {
		return http
				.authorizeRequests()
				.requestMatchers(HttpMethod.GET, "/getEmail/*").authenticated()
				.requestMatchers(HttpMethod.GET, "/admin/**").hasAuthority("ADMIN")
				.requestMatchers(HttpMethod.GET, "/user/**").hasAuthority("USER")
				.requestMatchers(HttpMethod.GET, "/guest").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.and()
				//.authenticationManager(authenticationManager())
				.csrf().disable()
				.build();
	}
}
