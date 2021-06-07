package com.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.service.ProductService;

@RestController
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public List<Product> allProducts() {
		System.out.println("==========allProducts===============");
		return productService.getAllProducts();
	}

	@PostMapping(value = "/save/product", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public String postBody(@RequestBody Product product) {
		System.out.println("============postBody=============");
		System.out.println(product.toString());
		try {
			productService.saveProduct(product);
			return "Product Saved Successfully";
		} catch (Exception e) {

			return e.getMessage();
		}

	}

	@PostMapping(value = "/update/product", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public String updateProduct(@RequestParam(value = "id", required = true) Long id, @RequestBody Product uproduct) {
		System.out.println(uproduct.toString());
		System.out.println("============updateProduct============="+id);
		try {
			Product p = productService.getProductById(id);
			p.setProductName(uproduct.getProductName());
			p.setProductCost(uproduct.getProductCost());
			p.setProductDesc(uproduct.getProductDesc());

			productService.updateProduct(p);
			return "Product Updated Successfully";
		} catch (Exception e) {
			return e.getMessage();
		}

	}
	
	@DeleteMapping(value = "/delete/product")
	public String deleteProduct(@RequestParam(value = "id", required = true) Long id) {
		System.out.println("============deleteProduct============="+id);
		try {
			Product p = productService.getProductById(id);
			productService.deleteProduct(p);
			return "Product Deleted Successfully";
		} catch (Exception e) {
			return e.getMessage();
		}

	}
	
	@DeleteMapping(value = "/delete/products")
	public String deleteAllProduct() {
		System.out.println("============deleteAllProduct=============");
		try {
			productService.deleteAllProduct();
			return "All Product Deleted Successfully";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@GetMapping("/")
	public String hyeMessage() {
		return "Welcome to Product API";
	}

}
