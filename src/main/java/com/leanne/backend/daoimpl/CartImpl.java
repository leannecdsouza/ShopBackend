package com.leanne.backend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leanne.backend.dao.CartDAO;
import com.leanne.backend.model.Cart;

@Repository("cartImpl")
public class CartImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CartImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveCart(Cart cart) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cart);
	}

	public Cart getCartItem(int i) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where user=?");
		List<Cart> cartitems = query.list();
		return cartitems.get(i);
	}

	public List<Cart> getCartByUsername(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where user=?");
		query.setString(0, username);
		return query.list();
	}

	public void removeCartItem(int cartitemid) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Cart cartitem = (Cart) session.get(Cart.class, cartitemid);
		System.out.println("ID: " + cartitem.getCartId());
		session.delete(cartitem);
		tx.commit();
		session.close();
	}

	public void removeAllCartItem(String username) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Cart where user=?");
		query.setString(0, username);
		List<Cart> cartitems = query.list();
		for (Cart cartitem : cartitems)
			session.delete(cartitem);
		tx.commit();
		session.close();
	}

}
