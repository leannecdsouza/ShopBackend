package com.leanne.backend.daoimpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leanne.backend.dao.ProductDAO;
import com.leanne.backend.model.Category;
import com.leanne.backend.model.Product;

@Repository("productImpl")
public class ProductImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public ProductImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(product);
		session.close();
	}

	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		return products;
	}

	public Product getProductById(int id) {
		Session session = sessionFactory.openSession();
		Product product = (Product) session.get(Product.class, id);
		System.out.println("ID: " + product.getProductId());
		session.close();
		return product;
	}

	public void deleteProductById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Product product = (Product) session.get(Product.class, id);
		session.delete(product);
		tx.commit();
		session.close();
	}

	public List<Category> getAllCategories() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Category");
		List<Category> categories = query.list();
		return categories;
	}

	public void saveCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.save(category);
	}

}
