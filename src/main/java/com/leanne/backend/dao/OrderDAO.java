package com.leanne.backend.dao;

import com.leanne.backend.model.Order;

public interface OrderDAO {

	public Order list(String username);

	public void saveOrder(Order order);

	void removeAllOrderItems(String username);

}
