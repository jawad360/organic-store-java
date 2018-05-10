package com.organicstore.start.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organicstore.start.model.Category;
import com.organicstore.start.model.Product;
import com.organicstore.start.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	
	public List<Product> getProducts() {
        return productRepository.findAll();
    }
	
	public Optional<Product> getProducts(String id) {
	    return productRepository.findById(id);
	}
	
	public List<Product> getProducts(String id, boolean isCategory) {
	    if(isCategory) {
	        return productRepository.findByCategoryId(id);
	    }
        return null;
	}
	
	public void saveProducts(List<Product> product) {
	    productRepository.saveAll(product);
	    categoryService.saveProductToCategoryCollection(product);
	}
	
	public void saveProductsFromCategoryCollection(List<Category> category) {
        for(Category categoryDocument : category) {
            if(categoryDocument != null) {
              List<Product> productList = categoryDocument.getProduct();
              if(productList != null && !productList.isEmpty()) {
                  productRepository.saveAll(productList);
              }
            }
        }
    }
	
	public void deleteProduct(String id) {
	    categoryService.deleteProductFromCategoryCollection(id);
	    productRepository.deleteById(id);
	}
	
	public void deleteProductsByCategoryId(String categoryId) {
	    List<Product> product = productRepository.findByCategoryId(categoryId);
	    for(Product productDocument : product) {
	        productRepository.delete(productDocument);
	    }
	}

}
