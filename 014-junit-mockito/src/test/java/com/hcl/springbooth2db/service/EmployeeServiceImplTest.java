package com.hcl.springbooth2db.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.hcl.springbooth2db.entity.Employee;
import com.hcl.springbooth2db.exception.DivNotsupportedException;

public class EmployeeServiceImplTest {
	
	static EmployeeServiceImpl employeeServiceImpl = null;
	
	
	@Before
	public void setup() {
		System.out.println("from setup");
		employeeServiceImpl = new EmployeeServiceImpl();
	}
	
	@Test
	public void testDivForPositive(){
		try {
			int result = employeeServiceImpl.div(4, 2);
			Assert.assertEquals(2, result);
		} catch (DivNotsupportedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = DivNotsupportedException.class)
	public void testDivForExcep() throws DivNotsupportedException{
		employeeServiceImpl.div(4, 0);
	}
	
	
	
	@Test
	public void testAddForPositiveNumbers(){
		System.out.println("from add1");
		int result = employeeServiceImpl.add(2, 3);
		
		Assert.assertEquals(5, result);
		
	}
	
	@Test
	public void testAddForNegativeNumbers(){
		System.out.println("from add2");
		int result = employeeServiceImpl.add(-2, -3);
		Assert.assertEquals(-5, result);
	}
	
	@After
	public void teardown(){
		System.out.println("from teardown");
		employeeServiceImpl = null;
	}

}
