package com.hcl.springbooth2db.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.springbooth2db.entity.Employee;
import com.hcl.springbooth2db.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}
	
	@Test
	public void testGetAllMvc() throws Exception {

		List<Employee> employees = new ArrayList();

		Employee employee = new Employee();
		employee.setFirstName("fname1");
		employee.setId(1L);
		employees.add(employee);

		employee = new Employee();
		employee.setFirstName("fname2");
		employee.setId(2L);
		employees.add(employee);

		Mockito.when(employeeService.getAll()).thenReturn(employees);
		
		
		MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/user/all")).andReturn();
		String content = response.getResponse().getContentAsString();
		System.out.println(content);
		
		
	}

	@Test
	public void testGetAll() {

		List<Employee> employees = new ArrayList();

		Employee employee = new Employee();
		employee.setFirstName("fname1");
		employee.setId(1L);
		employees.add(employee);

		employee = new Employee();
		employee.setFirstName("fname2");
		employee.setId(2L);
		employees.add(employee);

		Mockito.when(employeeService.getAll()).thenReturn(employees);
		ResponseEntity<List<Employee>> re = employeeController.getAll();
		Assert.assertNotNull(re);
		Assert.assertEquals(HttpStatus.OK, re.getStatusCode());
		
	}

}
