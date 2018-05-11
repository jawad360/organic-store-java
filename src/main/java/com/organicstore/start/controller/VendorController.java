package com.organicstore.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organicstore.start.model.Vendor;
import com.organicstore.start.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@GetMapping("/vendor")
	public void getVendor() {
	    vendorService.getVendors();
	}
	
	@PostMapping("/vendor")
	public void insertVendor(@RequestBody List<Vendor> vendor) {
	    vendorService.saveVendor(vendor);
	}
	
	@PutMapping("/vendor")
	public void updateVendor(@RequestBody List<Vendor> vendor) {
	    vendorService.saveVendor(vendor);
	}
	
	@DeleteMapping("/vendor/{id}")
	public void deleteVendor(@PathVariable String id) {
	    vendorService.deleteVendor(id);
	}
}
