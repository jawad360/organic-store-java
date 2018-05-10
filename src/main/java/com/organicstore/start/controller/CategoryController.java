package com.organicstore.start.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organicstore.start.model.Category;
import com.organicstore.start.repository.CategoryRepsitory;
import com.organicstore.start.service.CategoryService;
import com.organicstore.start.service.ProductService;

@RestController
public class CategoryController
{
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/category")
    public List<Category> getAllCategories()
    {
        return categoryService.getCategory();
    }

    @GetMapping("/category/{id}")
    public Optional<Category> getCategoryById(@PathVariable String id)
    {
        return categoryService.getCategory(id);
    }

    @PostMapping("/category")
    public void insertCategory(@RequestBody List<Category> category)
    {
        categoryService.saveCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable String id)
    {
        categoryService.deleteCategory(id);
    }
}
