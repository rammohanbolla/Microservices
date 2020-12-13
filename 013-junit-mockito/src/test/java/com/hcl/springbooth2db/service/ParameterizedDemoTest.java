package com.hcl.springbooth2db.service;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedDemoTest {
	
	@Parameter(0)
	public int p1;
	
	@Parameter(1)
	public int p2;
	
	@Parameter(2)
	public int p3;
	
	@Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 1 , 2, 3 }, { 5, 3, 8 }, { 36, 4, 40 } };
        return Arrays.asList(data);
    }
    
    @Test
    public void testAdd(){
    	EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
    	int result = employeeServiceImpl.add(p1, p2);
    	System.out.println(result);
    	Assert.assertEquals(p3, result); 
    }
    

}
