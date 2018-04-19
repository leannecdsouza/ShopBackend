package com.leanne.backend.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leanne.backend.dao.OrderDAO;
import com.leanne.backend.model.Order;


@Repository("orderImpl")
public class OrderImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);

	}

	public Order list(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CustomerOrder where user = ?");
		query.setString(0, username);
		return (Order) query.uniqueResult();

	}

	public void removeAllOrderItems(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CustomerOrder where user=?");
		query.setString(0, username);
		Order order = (Order) query.uniqueResult();
		session.delete(order);

	}

}
