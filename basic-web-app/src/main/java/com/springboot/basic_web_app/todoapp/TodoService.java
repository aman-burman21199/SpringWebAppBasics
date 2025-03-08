package com.springboot.basic_web_app.todoapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;
	static {
		todos.add(new Todo(++todosCount,"Aman","Learn Spring",LocalDate.now().plusWeeks(1),false));
		todos.add(new Todo(++todosCount,"Aman","Learn Spring Boot",LocalDate.now().plusWeeks(1),false));
		todos.add(new Todo(++todosCount,"Aman","Learn Docker",LocalDate.now().plusWeeks(1),false));
	}
	
	public List<Todo> findByUsername(String name){
		return todos;
	}
	
	public void addTodo(String name,String description,LocalDate targetDate,boolean done) {
		Todo todo = new Todo(++todosCount,name,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteTodoById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
}
