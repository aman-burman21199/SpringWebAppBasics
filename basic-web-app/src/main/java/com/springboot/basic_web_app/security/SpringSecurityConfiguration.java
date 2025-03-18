package com.springboot.basic_web_app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	// Usually we use LDAP or Database
	
	// here we use in-memory
//	InMemoryUserDetailsManager 
	
	@Bean
	public InMemoryUserDetailsManager createDetailsManager() {
		UserDetails userDetails = User.withDefaultPasswordEncoder()
		.username("aman")
		.password("aman")
		.roles("USER","ADMIN")
		.build();
		
		return new InMemoryUserDetailsManager(userDetails);
	}
	
}
