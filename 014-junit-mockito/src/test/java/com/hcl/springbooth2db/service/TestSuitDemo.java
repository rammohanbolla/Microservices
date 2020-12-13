package com.hcl.springbooth2db.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.hcl.springbooth2db.test.AdvCalculatorTest;
import com.hcl.springbooth2db.test.CalculatorTest;

@RunWith(Suite.class)
@SuiteClasses({
	CalculatorTest.class,
	AdvCalculatorTest.class })
public class TestSuitDemo {

}
