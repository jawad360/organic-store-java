package com.organicstore.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.organicstore.start.model.Category;
import com.organicstore.start.repository.CategoryRepsitory;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepsitory categoryRepsitory;
	
	@RequestMapping(value="/category", method=RequestMethod.GET)
	public List<Category> getAllPersons() {
		return categoryRepsitory.findAll();
	}
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public void insertCategory(@RequestBody Category person) {
		categoryRepsitory.save(person);
	}
}
