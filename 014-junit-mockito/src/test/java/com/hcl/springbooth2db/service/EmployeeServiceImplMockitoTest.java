package com.hcl.springbooth2db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.springbooth2db.entity.Employee;
import com.hcl.springbooth2db.exception.EmployeeNotFoundException;
import com.hcl.springbooth2db.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplMockitoTest {
	
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@Test
	public void testGetAll(){
		
		List<Employee> employees = new ArrayList<>();
		
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("fname1");
		employee.setLastName("lname1");
		employees.add(employee);
		
		employee = new Employee();
		employee.setId(2L);
		employee.setFirstName("fname2");
		employee.setLastName("lname2");
		employees.add(employee);
 		
		
		Mockito.when(employeeRepository.findAll()).thenReturn(employees);
		List<Employee> resultEmps = employeeServiceImpl.getAll();
		Assert.assertNotNull(resultEmps);
		Assert.assertEquals(2, resultEmps.size());
	}
	
	@Test
	public void testFindByIdForExce() throws EmployeeNotFoundException{
		
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("fname1");
		employee.setLastName("lname1");
		
		Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(employee));
		Employee employees = employeeServiceImpl.findById(2L);
		Assert.assertNotNull(employees);
		
	}
	
	@Test(expected = EmployeeNotFoundException.class)
	public void testFindByIdForExce2() throws EmployeeNotFoundException{
		
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("fname1");
		employee.setLastName("lname1");
		
		Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(employee));
		Employee employees = employeeServiceImpl.findById(2L);
		
	}

}
