package com.usk.springbootmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.usk.springbootmybatis.service.EmployeeService;

@RestControllerAdvice
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/{employeeId}")
	public String getEmployeeById(@PathVariable long employeeId){
		employeeService.getEmployeeById(employeeId);
		return "Success";
	}
}
