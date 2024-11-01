package com.ProjetoPerformance.Ecommerce.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoPerformance.Ecommerce.entities.AffiliateProduct;
import com.ProjetoPerformance.Ecommerce.exceptions.AffiliateProductAlreadyExistsException;
import com.ProjetoPerformance.Ecommerce.repositories.AffiliateProductRepository;

@Service
public class AffiliateProductService {

	@Autowired
	private AffiliateProductRepository repository;
	
		public AffiliateProduct createProduct(AffiliateProduct product) {
			
			if (repository.existsByLinkAffiliate(product.getLinkAffiliate())) {
		        throw new AffiliateProductAlreadyExistsException("Affiliate product with the given link already exists.");
		    }
			return repository.save(product);
		}
	
		public List<AffiliateProduct> listAll() {
	        return repository.findAll();
	    }

		public void deleteProduct(Long id) {
	        
	        if (!repository.existsById(id)) {
	            throw new NoSuchElementException("Affiliate product with id " + id + " not found.");
	        }
	        repository.deleteById(id);
	    }
}
