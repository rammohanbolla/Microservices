package com.hcl.springbooth2db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.springbooth2db.entity.Employee;
import com.hcl.springbooth2db.exception.EmployeeNotFoundException;
import com.hcl.springbooth2db.service.EmployeeService;

@RestController
@RequestMapping("/user")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAll(){
		List<Employee> employees = employeeService.getAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
		return new ResponseEntity<String>("Employee added successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("")
	public ResponseEntity<String> deleteEmployee(@RequestParam Long empId){
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<String>("EMployee deleted successfully", HttpStatus.OK);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getAll(@PathVariable Long empId){
		Employee employee = null;
		try {
			employee = employeeService.findById(empId);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
}
