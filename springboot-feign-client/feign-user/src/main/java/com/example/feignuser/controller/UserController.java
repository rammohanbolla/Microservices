package com.example.feignuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feignuser.dto.Order;
import com.example.feignuser.feignclient.ProductClient;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	ProductClient productClient;
	
	@GetMapping("")
	public List<Order> getAllUserOrders(){
		return productClient.getAll();
	}
	
	@GetMapping("/{userId}")
	public List<Order> getAllById(@PathVariable("userId") String userId){
		return productClient.getAllById(userId);
	}
	
	@GetMapping("/byGetParam")
	public List<Order> getAllByReqParam(@RequestParam String userId){
		return productClient.getAllByReqParam(userId);
	}
	
	@GetMapping("/byPostParam")
	public List<Order> getAllByPostReqParam(@RequestParam String userId){
		return productClient.getAllByPostReqParam(userId);
	}
	
	@PostMapping("/bybody")
	public Order getAllByPostReqBody(@RequestBody Order order){
		return productClient.getAllByPostReqBody(order);
	}

}
