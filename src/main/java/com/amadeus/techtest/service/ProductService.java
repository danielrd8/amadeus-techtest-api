package com.amadeus.techtest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amadeus.techtest.model.Product;
import com.amadeus.techtest.repository.ProductRepository;
import com.amadeus.techtest.util.ConstantsUtil;

@Service
public class ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts() throws Exception{	
		try {
			return productRepository.findAll();
		}catch (Exception e) {
			log.error(ConstantsUtil.EXCEPTION_THROWN_AT.concat("getProducts()"));
			log.error(e.getMessage());
			throw e;
		}
		
	}
	
	public Product updateOrCreate(Product product) throws Exception{	
		try {
			return productRepository.updateOrCreate(product);
		}catch (Exception e) {
			log.error(ConstantsUtil.EXCEPTION_THROWN_AT.concat("updateOrInsert(Product product)"));
			log.error(e.getMessage());
			throw e;
		}
		
	}

	public void delete(Long id) throws Exception{
		try {
			productRepository.deleteById(id);
		}catch (Exception e) {
			log.error(ConstantsUtil.EXCEPTION_THROWN_AT.concat("updateOrInsert(Product product)"));
			log.error(e.getMessage());
			throw e;
		}
	}
	
}
