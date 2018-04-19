package com.leanne.backend.tests;

import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.leanne.backend.dao.CartDAO;
import com.leanne.backend.model.Cart;

public class CartTestCase {

	static CartDAO cartDao;

	@BeforeClass
	public static void executFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.leanne");
		context.refresh();
		cartDao = (CartDAO) context.getBean("cartImpl");
	}

	// Adding TestCase
	@Ignore
	@Test
	public void addToCartTest() {
		Cart cart = new Cart();
		cart.setPrice(8);
		cart.setProductName("Chair");
		cart.setPrice(300);
		cart.setQuantity(6);
		cart.setStatus("N");
		cart.setUser("Leanne");
		cartDao.saveCart(cart);
		System.out.println("Added to the Cart");
	}

	// Deleting TestCase
	@Ignore
	@Test
	public void removecartitemTest() {
		cartDao.removeCartItem(1);
		System.out.println("The Cart Deleted");
	}

	// Displaying TestCase
	@Ignore
	@Test
	public void getCartItemsTest() {

		List<Cart> list = cartDao.getCartByUsername("Leanne");
		for (Cart cart : list) {
			System.out.println("CartID :" + cart.getCartId());
			System.out.println("Product :" + cart.getProductName());
			System.out.println("Price :" + cart.getPrice());
			System.out.println("Quantity : " + cart.getQuantity());
		}
		System.out.println("Cart item Displayed:");
	}

}