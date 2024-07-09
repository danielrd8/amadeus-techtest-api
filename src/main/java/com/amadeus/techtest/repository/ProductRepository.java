package com.amadeus.techtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amadeus.techtest.model.Product;

import jakarta.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
	@Transactional
	default Product updateOrCreate(Product prod) {
		return save(prod);
	}
	
	
	
	
}
