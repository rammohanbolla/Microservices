package com.usk.trainingdemo.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.usk.trainingdemo.entity.User;
import com.usk.trainingdemo.repository.UserRepository;
import com.usk.trainingdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
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
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	@Override
	public List<User> getUsersByName(String firstName, String lastName) {
		//return userRepository.findByFirstName(firstName);
		//return userRepository.findByFirstNameAndLastName(firstName, lastName);
		//return userRepository.findByFirstNameOrLastName(firstName, lastName);
		//return userRepository.findByFirstNameContains(firstName);
		//return userRepository.findByFirstNameContainsOrderByFirstNameAsc(firstName);
		//return userRepository.getUser(firstName, lastName);
		return userRepository.getData(firstName);
	}

	@Override
	public List<User> getUser(int pageNumber, int pageSize) {
		//Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.ASC, "lastName"));
		return userRepository.findAll(pageable).getContent();
	}

}
