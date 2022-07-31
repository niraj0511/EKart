package com.ekart.service;

import java.util.List;

import com.ekart.dto.ProductDTO;
import com.ekart.exception.EKartException;

public interface SellerProductService extends CustomerProductService {

	Integer addNewProduct(ProductDTO productDTO) throws EKartException;

	ProductDTO modifyProductDetails(ProductDTO productDTO) throws EKartException;

	Integer removeProduct(ProductDTO productDTO) throws EKartException;

	List<ProductDTO> getProductsBySeller(String sellerEmail) throws EKartException;
}
