package com.rean.blogrest.controller;

import com.rean.blogrest.model.Article;
import com.rean.blogrest.model.Category;

import com.rean.blogrest.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiblog/categories")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("/list")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategoriess();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category newCategory){
        return categoryService.updateCategory(id,newCategory);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }

}
