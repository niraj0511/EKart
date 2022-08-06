package com.ekart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.dto.ProductCategoryDTO;
import com.ekart.dto.ProductDTO;
import com.ekart.entity.Product;
import com.ekart.entity.ProductCategory;
import com.ekart.exception.EKartException;
import com.ekart.repository.ProductCategoryRepository;
import com.ekart.repository.ProductRepository;

@Service
public class CustomerProductServiceImpl implements CustomerProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Override
	public List<ProductDTO> getProductsByName(String name) throws EKartException {
		Iterable<Product> products = productRepository.findAllByName(name);
		List<ProductDTO> productDTOs = new ArrayList<>();
		products.forEach(product -> {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setModel(product.getModel());
			productDTO.setCategory(product.getCategory());
			productDTO.setName(product.getName());
			productDTO.setSellerEmailId(product.getSellerEmail());
			productDTO.setPrice(product.getPrice());
			productDTO.setProductId(product.getProductId());
			productDTO.setQuantity(product.getQuantity());

			productDTOs.add(productDTO);
		});
		return productDTOs;
	}
	
	@Override
	public List<ProductCategoryDTO> getAllProductCategories() throws EKartException {
		Iterable<ProductCategory> products = productCategoryRepository.findAll();
		List<ProductCategoryDTO> productDTOs = new ArrayList<>();
		products.forEach(product -> {
			ProductCategoryDTO productDTO = new ProductCategoryDTO();
			productDTO.setCategory(product.getCategory());
			productDTOs.add(productDTO);
		});
		return productDTOs;
	}
	
	
	@Override
	public List<ProductDTO> getAllProductTypes(String type) throws EKartException {
				Iterable<Product> products = productRepository.findAllByType(type);
				List<ProductDTO> productDTOs = new ArrayList<>();
				products.forEach(product -> {
					ProductDTO productDTO = new ProductDTO();
					productDTO.setModel(product.getModel());
					productDTO.setCategory(product.getCategory());
					productDTO.setName(product.getName());
					productDTO.setType(product.getType());
					productDTO.setPrice(product.getPrice());
					productDTO.setSellerEmailId(product.getSellerEmail());
					productDTO.setProductId(product.getProductId());
					productDTO.setQuantity(product.getQuantity());

					productDTOs.add(productDTO);
				});
				return productDTOs;
	}
	
	@Override
	public List<ProductDTO> getAllProductInPriceRange(double min, double max){
		Iterable<Product> products = productRepository.findAllProductInPriceRange(min,max);
		List<ProductDTO> productDTOs = new ArrayList<>();
		products.forEach(product -> {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setModel(product.getModel());
			productDTO.setType(product.getType());
			productDTO.setCategory(product.getCategory());
			productDTO.setName(product.getName());
			productDTO.setSellerEmailId(product.getSellerEmail());
			productDTO.setPrice(product.getPrice());
			productDTO.setProductId(product.getProductId());
			productDTO.setQuantity(product.getQuantity());

			productDTOs.add(productDTO);
		});
		return productDTOs;
	}
}
