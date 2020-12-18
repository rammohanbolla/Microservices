package com.hcl.springbooth2db.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerIntegrationTest {
	
	@Autowired
	EmployeeController employeeController;
	
	MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}
	
	@Test
	public void testAdd() throws Exception{
		String jsonString = "{\n" +
                "\"firstName\":\"fname\",\n" +
                "\"lastName\":\"lname\"\n" +
                "}";
		mockMvc.perform(MockMvcRequestBuilders.post("/user")
				.contentType(MediaType.APPLICATION_JSON)
                .content(jsonString));
	}
	
	@Test
	public void testGetAll() throws Exception {
		
		MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/user/all"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		String content = response.getResponse().getContentAsString();
		System.out.println("mvc result =====>>"+content);

	}

}
