package com.nimap.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nimap.entity.Category;
import com.nimap.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public Page<Category> getAllCategories(int page) {
		return categoryRepository.findAll(PageRequest.of(page - 1, 10));
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public ResponseEntity<Category> getCategoryById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}

	public ResponseEntity<Category> updateCategory(Long id, Category category) {
		return categoryRepository.findById(id).map(existingCategory -> {
			category.setId(id);
			return ResponseEntity.ok(categoryRepository.save(category));
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Category> deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
