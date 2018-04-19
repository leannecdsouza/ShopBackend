package com.leanne.backend.tests;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.leanne.backend.dao.SupplierDAO;
import com.leanne.backend.model.Supplier;

public class SupplierTestCase {

	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.leanne");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierImpl");
	
	}

	// Adding TestCase
	@Ignore
	@Test
	public void saveSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setSupplierName("Supplier Dude");
		supplier.setSupplierContact(72329385);
		supplierDAO.saveSupplier(supplier);
		System.out.println("Added new Supplier");
	}

}