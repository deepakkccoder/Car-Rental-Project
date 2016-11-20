package edu.mum.cs544.carrental.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.carrental.user.domain.Category;
import edu.mum.cs544.carrental.user.repository.CategoryRepository;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	
	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public List<Category> getAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long key) {
		return categoryRepository.findOne(key);
	}

	@Override
	public void add(Category category) {
		categoryRepository.save(category);
		
	}

	@Override
	public void delete(Long id) {
		categoryRepository.delete(id);
		
	}

}
