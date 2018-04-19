package com.leanne.backend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leanne.backend.dao.SupplierDAO;
import com.leanne.backend.model.Category;
import com.leanne.backend.model.Supplier;


@Repository("supplierImpl")
public class SupplierImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveSupplier(Supplier supplier) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(supplier);
	}
}