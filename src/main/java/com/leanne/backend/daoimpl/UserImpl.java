package com.leanne.backend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leanne.backend.dao.UserDAO;
import com.leanne.backend.model.Category;
import com.leanne.backend.model.Product;
import com.leanne.backend.model.User;

@Repository("userImpl")
public class UserImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public UserImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	public List<User> getUserByEmail(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where EMAIL = '" + email + "' AND PASSWORD = '" + password + "'");
		List<User> users = query.list();
		return users;
	}
}
