package com.example.user_manager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user_manager.entity.User;

@Service
public class UserService {

	List<User> users = new ArrayList<>();

	public List<User> getAllUsers() {
		return users;
	}

	public User addUser(User user) {
		users.add(user);
		return user;
	}

	public String updateUser(int id, String email) {
		for (User user : users) {
			if (user.getId() == id) {
				user.setEmail(email);
				return "User updated successfully";
			}
		}
		return "User not found";
	}

	public String deleteUser(int id) {
		User user = users.stream()
				.filter(u -> u.getId() == id)
				.findFirst()
				.orElse(null);

		if (user != null) {
			users.remove(user);
			return "User deleted successfully";
		} else {
			return "User not found";
		}
	}
}
