package com.springboot.basic_web_app.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello Controller.";
	}
	
	// Better to use 'View' than write Html like this.
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Spring Html</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("This is html response body.");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
}
