package com.example.demo.test.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.demo.SpringbootTestApplicationTests;
import com.example.demo.model.MySum;
public class MySumTest extends SpringbootTestApplicationTests{
	
	MySum test = new MySum();
	
	@SuppressWarnings("deprecation")
	@Test
	public void testMysum() {
		int result = test.mySum(15, 5);
		int testNum = 20;
		String expected = "Baeldung";
	    String actual = "Baeldung";
		assertEquals(testNum, result);
//		assertEquals(expected, actual);
	}

	@Test
	public void whenAssertingEquality_thenEqual() {
	    String expected = "Baeldung";
	    String actual = "Baeldung";
	 
	    assertEquals(expected, actual);
	}
}
