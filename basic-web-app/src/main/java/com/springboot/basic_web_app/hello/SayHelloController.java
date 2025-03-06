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
	
	// JSP is popular View technology
	// "say-hello-jsp" => sayHello.jsp
	// src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	// prefix + name of jsp + suffix => properties file
	@RequestMapping("say-hello-jsp")
	// No @ResponseBody. Then by default Spring considers String as View name.
	// @ResponseBody
	public String sayHellojsp() {
		return "sayHello";
	}
	/*
	 * Had to add below to pom.xml
	 * <dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>
	 * 
	 */
}
