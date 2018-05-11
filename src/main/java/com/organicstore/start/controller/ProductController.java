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

import com.organicstore.start.model.Product;
import com.organicstore.start.service.ProductService;

@RestController
public class ProductController
{

    @Autowired
    private ProductService productService;
    
    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable String id)
    {
        return productService.getProducts(id);
    }

    @GetMapping("/product/category/{categoryId}")
    public List<Product> getAllProductsByCategoryId(@PathVariable String categoryId)
    {
        return productService.getProducts(categoryId,true);
    }
    
    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }

    @PostMapping("/product")
    public void insertProduct(@RequestBody List<Product> product)
    {
        productService.saveProducts(product);
    }
    
    @PutMapping("/product")
    public void updateProduct(@RequestBody List<Product> product)
    {
        productService.saveProducts(product);
    }
    
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable String id)
    {
        productService.deleteProduct(id);
    }
    
}
