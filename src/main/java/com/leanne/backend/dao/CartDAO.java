package com.leanne.backend.dao;

import java.util.List;

import com.leanne.backend.model.Cart;

public interface CartDAO {

	public void saveCart(Cart cart);

	public Cart getCartItem(int i);

	public List<Cart> getCartByUsername(String username);

	void removeCartItem(int cartitemid);

	void removeAllCartItem(String username);
}
