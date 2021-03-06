package edu.mum.cs544.carrental.user.service;

import java.util.List;

import edu.mum.cs544.carrental.user.domain.Category;

public interface CategoryService {
	public List<Category> getAll();
	public Category getCategoryById(Long key);
	public void add(Category category);
	public void delete(Long id);

}
