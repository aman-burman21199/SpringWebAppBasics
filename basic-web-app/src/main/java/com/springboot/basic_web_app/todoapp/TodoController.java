package com.springboot.basic_web_app.todoapp;

import java.util.List;

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
		List<Todo> todos = todoService.findByUsername("Aman");
		model.put("todos",todos);
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		Todo todo = new Todo(0,(String)model.get("name"),"",null,false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = (String)model.get("name");
		todoService.addTodo(username,todo.getDescription(),null,false);
		// Instead re-writing listTodos() block here again and calling jsp,
		// we can just redirect to the url using below.
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodoById(@RequestParam int id) {
		todoService.deleteTodoById(id);
		return "redirect:list-todos";
	}
}
