package com.example.demo.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.SpringbootTestApplicationTests;
import com.example.demo.dao.ProductDaoImp;
import com.example.demo.model.Product;

public class ProductDaoImpTest extends SpringbootTestApplicationTests {

	@Autowired
	ProductDaoImp productDao;
	
	@Test
    public void testSaveAndFindById() {
        Product productToBeSaved = new Product(4, "fifa", 12);
        productDao.add(productToBeSaved);
        
        Product product = productDao.findById(4);

        assertEquals("fifa", product.getName());
    }
	
	
	@Test
	public void updateTest() {
		/* Save */
		Product productToBeSaved = new Product(5, "fifa", 12);
        productDao.add(productToBeSaved);
        
        /* Update */
        productToBeSaved.setName("Dola");
        productToBeSaved.setPrice(22);
        Product productUpdate = productDao.update(productToBeSaved, productToBeSaved.getId());
        
        assertEquals("Dola", productUpdate.getName());
		
	}
	
	@Test
	public void deleteTest() {
		/* Save */
		Product productToBeSaved = new Product(6, "fifa", 12);
        productDao.add(productToBeSaved);
        
        /* Delete */
        productDao.delete(6);
        
        Product product = productDao.findById(6);
        assertNull(product);
		
	}
}
