package com.repositoty;

import org.springframework.data.repository.CrudRepository;

import com.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
