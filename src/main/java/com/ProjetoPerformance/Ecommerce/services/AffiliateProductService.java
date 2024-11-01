package com.ProjetoPerformance.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoPerformance.Ecommerce.entities.AffiliateProduct;
import com.ProjetoPerformance.Ecommerce.repositories.AffiliateProductRepository;

@Service
public class AffiliateProductService {

	@Autowired
	private AffiliateProductRepository repository;
	
		public AffiliateProduct createProduct(AffiliateProduct product) {
			return repository.save(product);
		}
	
		public List<AffiliateProduct> listAll() {
	        return repository.findAll();
	    }

		public void deleteProduct(Long id) {
	        repository.deleteById(id);
	    }
}
