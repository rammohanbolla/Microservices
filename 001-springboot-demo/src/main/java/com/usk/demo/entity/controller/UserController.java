package com.usk.demo.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.demo.dto.UserResponseDto;
import com.usk.demo.entity.User;
import com.usk.demo.entity.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService; 
	
	@GetMapping("/dto")
	public List<UserResponseDto> getUserResponseDto(@RequestParam String firstName) {
		return userService.getUserResponseDto(firstName);
	}
	
	@GetMapping("/byname")
	public List<User> getUsersByName(@RequestParam String firstName, @RequestParam String lastName){
		return userService.getUsersByName(firstName, lastName);
	}
	
	@GetMapping("/pagenation")
	public List<User> getUser(int pageNumber, int pageSize){
		return userService.getUser(pageNumber, pageSize);
	}
	
	@GetMapping("")
	public String getData() {
		return "Success";
	}
	
	@PostMapping("")
	public String saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return "Success";
	}
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return  userService.getAllUsers();
	}

}
