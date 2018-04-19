package com.leanne.backend.dao;

import java.util.List;

import com.leanne.backend.model.Category;
import com.leanne.backend.model.Product;

public interface ProductDAO {

	public void saveProduct(Product product);

	void saveCategory(Category category);

	Product getProductById(int id);

	List<Product> getAllProducts();

	void deleteProductById(int id);

	List<Category> getAllCategories();

}
