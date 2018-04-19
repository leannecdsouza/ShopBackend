package com.leanne.backend.tests;

import org.junit.Test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.leanne.backend.dao.UserDAO;
import com.leanne.backend.model.*;

public class UserTestCase {

	static UserDAO userDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.leanne");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userImpl");
	}

	// Adding TestCase
	//@Ignore
	@Test
	public void saveUserTest() {
		System.out.println("Test to add");
		User user = new User();
		user.setUserName("Henry");
		user.setEmail("henry@gmail.com");
		user.setPassword("henry123");
		user.setAddress("China Town");
		user.setContact("9238730227");
		userDAO.saveUser(user);
		System.out.println("User Inserted");
	}

	// Retrieval TestCase
	
	@Test
	public void getUserByEmailTest() {
		List<User> user = userDAO.getUserByEmail("henry@gmail.com", "henry123");
		for(User s:user){  
			System.out.println("User Name: " + s.getUserName());
			System.out.println("Email: " + s.getEmail());
			}
	}

}
