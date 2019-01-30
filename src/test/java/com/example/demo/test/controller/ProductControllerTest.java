package com.example.demo.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.abstracttest.AbstractControllerTest;
import com.example.demo.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductControllerTest extends AbstractControllerTest {
	
	@Override
   	@Before
   	public void setUp() {
	   super.setUp();
   	}

	@Test
	public void test1Create() throws Exception {
	   String uri = "/product/create";
	   Product product = new Product();
	   product.setId(1);
	   product.setName("Ginger1");
	   product.setPrice(100);
	   
	   String inputJson = super.mapToJson(product);
	   System.out.println(inputJson);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE)	      
	      .content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   System.out.println(status);
	   assertEquals(201, status);
	
	}
	
	@Test
	public void test2UpdateProduct() throws Exception {
		String uri = "/product/update";
		Product product = new Product();
		product.setId(1);
		product.setName("Ginger");
		product.setPrice(100);
	   
		String inputJson = super.mapToJson(product);
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	@Test
	public void test3FindProdcutById() throws Exception {
	   String uri = "/product/1";
	  
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   //assertEquals(content, "Product is updated successsfully");
	}
	
	@Test
	public void test4GetProducts() throws Exception {
		
		  String uri = "/product/get";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println(content);
	      Product[] productlist = super.mapFromJson(content, Product[].class);
	      assertTrue(productlist.length > 0);
	}
	
	@Test
	public void test5DeleteProduct() throws Exception {
		String uri = "/product/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(204, status);
	}
}
