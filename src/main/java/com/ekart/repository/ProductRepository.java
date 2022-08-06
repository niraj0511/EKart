package com.ekart.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ekart.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query("SELECT p from Product p WHERE p.name = :name")
	List<Product> findAllByName(String name);
	
	@Query("SELECT p from Product p WHERE p.type = :type")
	List<Product> findAllByType(String type);
	
	@Query("SELECT p from Product p WHERE p.price BETWEEN :min AND :max")
	List<Product> findAllProductInPriceRange(double min, double max);

	@Query("SELECT p from Product p WHERE p.sellerEmail = :sellerEmail")
	List<Product> findAllProductsBySeller(String sellerEmail);

}
