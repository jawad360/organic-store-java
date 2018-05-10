package com.organicstore.start.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organicstore.start.model.Category;
import com.organicstore.start.model.Product;
import com.organicstore.start.repository.CategoryRepsitory;
import com.organicstore.start.repository.ProductRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepsitory categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	public List<Category> getCategory() {
	    return categoryRepository.findAll();
	}
	
	public Optional<Category> getCategory(String id) {
	    return categoryRepository.findById(id);
	}
	
	public void saveCategory(List<Category> category) {
	    categoryRepository.saveAll(category);
	    productService.saveProductsFromCategoryCollection(category);;
	}
	
	public void deleteCategory(String id) {
	    Optional<Category> category = categoryRepository.findById(id);
	    if(category.isPresent()) {
	        List<Product> product = category.get().getProduct();
	        for(Product productDocument : product) {
	            productRepository.delete(productDocument);
	        }
	        categoryRepository.deleteById(id);
	    }
	}
	
	public void saveProductToCategoryCollection(List<Product> product) {
	    if(product == null || product.isEmpty()) {
	        return;
	    }
	    for(Product productDocument : product) {
	        Category categoryDocument = this.getCategoryDocumentByProductDocument(productDocument);
	        if(categoryDocument == null) {
	                continue;
	         }
	         List<Product> categoryProductList = categoryDocument.getProduct();
	         if(categoryProductList == null) {
	             categoryProductList = new ArrayList<Product>();
	         }
	         if(!this.checkIfProductPresentInCategory(categoryProductList, productDocument.getId())) {
	             categoryProductList.add(productDocument);
	             categoryDocument.setProduct(categoryProductList);
	             categoryRepository.save(categoryDocument);
	         }
	    }      
	}
	
	public void deleteProductFromCategoryCollection(String productId) {
	    if(productId == null || productId.isEmpty()) {
            return;
        }
	    Optional<Product> productDocumentFound = productRepository.findById(productId);
	    if(productDocumentFound.isPresent()) {
	        Product productDocument = productDocumentFound.get();
	        Category categoryDocument = this.getCategoryDocumentByProductDocument(productDocument);
	        if(categoryDocument!= null) {
	            List<Product> categoryProductList = categoryDocument.getProduct();
	            if(categoryProductList != null) {
	                for(Product product : categoryProductList) {
	                    if(product.getId().equals(productDocument.getId())) {
	                        categoryProductList.remove(product);
	                        break;
	                    }
	                }
	                categoryDocument.setProduct(categoryProductList);
	                categoryRepository.save(categoryDocument);
	            }
	        }
	    }
	}
	
	private Category getCategoryDocumentByProductDocument(Product productDocument) {
	    String categoryId = productDocument.getCategoryId();
        if(categoryId != null && !categoryId.isEmpty()) {
            Optional<Category> categoryDocumentFound = categoryRepository.findById(categoryId);
            if(categoryDocumentFound.isPresent()) {
                Category categoryDocument = categoryDocumentFound.get();
                return categoryDocument;
            }
        }
        return null;
	}
	
	private boolean checkIfProductPresentInCategory(List<Product> products, String productId) {
	    for(Product product : products) {
	        if(product.getId().equals(productId)) {
	            return true;
	        }
	    }
	    return false;
	}
}