package com.example.feignuser.feignclient;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.feignuser.dto.Order;

@Component
public class OrderClientFallback implements OrderClient {

	@Override
	public String getPortNo() {
		return "Fallback port 7777";
	}

	@Override
	public List<Order> getAll() {
		return null;
	}

	@Override
	public List<Order> getAllById(String userId) {
		return null;
	}

	@Override
	public List<Order> getAllByReqParam(String userId) {
		return null;
	}

	@Override
	public List<Order> getAllByPostReqParam(String tocken, String userId) {
		return null;
	}

	@Override
	public Order getAllByPostReqBody(Order order) {
		return null;
	}

}
