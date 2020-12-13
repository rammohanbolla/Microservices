package com.hcl.springbooth2db.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hcl.springbooth2db.exception.DivNotsupportedException;

import junit.framework.Assert;

public class CalculatorTest {
	
	static Calculator calculator = null;
	
	@BeforeClass
	public static void setup(){
		System.out.println("from setup ==========>>");
		calculator = new Calculator();
	}
	
	@Before
	public void test1(){
		System.out.println("from before anno ==========>>");
	}
	
	
	
	@Test(expected = DivNotsupportedException.class)
	public void testDivforExc() throws DivNotsupportedException{
		int result = calculator.div(3, 0);
	}
	
	@Test
	public void testAddForPositive(){
		System.out.println("from testAddForPositive ==========>>");
		int result = calculator.add(1, 2);
		Assert.assertEquals(3, result); 
	}
	
	@Test
	public void testAddForNegative(){
		System.out.println("from testAddForNegative ==========>>");
		int result = calculator.add(-1, -2);
		Assert.assertEquals(-3, result); 
	}
	
	@After
	public void test2(){
		System.out.println("from after anno ==========>>");
	}
	
	@AfterClass
	public static void teardown(){
		System.out.println("from teardown ==========>>");
		calculator = null;
	}
	
	

}
