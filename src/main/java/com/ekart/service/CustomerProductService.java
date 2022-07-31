package com.ekart.service;

import java.util.List;

import com.ekart.dto.ProductDTO;
import com.ekart.exception.EKartException;

public interface CustomerProductService {
	List<ProductDTO> getProductsByName(String name) throws EKartException;
	
	List<ProductDTO> getAllProductCategories() throws EKartException;
	
	List<ProductDTO> getAllProductTypes(String name) throws EKartException;

	List<ProductDTO> getAllProductInPriceRange(double min, double max);
}
