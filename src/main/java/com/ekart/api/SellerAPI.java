package com.ekart.api;

import java.util.List;


import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.dto.ProductCategoryDTO;
import com.ekart.dto.ProductDTO;
import com.ekart.exception.EKartException;
import com.ekart.service.CustomerProductService;
import com.ekart.service.SellerProductService;

@CrossOrigin
@RestController
@RequestMapping("/seller-api")
public class SellerAPI{

	@Autowired
	private SellerProductService sellerProductService;
	
	@Autowired
	CustomerProductService customerProductService;
	
	@Autowired
	private Environment environment;

	static Log logger = LogFactory.getLog(SellerAPI.class);

	@PostMapping(value = "/sellers/addProducts")
	public ResponseEntity<ProductDTO> addNewProductToSellerCatalog(@Valid @RequestBody ProductDTO productDTO)
			throws EKartException {
		logger.info("ADDING PRODUCT TO SELLER CATALOG, PRODUCT NAME: " + productDTO.getName() + "\tSELLER NAME = "
				+ productDTO.getSellerEmail());
		Integer newProductId = sellerProductService.addNewProduct(productDTO);
		logger.info("PRODUCT ADDED SUCCESSFULLY TO SELLER CATALOG, PRODUCT NAME: " + productDTO.getName()
				+ "\tSELLER NAME = " + productDTO.getSellerEmail());
		String successMessage = environment.getProperty("SellerProductAPI.PRODUCT_ADDED_SUCCESSFULLY") + newProductId;
		productDTO.setSuccessMessage(successMessage);
		productDTO.setProductId(newProductId);
		return new ResponseEntity<>(productDTO, HttpStatus.OK);

	}

	@PutMapping(value = "/products")
	public ResponseEntity<ProductDTO> modifyProductDetails(@Valid @RequestBody ProductDTO productDTO)
			throws EKartException {

		logger.info("UPDATING PRODUCT DETAILS, PRODUCT ID: " + productDTO.getProductId());
		ProductDTO productReturned = sellerProductService.modifyProductDetails(productDTO);
		logger.info("PRODUCT DETAILS UPDATED SUCCESSFULLY, PRODUCT ID: " + productDTO.getProductId());
		String successMessage = environment.getProperty("SellerProductAPI.PRODUCT_MODIFIED_SUCCESSFULLY")
				+ productReturned.getProductId();
		productReturned.setSuccessMessage(successMessage);
		return new ResponseEntity<>(productReturned, HttpStatus.OK);

	}

	@DeleteMapping(value = "/sellers/removeProducts")
	public ResponseEntity<ProductDTO> removeProduct(@RequestBody ProductDTO productDTO) throws EKartException {
		logger.info("REMOVING PRODUCT DETAILS, PRODUCT ID: " + productDTO.getProductId());
		Integer deleteProduct = sellerProductService.removeProduct(productDTO);
		logger.info("PRODUCT DETAILS REMOVED SUCCESSFULLY, PRODUCT ID: " + productDTO.getProductId());
		String successMessage = environment.getProperty("SellerProductAPI.PRODUCT_DELETED_SUCCESSFULLY")
				+ deleteProduct;
		productDTO.setProductId(deleteProduct);
		productDTO.setSuccessMessage(successMessage);
		return new ResponseEntity<>(productDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/ProductsBySeller")
	public ResponseEntity<List<ProductDTO>> getProductsBySeller(@RequestParam("seller") String sellerEmail) throws EKartException{
		List<ProductDTO> productDTOs = sellerProductService.getProductsBySeller(sellerEmail);
		return new ResponseEntity<>(productDTOs,HttpStatus.OK);
	}
	
	@GetMapping(value = "/productName")
	public ResponseEntity<List<ProductDTO>> getProductsByName(@RequestParam("product") String product) throws EKartException{
		List<ProductDTO> productDTOs = customerProductService.getProductsByName(product);
		return new ResponseEntity<>(productDTOs,HttpStatus.OK);
	}

	@GetMapping(value = "/productCategories")
	public ResponseEntity<List<ProductCategoryDTO>> getAllProductsCategory() throws EKartException{
		List<ProductCategoryDTO> productDTOs = customerProductService.getAllProductCategories();
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
