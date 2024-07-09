package com.amadeus.techtest.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@SequenceGenerator(name = "product_seq", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@Column(name = "id")
	private Long id;	
	@Column(name = "name")
	private String name;
	@Column(name = "brand")
	private String brand;
	@Column(name = "description")
	private String description;
	@Column(name = "manufacturing_date")
	private Date manufacturingDate;
	@Column(name = "price")
	private Double price;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "discount")
	private Boolean discount;
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", description=" + description
				+ ", manufacturingDate=" + manufacturingDate + ", price=" + price + ", quantity=" + quantity
				+ ", discount=" + discount + "]";
	}
	
	
}
