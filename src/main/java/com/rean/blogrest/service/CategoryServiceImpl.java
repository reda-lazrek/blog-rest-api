package com.rean.blogrest.service;

import com.rean.blogrest.exception.NotFoundException;
import com.rean.blogrest.model.Article;
import com.rean.blogrest.model.Category;
import com.rean.blogrest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(int id, Category newCategory) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        existingCategory.get().setName(newCategory.getName());
        existingCategory.get().setDescription(newCategory.getDescription());
        return categoryRepository.save(existingCategory.get());
    }

    @Override
    public List<Category> getAllCategoriess() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElseThrow(()-> new NotFoundException("Category not found with id: "+ id));
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
