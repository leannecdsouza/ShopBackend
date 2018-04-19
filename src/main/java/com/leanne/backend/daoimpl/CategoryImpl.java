package com.leanne.backend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leanne.backend.dao.CategoryDAO;
import com.leanne.backend.model.Category;
import com.leanne.backend.model.Product;

@Repository("categoryImpl")
public class CategoryImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveCategory(Category category) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(category);
	}

	public void deleteCategoryById(int categoryId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Category category = (Category) session.get(Category.class, categoryId);
		session.delete(category);
		tx.commit();
		session.close();
	}

	public Category getCategoryById(int categoryId) {
		Session session = sessionFactory.openSession();
		String hql = "from Category where categoryId = '" + categoryId + "'";
		Query query = session.createQuery(hql);
		List<Category> categories = query.list();
		if (categories != null && !categories.isEmpty()) {
			return categories.get(0);
		}

		return null;
	}

	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Category");
		List<Category> categories = query.list();
		return categories;

	}

}
