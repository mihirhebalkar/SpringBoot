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
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, updatedTask);
            return "Task updated successfully.";
        } else {
            return "Invalid index. Task update failed.";
        }
    }

    public String deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            return "Task deleted successfully.";
        } else {
            return "Invalid index. Task deletion failed.";
        }
    }
	
	
}
