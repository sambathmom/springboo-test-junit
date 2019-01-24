package com.example.demo.test.controller;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

import com.example.demo.SpringbootTestApplicationTests;
import com.example.demo.controller.TestController;
import com.example.demo.model.MySum;

public class MySumTest extends SpringbootTestApplicationTests{
	
	@Test
	public void testMysum() {
		MySum test = new MySum();
		int result = test.mySum(15, 5);
		int testNum = 20;
		assertEquals(testNum, result);
	}

	@Test
	public void whenAssertingEquality_thenEqual() {
	    String expected = "Baeldung";
	    String actual = "Baeldung";
	 
	    assertEquals(expected, actual);
	}
	
	@Test
    public void testHomeFunction() {
        TestController testController = new TestController();
        String result = testController.home();
        assertEquals(result, "Hello World!");
    }
	
	@Test
	public void testAssertThatBothContainsString() {
		assertThat("albumen", both(containsString("a")).and(containsString("b")));
	}

	@Test
	public void testAssertThatHasItems() {
		assertThat(Arrays.asList("one", "two", "three", "four", "five"), hasItems("one", "four", "three"));
	}
	
	@Test
	public void testAssertFalse() {
		assertFalse("failure - should be false", false);
	}
	
	@Test
	public void testAssertNotNull() {
		assertNotNull("should not be null", new Object());
	}
  
	@Test
	public void testAssertNotSame() {
		assertNotSame(new Object(), new Object());
	}
  
	@Test
	public void testAssertNull() {
		assertNull("should be null", null);
	}
  
	@Test
	public void testAssertSame() {
		Integer aNumber = Integer.valueOf(768);
		assertSame("should be same", aNumber, aNumber);
	}
}
