package com.ekart.repository;

import org.springframework.data.repository.CrudRepository;

import com.ekart.entity.Seller;

public interface SellerRepository extends CrudRepository<Seller, String> {
	
}
