package com.amadeus.techtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amadeus.techtest.model.Product;
import com.amadeus.techtest.service.ProductService;
import com.amadeus.techtest.util.ConstantsUtil;

@RestController()
@RequestMapping("/api/products")
public class ProductController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@GetMapping()
	public ResponseEntity<Object> getProducts(){
		try {			
			log.info("Getting products list ");
			return ResponseEntity.ok(productService.getProducts());
			
		}catch (Exception e) {
			log.error(
					ConstantsUtil.INTERNAL_SERVER_ERROR_STR.concat(e.getMessage()));
			return ResponseEntity.internalServerError().body(
					ConstantsUtil.INTERNAL_SERVER_ERROR_STR.concat(e.getMessage()));
		}		
	}
	
	@PostMapping()
	public ResponseEntity<Object> createProduct(@RequestBody Product product){
		try {			
			log.info("Creating product: ".concat(product.toString()));
			return ResponseEntity.ok(productService.updateOrCreate(product));
			
		}catch (Exception e) {
			log.error(
					ConstantsUtil.INTERNAL_SERVER_ERROR_STR.concat(e.getMessage()));
			return ResponseEntity.internalServerError().body(
					ConstantsUtil.INTERNAL_SERVER_ERROR_STR.concat(e.getMessage()));
		}		
	}
	
	@PutMapping()
	public ResponseEntity<Object> updateProduct(@RequestBody Product product){
		try {			
			log.info("Updating product: ".concat(product.toString()));
			return ResponseEntity.ok(productService.updateOrCreate(product));
			
		}catch (Exception e) {
			log.error(
					ConstantsUtil.INTERNAL_SERVER_ERROR_STR.concat(e.getMessage()));
			return ResponseEntity.internalServerError().body(
					ConstantsUtil.INTERNAL_SERVER_ERROR_STR.concat(e.getMessage()));
		}		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable(value="id") Long id){
		try {			
			log.info("Deleting product with id: ".concat(id.toString()));
			productService.delete(id);
			return ResponseEntity.ok("");
			
		}catch (Exception e) {
			log.error(
					ConstantsUtil.INTERNAL_SERVER_ERROR_STR.concat(e.getMessage()));
			return ResponseEntity.internalServerError().body(
					ConstantsUtil.INTERNAL_SERVER_ERROR_STR.concat(e.getMessage()));
		}		
	}
	
}