package com.hcl.springbooth2db.test;

import com.hcl.springbooth2db.exception.DivNotsupportedException;

public class Calculator {
	
	public int add(int a, int b){
		return a+b;
	}
	
	public int mul(int a, int b){
		return a*b;
	}
	
	public int div(int a, int b) throws DivNotsupportedException{ 
		if(b == 0){
			throw new DivNotsupportedException("div not supported");
		}
		return a/b;
	}

}
