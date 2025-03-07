package com.springboot.basic_web_app.login;

import org.springframework.stereotype.Service;

//@Component can also be used but @Service is specific.
@Service
public class AuthenticationService {
	
	public boolean authenicate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("aman");
		
		boolean isValidPassword = password.equalsIgnoreCase("aman");
		
		return isValidUserName && isValidPassword;
	}

}
