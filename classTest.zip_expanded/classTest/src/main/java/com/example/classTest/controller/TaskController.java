package com.example.classTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.classTest.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	TaskService service;
	
	@GetMapping("/")
	public String hello()
	{
		return "Welcome To Tasks Manager";
	}
	
	@GetMapping("/tasks")
	public List<String> getTasks(){
		return service.getTasks();	
	}
	
	@PostMapping("/tasks")
	public String addTasks(@RequestBody String task){
		return service.addTasks(task);
	}
	
	@PutMapping("/tasks/{index}")
    public String updateTask(@PathVariable int index, @RequestBody String updatedTask) {
        return service.updateTask(index, updatedTask);
    }
	
    @DeleteMapping("/tasks/{index}")
    public String deleteTask(@PathVariable int index) {
        return service.deleteTask(index);
    }
	
	
}
