package com.devglan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.model.User;
import com.devglan.model.UserDto;
import com.devglan.service.UserService;

@RestController
public class RegistrationController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public User signup(@RequestBody UserDto user) {
		return userService.save(user);
	}

}
