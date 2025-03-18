package com.springboot.basic_web_app.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
//	private AuthenticationService authenticationService;
//	
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

	/*
	// We use @RequestParam to get Request parameters.
	// To send those parameters to JSP, we use Model.
	@RequestMapping("/login")
	public String login(@RequestParam String name, ModelMap model) {
		model.put("name",name);
		return "login";
	}
	*/
	
//	@GetMapping("/login")
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login() {
//		return "login";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name",getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
//	@PostMapping("/login")
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String welcome(@RequestParam String name,@RequestParam String password, ModelMap model) {
//		// Authentication
//		if(authenticationService.authenicate(name, password)) {
//			model.put("name", name);
//			return "welcome";
//		}
//		model.put("errorMessage", "Login Failed. Invalid username or password.");
//		return "login";
//	}
}
