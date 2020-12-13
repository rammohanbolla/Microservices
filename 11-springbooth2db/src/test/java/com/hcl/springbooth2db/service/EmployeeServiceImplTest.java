package com.hcl.springbooth2db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.springbooth2db.entity.Employee;
import com.hcl.springbooth2db.exception.EmployeeNotFoundException;
import com.hcl.springbooth2db.repository.EmployeeRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeServiceImplTest {
	
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	
	@Test
	public void testFindByIdForPositive() throws EmployeeNotFoundException{
		Employee employee = new Employee();
		employee.setId(2L);
		employee.setFirstName("fname1");
		
		Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(employee));
		
		Employee resEmployee = employeeServiceImpl.findById(1L);
		Assert.assertNotNull(resEmployee);
		Assert.assertEquals("fname1", resEmployee.getFirstName());
	}
	
	@Test(expected = EmployeeNotFoundException.class)
	public void testFindByIdForExce() throws EmployeeNotFoundException{
		Employee employee = new Employee();
		employee.setId(2L);
		employee.setFirstName("fname1");
		
		Mockito.when(employeeRepository.findById(2L)).thenReturn(Optional.of(employee));
		
		Employee resEmployee = employeeServiceImpl.findById(5L);
		
	}
	
	@Test
	public void testGetAllForPosite(){
		
		List<Employee> employees = new ArrayList();
		
		Employee employee = new Employee();
		employee.setFirstName("fname1");
		employee.setId(1L);
		employees.add(employee);
		
		employee = new Employee();
		employee.setFirstName("fname2");
		employee.setId(2L);
		employees.add(employee);
		
		
		Mockito.when(employeeRepository.findAll()).thenReturn(employees);
		
		List<Employee> employees2 = employeeServiceImpl.getAll();
		Assert.assertNotNull(employees2);
		Assert.assertEquals(2, employees2.size());
		
	}

}
