package com.example.feignuser.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.feignuser.dto.ResponseDto;
import com.example.feignuser.feignclient.OrderClient;
import com.example.feignuser.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	OrderClient orderClient;

	@Override
	public String test() {
		return orderClient.getInfo();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackUserObject")
	public List<ResponseDto> getUserObjects() {
		return orderClient.getOrderDetails();
	}
	
	public List<ResponseDto> getFallbackUserObject() {
		List<ResponseDto> responseDtos = new ArrayList<>();
		ResponseDto responseDto = new ResponseDto();
		responseDto.setDes("Fallback method");
		responseDtos.add(responseDto);
		return responseDtos;
	}

	@Override
	public List<ResponseDto> getUserObjectsById(@PathVariable String userId) {
		return orderClient.getOrderForUser(userId);
	}

	@Override
	public List<ResponseDto> getUserObjectsByReqParam(@RequestParam String userId) {
		return orderClient.getAllByReqParam(userId);
	}

	@Override
	public List<ResponseDto> testPostWithParam(@RequestParam String userId) {
		return orderClient.getAllByPostReqParam(userId);
	}

	@Override
	public Object testPostWithBody(ResponseDto responseDto) {
		return orderClient.getAllByPostReqBody(responseDto);
	}

}
