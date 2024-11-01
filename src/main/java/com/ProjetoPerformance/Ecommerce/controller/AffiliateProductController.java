package com.ProjetoPerformance.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoPerformance.Ecommerce.entities.AffiliateProduct;
import com.ProjetoPerformance.Ecommerce.services.AffiliateProductService;

@RestController
@RequestMapping("/affiliateProduct")
public class AffiliateProductController {

	@Autowired
	private AffiliateProductService service;

	@PostMapping
	public ResponseEntity<AffiliateProduct>createAffiliateProduct(@RequestBody AffiliateProduct product){
			AffiliateProduct newProduct = service.createProduct(product);
			return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<AffiliateProduct>> getAllProducts(){
		List<AffiliateProduct> products = service.listAll();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		service.deleteProduct(id);
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
	}
	
	
}
