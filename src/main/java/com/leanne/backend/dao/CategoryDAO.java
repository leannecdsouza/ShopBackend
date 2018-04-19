package com.leanne.backend.dao;

import java.util.List;

import com.leanne.backend.model.Category;

public interface CategoryDAO {

	public void saveCategory(Category category);

	public void deleteCategoryById(int categoryId);

	public Category getCategoryById(int categoryId);

	public List<Category> listCategory();
}
