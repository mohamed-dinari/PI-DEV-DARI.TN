package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.User;
import com.spring.service.IUserService;

import java.util.*;

@RestController
public class UserRestController {
	@Autowired
	IUserService userService;
 
	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<User> getUsers(){
		
		List<User> list = userService.retrieveAllUsers();
		return list;}
		

		
		@PostMapping("/add-user")
		@ResponseBody
		public User addUser(@RequestBody User user) {
		return userService.addUser(user);

		}

		// http://localhost:8081/SpringMVC/servlet/remove-user/{user-id}
		@DeleteMapping("/remove-user/{user-id}")
		@ResponseBody
		public void removeUser(@PathVariable("user-id") Long userId) {
		userService.deleteUser(userId);  
		}
		
		// http://localhost:8081/SpringMVC/servlet/modify-user
		@PutMapping("/modify-user")
		@ResponseBody
		public User modifyUser(@RequestBody User user) {
		return userService.updateUser(user);
		}



}

	
	

		
	

