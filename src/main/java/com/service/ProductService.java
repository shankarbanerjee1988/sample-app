package com.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.model.Product;

@Validated
public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(Long id);

	Product getProduct(Product product);

	Product saveProduct(Product product) throws Exception;

	void deleteProduct(Product product);

	void deleteAllProduct();


	Product updateProduct(Product product);

}
