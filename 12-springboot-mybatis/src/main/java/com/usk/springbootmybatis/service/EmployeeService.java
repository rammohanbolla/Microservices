package com.usk.springbootmybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usk.springbootmybatis.entity.Employee;
import com.usk.springbootmybatis.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public int getEmployeeById(long employeeId){
		return employeeRepository.insert(new Employee(employeeId, "santhosh", "uppari", "usk@gmail.com"));
	}
}
