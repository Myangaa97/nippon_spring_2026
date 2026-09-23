package com.icode.service;

import com.icode.entity.Category;
import com.icode.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;


	CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Category createCategory(String name) {
		if (categoryRepository.existsByName(name)) {
			throw new IllegalArgumentException("Category already exists");
		}
		Category category = new Category();
		category.setName(name);
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(Long id, String newName) {
	    Category category = categoryRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Category not found"));

	    if (!category.getName().equals(newName) && categoryRepository.existsByName(newName)) {
	        throw new IllegalArgumentException("Category name already exists");
	    }

	    category.setName(newName);
	    return categoryRepository.save(category);
	}

	public Category getCategoryById(Long id) {
	    return categoryRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Category not found"));
	}
	
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
