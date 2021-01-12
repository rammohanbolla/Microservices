package com.usk.demo.entity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usk.demo.dto.UserResponseDto;
import com.usk.demo.entity.User;

@Service
public interface UserService {
	
	public List<UserResponseDto> getUserResponseDto(String firstName);
	
	public void saveUser(User user);
	
	public User getUserById(Long userId);

	List<User> getAllUsers();
	
	List<User> getUsersByName(String firstName, String lastName);

	public List<User> getUser(int pageNumber, int pageSize);

}
