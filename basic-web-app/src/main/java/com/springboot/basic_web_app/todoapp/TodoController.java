package com.springboot.basic_web_app.todoapp;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listTodos(ModelMap model) {
		String username = getLoggedinUsername(model);
		List<Todo> todos = todoService.findByUsername(username);
		model.put("todos",todos);
		return "listTodos";
	}

	private String getLoggedinUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		Todo todo = new Todo(0,getLoggedinUsername(model),"",null,false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedinUsername(model);
		todoService.addTodo(username,todo.getDescription(),todo.getTargetDate(),false);
		// Instead re-writing listTodos() block here again and calling jsp,
		// we can just redirect to the url using below.
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String updateTodoPage(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedinUsername(model);
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodoById(@RequestParam int id) {
		todoService.deleteTodoById(id);
		return "redirect:list-todos";
	}
}
