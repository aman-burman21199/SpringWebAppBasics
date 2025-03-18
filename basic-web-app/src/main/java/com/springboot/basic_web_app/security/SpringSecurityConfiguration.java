package com.springboot.basic_web_app.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	// Usually we use LDAP or Database
	
	// here we use in-memory
//	InMemoryUserDetailsManager 
	
	@Bean
	public InMemoryUserDetailsManager createDetailsManager() {
		Function<String, String> passwordEncoder
		= input -> passwordEncoder().encode(input);
		//		UserDetails userDetails = User.withDefaultPasswordEncoder()
		UserDetails userDetails = User.builder()
									.passwordEncoder(passwordEncoder)
									.username("aman")
									.password("aman")
									.roles("USER","ADMIN")
									.build();
									
		return new InMemoryUserDetailsManager(userDetails);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
