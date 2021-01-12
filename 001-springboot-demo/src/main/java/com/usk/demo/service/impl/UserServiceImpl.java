package com.usk.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.usk.demo.dto.UserResponseDto;
import com.usk.demo.entity.User;
import com.usk.demo.repository.UserRepository;
import com.usk.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public List<User> getUsersByFirstName(String firstName) {
		//List<User> users = userRepository.findByFirstName(firstName);
		List<User> users = userRepository.findByFirstNameContains(firstName);
		return users;
	}

	@Override
	public List<User> getUsersByName(String firstName, String lastName) {
		//List<User> users = userRepository.findByFirstNameAndLastName(firstName, lastName);
		List<User> users = userRepository.getUsersByName(firstName, lastName);
		
		//List<User> users = userRepository.findByFirstNameOrLastName(firstName, lastName);
		//List<User> users = userRepository.findByFirstNameContainsOrLastNameContains(firstName, lastName);
		return users;
	}
	
	@Override
	public List<UserResponseDto> getCustomUser(String firstName){
		return userRepository.getCustomUser(firstName);
	}

}
