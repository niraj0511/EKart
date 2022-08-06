package com.ekart.repository;


import org.springframework.data.repository.CrudRepository;

import com.ekart.entity.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, String> {

}
