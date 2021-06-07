package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Product;
import com.repositoty.ProductRepository;

@Service
@org.springframework.transaction.annotation.Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product getProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product saveProduct(Product product) throws Exception {
		System.out.println("=======saveProduct=======");
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.delete(product);
	}

	@Override
	public void deleteAllProduct() {
		productRepository.deleteAll();
		
	}

}
