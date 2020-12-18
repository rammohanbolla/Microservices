package com.example.feignuser.service;

import java.util.List;

import com.example.feignuser.dto.ResponseDto;

public interface UserService {

	Object testPostWithBody(ResponseDto responseDto);

	List<ResponseDto> testPostWithParam(String userId);

	List<ResponseDto> getUserObjectsByReqParam(String userId);

	List<ResponseDto> getUserObjectsById(String userId);

	List<ResponseDto> getUserObjects();

	String test();

}
