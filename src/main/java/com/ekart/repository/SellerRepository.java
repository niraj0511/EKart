package com.ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ekart.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, String> {
	
}
