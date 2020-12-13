package com.hcl.springbooth2db.service;

import java.util.List;

import com.hcl.springbooth2db.entity.Employee;
import com.hcl.springbooth2db.exception.EmployeeNotFoundException;

public interface EmployeeService {
	
	public List<Employee> getAll();

	public void addEmployee(Employee employee);

	public void deleteEmployee(Long empId);

	public Employee findById(Long id) throws EmployeeNotFoundException;

}
