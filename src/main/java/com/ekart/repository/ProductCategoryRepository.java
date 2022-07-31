package com.ekart.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ekart.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {

}
