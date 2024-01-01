package com.rean.blogrest.service;

import com.rean.blogrest.dto.AddCategoryRequest;
import com.rean.blogrest.model.Article;
import com.rean.blogrest.model.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {
    void createCategory(AddCategoryRequest categoryRequest);
    Category updateCategory(int id, Category newCategory);
    List<Category> getAllCategoriess();
    Category getCategoryById(int id);
    void deleteCategory(int id);
}
