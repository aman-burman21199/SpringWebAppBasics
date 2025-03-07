package com.springboot.basic_web_app.todoapp;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {
	
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("/list-todos")
	public String l(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("Aman");
		model.put("todos",todos);
		return "listTodos";
	}
}
