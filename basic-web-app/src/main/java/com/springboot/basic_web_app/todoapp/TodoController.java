package com.springboot.basic_web_app.todoapp;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("/list-todos")
	public String listTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("Aman");
		model.put("todos",todos);
		return "listTodos";
	}
	
	@RequestMapping(value="/add-todo",method = RequestMethod.GET)
	public String showNewTodoPage() {
		return "todo";
	}
	
	@RequestMapping(value="/add-todo",method = RequestMethod.POST)
	public String addNewTodoPage() {
		// Instead re-writing listTodos() block here again and calling jsp,
		// we can just redirect to the url using below.
		return "redirect:list-todos";
	}
}
