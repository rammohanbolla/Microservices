package com.example.feignuser.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.feignuser.dto.ResponseDto;

//@FeignClient(value = "order-service", url = "http://localhost:8081/demo")
@FeignClient(name = "http://ORDER-SERVICE/demo")
public interface OrderClient {
	
	@GetMapping("orders/info")
	public String getInfo();
	
	@GetMapping("/orders")
	List<ResponseDto> getOrderDetails();
	
	@GetMapping("/orders/{userId}")
	List<ResponseDto> getOrderForUser(@PathVariable("userId") String userId);
	
	@GetMapping("/orders/byparam")
	public List<ResponseDto> getAllByReqParam(@RequestParam String userId);
	
	@PostMapping("/orders/byparam")
	public List<ResponseDto> getAllByPostReqParam(@RequestParam String userId);
	
	@PostMapping("/orders/bybody")
	public ResponseDto getAllByPostReqBody(@RequestBody ResponseDto order);
	

}
