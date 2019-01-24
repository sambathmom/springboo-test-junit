package com.example.demo.test.model;

import static org.junit.Assert.assertEquals;

import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.SpringbootTestApplicationTests;
import com.example.demo.dao.ProductDaoImp;
import com.example.demo.model.Product;

public class ProductModelTest extends SpringbootTestApplicationTests{
	
	@Autowired
	TestEntityManager testEntityManger;
	
	static Product testProduct;
	
	@BeforeClass
	public static void initializeObject() {
		testProduct = new Product(1, "Cocala", 899);
	}
	
//	@Test
//	public void getIdTest() {
//		assertEquals(1, testProduct.getId());
//	}
//	
//	@Test
//	public void getNameTest() {
//		
//		assertEquals("Cocala", testProduct.getName());
//	}
//	
//	@Test
//	public void getPriceTest() {
//		assertEquals(899, testProduct.getPrice(), 0.00);
//	}
	
	@Test
	public void setGetIdTest() {
		testProduct.setId(2);
		
		assertEquals(2, testProduct.getId());
	}
	
	@Test
	public void setGetNameTest() {
		
		testProduct.setName("Food");
		
		assertEquals("Food", testProduct.getName());
	}
	
	@Test
	public void setGetPriceTest() {
		testProduct.setPrice(100.02);
		
		assertEquals(100.02, testProduct.getPrice(), 0.00);
	}
	


}
