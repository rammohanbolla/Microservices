package com.hcl.springbooth2db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.springbooth2db.entity.Employee;
import com.hcl.springbooth2db.exception.DivNotsupportedException;
import com.hcl.springbooth2db.exception.EmployeeNotFoundException;
import com.hcl.springbooth2db.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAll() {
		List<Employee> employees = employeeRepository.findAll();
		
		return employees;
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long empId) {
		Employee employee = employeeRepository.findById(empId).orElse(null);
		employeeRepository.delete(employee);
	}

	@Override
	public Employee findById(Long id) throws EmployeeNotFoundException {
		Optional<Employee> employees = employeeRepository.findById(id);
		if (employees.isPresent()) {
			return employees.get();
		} else {
			throw new EmployeeNotFoundException("Invalid employee Id");
		}
	}
	
	public int add(int a, int b) {
		return a + b;
	}

	public int div(int a, int b) throws DivNotsupportedException  {
		if (b == 0) {
			throw new DivNotsupportedException("Div by 0 not supported");
		}
		return a / b;
	}


}
