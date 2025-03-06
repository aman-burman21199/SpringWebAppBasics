package com.springboot.basic_web_app.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	// We use @RequestParam to get Request parameters.
	// To send those parameters to JSP, we use Model.
	@RequestMapping("/login")
	public String login(@RequestParam String name, ModelMap model) {
		model.put("name",name);
		return "login";
	}
}
