package com.leanne.backend.tests;

import org.junit.Test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.leanne.backend.dao.ProductDAO;
import com.leanne.backend.model.*;

public class ProductTestCase {

	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.leanne");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productImpl");		
	}

	// Adding TestCase
	//@Ignore
	@Test
	public void saveProductTest() {
		System.out.println("Test to add");
 		Product product = new Product();
		product.setProductName("Product");
		product.setPrice(500);
		product.setProductDescription("An item being sold");
		product.setCategory("ProductCategory");
		productDAO.saveProduct(product);
		System.out.println("Product Inserted");
	}

	// Retrieval TestCase
	//@Ignore
	@Test
	public void getProductByIdTest() {
		Product product = productDAO.getProductById(7);
		System.out.println("Product Name:" + product.getProductName());
	}

	// Deletion TestCase
	//@Ignore
	@Test
	public void deleteProductTest() {
		productDAO.deleteProductById(5);
		System.out.println("The Product Deleted");
	}

	// Retrieving the Data
	//@Ignore
	@Test
	public void getAllProductsTest() {
		List<Product> list = productDAO.getAllProducts();
		for (Product product : list) {
			System.out.print(product.getProductId() + ": ");
			System.out.println(product.getProductName());
		}
		System.out.println("Product Displayed");
	}

}
