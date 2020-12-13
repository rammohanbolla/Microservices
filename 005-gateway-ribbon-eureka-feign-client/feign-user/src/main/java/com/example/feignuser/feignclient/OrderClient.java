package com.example.feignuser.feignclient;

import java.util.List;

import javax.ws.rs.HeaderParam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.feignuser.dto.Order;

//@FeignClient(value="order-service", url="http://localhost:8081/demo/orders")
@FeignClient(name="http://ORDER-SERVICE/orders")
//@FeignClient(name = "http://ORDER-SERVICE/demo/orders", configuration = CustomFeignConfiguration.class)
public interface OrderClient {
	
	@GetMapping("/test")
	public String getPortNo();
	
	@GetMapping("")
	public List<Order> getAll();
	
	@GetMapping("/{userId}")
	public List<Order> getAllById(@PathVariable("userId") String userId);
	
	@GetMapping("/byparam")
	public List<Order> getAllByReqParam(@RequestParam("userId") String userId);
	
	@PostMapping(value="/byparam", produces="application/json", consumes="application/json")
	public List<Order> getAllByPostReqParam(@RequestHeader("Auth-Token") String tocken, @RequestParam("userId") String userId);
	
	@PostMapping("/bybody")
	public Order getAllByPostReqBody(@RequestBody Order order);

}
