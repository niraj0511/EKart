package com.ekart.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.dto.ProductDTO;
import com.ekart.exception.EKartException;
import com.ekart.service.CustomerProductService;

@RestController
@RequestMapping("/customer-api")
public class CustomerAPI {
	
	@Autowired
	CustomerProductService customerProductService;

	
@GetMapping(value = "/productName/{product}")
public ResponseEntity<List<ProductDTO>> getProductsByName(@PathVariable("product") String product) throws EKartException{
	List<ProductDTO> productDTOs = customerProductService.getProductsByName(product);
	return new ResponseEntity<>(productDTOs,HttpStatus.OK);
}

@GetMapping(value = "/productCategories")
public ResponseEntity<List<ProductDTO>> getAllProductsCategory() throws EKartException{
	List<ProductDTO> productDTOs = customerProductService.getAllProductCategories();
	return new ResponseEntity<>(productDTOs,HttpStatus.OK);
}

@GetMapping(value = "/productType")
public ResponseEntity<List<ProductDTO>> getAllProductsType(@RequestParam("type") String type) throws EKartException{
	List<ProductDTO> productDTOs = customerProductService.getAllProductTypes(type);
	return new ResponseEntity<>(productDTOs,HttpStatus.OK);
}


@GetMapping(value = "/productInPriceRange")
public ResponseEntity<List<ProductDTO>> getAllProductInPriceRange(@RequestParam("min") double min,@RequestParam("max") double max) throws EKartException{
	List<ProductDTO> productDTOs = customerProductService.getAllProductInPriceRange(min,max);
	return new ResponseEntity<>(productDTOs,HttpStatus.OK);
}

}
