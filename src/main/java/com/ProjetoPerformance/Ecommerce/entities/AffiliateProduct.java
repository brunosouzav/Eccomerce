package com.ProjetoPerformance.Ecommerce.entities;

import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "affiliate_product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of ="id")
public class AffiliateProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	private String name;
	private String description;
	@Column(unique = true)
	private String linkAffiliate;
	private String imgUrl;
	
	 @OneToMany(mappedBy = "category") 
	    private Map<Long,AffiliateProduct> affiliateProducts; 
}
	