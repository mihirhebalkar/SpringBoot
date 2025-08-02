package com.example.classTest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	List<String> tasks = new ArrayList<String>();
	
	public List<String> getTasks() {
		return this.tasks;
	}
	
	public String addTasks(String task) {
		this.tasks.add(task);
		return "Task Added successfully";
	}
	
    public String updateTask(int index, String updatedTask) {
    	this.tasks.set(index, updatedTask);
    	return "Task Updated";
    }

    public String deleteTask(int index) {
    	this.tasks.remove(index);
    	return "Task Deleted";
    }
	
	
}
