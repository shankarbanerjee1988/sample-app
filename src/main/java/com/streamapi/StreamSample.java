package com.streamapi;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;


import com.model.Product;

public class StreamSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Product p1 = new Product();
		p1.setProductCode("P1");
		p1.setProductCost(100.00);
		p1.setProductDesc("Product 1");
		p1.setProductId(1L);
		p1.setProductName("Product 1");
		p1.setProductQuantity(100);
		
		
		Product p2 = new Product();
		p2.setProductCode("P2");
		p2.setProductCost(101.00);
		p2.setProductDesc("Product 2");
		p2.setProductId(2L);
		p2.setProductName("Product 2");
		p2.setProductQuantity(101);
		
		Product p3 = new Product();
		p3.setProductCode("P3");
		p3.setProductCost(103.00);
		p3.setProductDesc("Product 3");
		p3.setProductId(3L);
		p3.setProductName("Product 3");
		p3.setProductQuantity(103);
		
		List<Product> productList = Arrays.asList(p1,p2,p3);


		Stream<Product> streamOfCollection = productList.parallelStream();
		boolean isParallel = streamOfCollection.isParallel();
		boolean bigPrice = streamOfCollection
		  .map(product -> product.getProductCost())
		  .anyMatch(price -> price > 102);
		
		System.out.println(bigPrice);
		System.out.println(isParallel);
		
		String t = "Test";
		String encodedStr =  Base64.getEncoder().encodeToString(t.getBytes());
		System.out.println(encodedStr);
		
		byte[] b = Base64.getDecoder().decode(encodedStr);
		System.out.println("===="+new String(b));
		


	}

}
