package com.usk.trainingdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usk.trainingdemo.entity.User;

@Service
public interface UserService {
	
	public void saveUser(User user);
	
	public User getUserById(Long userId);

	List<User> getAllUsers();
	
	List<User> getUsersByName(String firstName, String lastName);

	public List<User> getUser(int pageNumber, int pageSize);

}
