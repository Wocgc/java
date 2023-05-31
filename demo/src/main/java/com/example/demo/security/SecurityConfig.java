package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
		@Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
			
				http
					.authorizeHttpRequests()
					.requestMatchers("/signin","/signup").permitAll()
					.anyRequest().permitAll();
					
				
				http
					.formLogin()
					.loginPage("/signin")
					.loginProcessingUrl("/signin");
				
				http.csrf().disable();	
			return http.build();
		}
}
