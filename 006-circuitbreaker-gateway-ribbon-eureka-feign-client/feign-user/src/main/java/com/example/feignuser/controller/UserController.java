package com.example.feignuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feignuser.dto.ResponseDto;
import com.example.feignuser.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/info")
	public String getInfo() {
		return "Success";
	}

	@GetMapping("/test")
	public String test() {
		return userService.test();
	}

	@GetMapping("")
	public List<ResponseDto> getUserObjects() {
		return userService.getUserObjects();
	}

	@GetMapping("/{userId}")
	public List<ResponseDto> getUserObjectsById(@PathVariable String userId) {
		return userService.getUserObjectsById(userId);
	}

	@GetMapping("/byparam")
	public List<ResponseDto> getUserObjectsByReqParam(@RequestParam String userId) {
		return userService.getUserObjectsByReqParam(userId);
	}

	@GetMapping("/postparam")
	public List<ResponseDto> testPostWithParam(@RequestParam String userId) {
		return userService.testPostWithParam(userId);
	}

	@GetMapping("/bybody")
	public Object testPostWithBody() {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setId(7676);
		responseDto.setDes("Feign user ");
		return userService.testPostWithBody(responseDto);
	}

}
