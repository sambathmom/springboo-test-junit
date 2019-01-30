package com.example.demo.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.catalina.LifecycleListener;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.SpringbootTestApplicationTests;
import com.example.demo.dao.ProductDaoImp;
import com.example.demo.model.Product;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoImpTest extends SpringbootTestApplicationTests {

	@Autowired
	ProductDaoImp productDao;
	
	@Test
    public void test1SaveAndFindById() {
        Product productToBeSaved = new Product(1, "fifa", 12);
        productDao.add(productToBeSaved);
        
        Product product = productDao.findById(1);

        assertEquals("fifa", product.getName());
    }
	
	@Test
	public void test2Update() {
		/* Save */
		Product productToBeSaved = new Product(1, "fifa", 12);
        productDao.add(productToBeSaved);
        
        /* Update */
        productToBeSaved.setName("Dola");
        productToBeSaved.setPrice(22);
        Product productUpdate = productDao.update(productToBeSaved, productToBeSaved.getId());
        
        assertEquals("Dola", productUpdate.getName());
		
	}
	
	@Test
	public void test3GetProducts() {
		List<Product> productList = productDao.getProducts();
		
		assertTrue(productList.size() > 0);
 	}
	
	@Test
	public void test4Delete() {
        productDao.delete(1);
        
        Product product = productDao.findById(1);
        assertNull(product);
		
	}
}
