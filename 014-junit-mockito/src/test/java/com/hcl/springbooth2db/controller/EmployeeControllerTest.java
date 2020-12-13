package com.hcl.springbooth2db.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.springbooth2db.entity.Employee;
import com.hcl.springbooth2db.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	MockMvc mockMvc;

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}

	@Test
	public void mockMvctest() throws Exception {

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

		Mockito.when(employeeService.getAll()).thenReturn(employees);

		MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/user/all")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String content = response.getResponse().getContentAsString();
	}

}
