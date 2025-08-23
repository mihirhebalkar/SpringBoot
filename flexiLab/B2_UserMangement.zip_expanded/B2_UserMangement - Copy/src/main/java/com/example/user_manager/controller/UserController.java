package com.example.user_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.user_manager.entity.User;
import com.example.user_manager.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/get")
	public List<User> getUsers() {
		return service.getAllUsers();
	}

	@PostMapping("/post")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}

	@PutMapping("/put/{id}")
	public String updateUser(@PathVariable int id, @RequestBody User user) {
		return service.updateUser(id, user.getEmail());
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}
}
