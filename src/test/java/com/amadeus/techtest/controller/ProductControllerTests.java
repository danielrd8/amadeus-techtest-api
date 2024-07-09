package com.amadeus.techtest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.amadeus.techtest.model.Product;
import com.amadeus.techtest.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ProductControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void getProductsListTest() throws Exception{
		
		List<Product> productsList = new ArrayList<>();
		productsList.add(Product.builder().name("Name One").brand("Brand One").description("Desc One")
				.manufacturingDate(new Date()).quantity(1).price(123.0).discount(false).build());
		productsList.add(Product.builder().name("Name Two").brand("Brand Two").description("Desc Two")
				.manufacturingDate(new Date()).quantity(2).price(123.0).discount(true).build());
		
		given(productService.getProducts()).willReturn(productsList);
		
		ResultActions resp = mockMvc.perform(get("/api/products"));
		
		resp.andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.size()",is(productsList.size())));		
		
	}
	
	@Test
	public void returnCreatedProductTest() throws Exception{
		
		Product product = Product.builder().name("Name Created").brand("Brand Created").description("Desc Created")
				.manufacturingDate(new Date()).quantity(1).price(123.0).discount(false).build();
		
		given(productService.updateOrCreate(any(Product.class))).willAnswer((inv)->inv.getArgument(0));
		
		ResultActions resp = mockMvc.perform(post("/api/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(product)));
		
		resp.andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is(product.getName())))
		.andExpect(jsonPath("$.brand", is(product.getBrand())))
		.andExpect(jsonPath("$.description", is(product.getDescription())))
		.andExpect(jsonPath("$.manufacturingDate", is(product.getManufacturingDate().toInstant().toString().replace("Z", "+00:00"))))
		.andExpect(jsonPath("$.price", is(product.getPrice())))
		.andExpect(jsonPath("$.quantity", is(product.getQuantity())))
		.andExpect(jsonPath("$.discount", is(product.getDiscount())));	
		
	}
	
	@Test
	public void returnUpdatedProductTest() throws Exception{
		
		Product product = Product.builder().name("Name Updated").brand("Brand Updated").description("Desc Updated")
				.manufacturingDate(new Date()).price(123.0).quantity(1).discount(false).build();
		
		given(productService.updateOrCreate(any(Product.class))).willAnswer((inv)->inv.getArgument(0));
		
		ResultActions resp = mockMvc.perform(put("/api/products")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(product)));
		
		resp.andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is(product.getName())))
		.andExpect(jsonPath("$.brand", is(product.getBrand())))
		.andExpect(jsonPath("$.description", is(product.getDescription())))
		.andExpect(jsonPath("$.manufacturingDate", is(product.getManufacturingDate().toInstant().toString().replace("Z", "+00:00"))))
		.andExpect(jsonPath("$.price", is(product.getPrice())))
		.andExpect(jsonPath("$.quantity", is(product.getQuantity())))
		.andExpect(jsonPath("$.discount", is(product.getDiscount())));	
		
	}
	
	@Test
	public void returnOkStatusProductDeleteTest() throws Exception{
		
		Long prodId = 1L;		
		ResultActions resp = mockMvc.perform(delete("/api/products/{id}", prodId));
		
		resp.andDo(print()).andExpect(status().isOk());
		
	}
	
	

	

	
}
