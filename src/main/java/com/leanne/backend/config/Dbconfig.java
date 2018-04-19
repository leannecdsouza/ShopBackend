package com.leanne.backend.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.leanne.backend.daoimpl.*;
import com.leanne.backend.daoimpl.UserImpl;
import com.leanne.backend.model.*;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class Dbconfig {

	@Autowired
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		System.out.println("Starting of the method getH2DataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl(" jdbc:h2:tcp://localhost/~/ecommercedb");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		System.out.println("Data Source Creation");
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		System.out.println("---Hibernate Properties----");
		Properties prop = new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		//prop.put("hibernate.show_sql", "true"); // optional
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		System.out.println("---Hibernate Properties Created");

		System.out.println("---Local SessionFactory Builder Object Creation---");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		sessionBuilder.addProperties(prop);
		System.out.println("---Factory Builder Object Created---");
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(User.class);
		
		System.out.println("Session Factory Object Creation");
		SessionFactory sessionFactory = sessionBuilder.buildSessionFactory();
		System.out.println("Session Factory Object Created");
		return sessionFactory;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("--Transaction manager Object Creation--");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("--Transaction manager Object Created--");
		return transactionManager;
	}

//	@Autowired
//	@Bean(name = "categoryImpl")
//	public CategoryImpl getCategoryImpl(SessionFactory sessionFactory) {
//		System.out.println("-- CategoryImpl Object Creation--");
//		return new CategoryImpl(sessionFactory);
//	}

//	@Autowired
//	@Bean(name = "productImpl")
//	public ProductImpl getProductImpl(SessionFactory sessionFactory) {
//		System.out.println("-- ProductImpl Object Creation--");
//		return new ProductImpl(sessionFactory);
//	}

//	@Autowired
//	@Bean(name = "supplierImpl")
//	public SupplierImpl getSupplierImpl(SessionFactory sessionFactory) {
//		System.out.println("-- SupplierImpl Object Creation--");
//		return new SupplierImpl(sessionFactory);
//	}
//
//	@Autowired
//	@Bean(name = "cartImpl")
//	public CartImpl getCartImpl(SessionFactory sessionFactory) {
//		System.out.println("-- CartImpl Object Creation--");
//		return new CartImpl(sessionFactory);
//	}
//
//	@Autowired
//	@Bean(name = "userImpl")
//	public UserImpl getUserImpl(SessionFactory sessionFactory) {
//		System.out.println("-- UserImpl Object Creation--");
//		return new UserImpl(sessionFactory);
//	}
}