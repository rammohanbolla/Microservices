package com.example.feignuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feignuser.dto.Order;
import com.example.feignuser.feignclient.OrderClient;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	OrderClient orderClient;
	
	@GetMapping("")
	public List<Order> getUserOrders() {

		return orderClient.getAll();

	}
	
	@GetMapping("/{userId}")
	public List<Order> getUserOrdersById(@PathVariable String userId) {
		return orderClient.getAllById(userId);
	}
	
	@GetMapping("/byparam")
	public List<Order> getUserOrdersByReqParam(@RequestParam String userId) {
		return orderClient.getAllByReqParam("112233");
	}
	
	@GetMapping("/postparam")
	public List<Order> testPostWithParam(@RequestParam String userId){
		return orderClient.getAllByPostReqParam(userId);
	}
	
	@GetMapping("/bybody")
	public Order testPostWithBody(){
		Order order = new Order();
		order.setId(1122);
		order.setDes("Feign user");
		return orderClient.getAllByPostReqBody(order);
	}

}
