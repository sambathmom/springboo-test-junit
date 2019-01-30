package com.example.demo.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runners.MethodSorters;

import com.example.demo.SpringbootTestApplicationTests;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest extends SpringbootTestApplicationTests {
	
	@Autowired
	ProductService productService;
	
	@Test
	public void test1Create() {
		Product product = new Product(1, "Test25", 100);
		productService.create(product);
		
		Product productSaved = new Product();
		productSaved = productService.findById(1);
		assertEquals("Test25", productSaved.getName());
		
	}
	
	@Test
	public void test2Update() {
		
		Product product = new Product(1, "TestEdit1", 100);
		productService.update(product, product.getId());
		
		Product productUpdated = new Product();
		productUpdated = productService.findById(1);
		assertEquals("TestEdit1", productUpdated.getName());
		
	}
	
	@Test
	public void test4Delete() {
		productService.delete(1);
		Product product = productService.findById(1);
		
		assertNull(product);
	}
	
	@Test
	public void test3GetProducts() {
		
		List<Product> productList = productService.getProducts();
		
		assertTrue(productList.size() > 0);
	}
}
