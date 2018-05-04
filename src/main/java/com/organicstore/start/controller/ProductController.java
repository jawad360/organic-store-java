package com.organicstore.start.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organicstore.start.model.Category;
import com.organicstore.start.model.Product;
import com.organicstore.start.repository.ProductRepository;

@RestController
public class ProductController
{

    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping("/Product/{id}")
    public Optional<Product> getProduct(@PathVariable String id)
    {
        return productRepository.findById(id);
    }

    @GetMapping("/product/{categoryId}")
    public Optional<Product> getProductById(@PathVariable String categoryId)
    {
        return productRepository.findById(categoryId);
    }

    @PostMapping("/product")
    public void insertCategory(@RequestBody List<Product> product)
    {
        productRepository.saveAll(product);
    }

}
