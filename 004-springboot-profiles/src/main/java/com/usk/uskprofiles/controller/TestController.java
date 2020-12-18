package com.usk.uskprofiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usk.uskprofiles.profileConfig.TestConfig;

@RestController
public class TestController {
	
	@Autowired
	TestConfig testConfig;

	@GetMapping("/url")
	public String getUrl() {
		return testConfig.getUrl();
	}
}
