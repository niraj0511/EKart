package com.ekart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.dto.ProductDTO;
import com.ekart.entity.Product;
import com.ekart.entity.ProductCategory;
import com.ekart.entity.Seller;
import com.ekart.exception.EKartException;
import com.ekart.repository.ProductCategoryRepository;
import com.ekart.repository.ProductRepository;
import com.ekart.repository.SellerRepository;

@Service(value = "sellerProductService")
public class SellerProductServiceImpl extends CustomerProductServiceImpl implements SellerProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SellerRepository sellerRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public Integer addNewProduct(ProductDTO productDTO) throws EKartException {
		Product product = new Product();
		product.setModel(productDTO.getModel());
		product.setCategory(productDTO.getCategory());
		product.setType(productDTO.getType());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setSellerEmail(productDTO.getSellerEmail());
		product.setQuantity(productDTO.getQuantity());
		Product productFromDB = productRepository.save(product);
		return productFromDB.getProductId();
	}

	@Override
	public ProductDTO modifyProductDetails(ProductDTO productDTO) throws EKartException {
		Optional<Product> optionalProduct = productRepository.findById(productDTO.getProductId());

		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			product.setType(productDTO.getType());
			product.setName(productDTO.getName());
			product.setPrice(productDTO.getPrice());
			product.setQuantity(productDTO.getQuantity());
		}
		return productDTO;
	}

	@Override
	public Integer removeProduct(ProductDTO productDTO) throws EKartException {
		Optional<Seller> optionalSeller = sellerRepository.findById(productDTO.getSellerEmail());
		Seller seller = optionalSeller.orElseThrow(() -> new EKartException("No seller found"));
		List<Product> products = seller.getProduct();
		List<Product> updatedProducts = new ArrayList<>();
		if (products != null && products.isEmpty()) {
			for (Product product : products) {
				if (!productDTO.getProductId().equals(product.getProductId())) {
					updatedProducts.add(product);
				}
			}
		}
		seller.setProduct(updatedProducts);
		return productDTO.getProductId();
	}

	@Override
	public List<ProductDTO> getProductsBySeller(String sellerEmail) throws EKartException {
		Iterable<Product> products = productRepository.findAllProductsBySeller(sellerEmail);
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

}
