package com.leanne.backend.tests;

import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.leanne.backend.dao.CategoryDAO;
import com.leanne.backend.model.Category;

public class CategoryTestCase {

	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.leanne");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryImpl");

	}

	// Insertion TestCase
	@Ignore
	@Test
	public void saveCategoryTest() {
		Category category = new Category();
		category.setCategoryName("TestCategory");
		category.setDescription("Category Description");
		categoryDAO.saveCategory(category);
		System.out.println("Category Inserted");
	}

	// Retrieval TestCase
	@Ignore
	@Test
	public void getCategoryByIdTest() {
		Category category = categoryDAO.getCategoryById(2);
		System.out.println("Category Name:" + category.getCategoryName());
	}

	// Deletion TestCase
	@Ignore
	@Test
	public void deleteCategoryByIdTest() {
		categoryDAO.deleteCategoryById(1);
		System.out.println("The Category Deleted");
	}

	// Retrieving the Data
	@Ignore
	@Test
	public void listCategoryTest() {
		List<Category> list = categoryDAO.listCategory();
		for (Category category : list) {
			System.out.println(category.getCategoryName());
		}
	}
}
