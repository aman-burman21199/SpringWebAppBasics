package com.springboot.basic_web_app.todoapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(1,"Aman","Learn Spring",LocalDate.now().plusWeeks(1),false));
		todos.add(new Todo(1,"Aman","Learn Spring Boot",LocalDate.now().plusWeeks(1),false));
		todos.add(new Todo(1,"Aman","Learn Docker",LocalDate.now().plusWeeks(1),false));
	}
	
	public List<Todo> findByUsername(String name){
		return todos;
	}
}
