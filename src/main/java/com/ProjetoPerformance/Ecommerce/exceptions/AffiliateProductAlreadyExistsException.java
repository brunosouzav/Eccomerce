package com.ProjetoPerformance.Ecommerce.exceptions;

public class AffiliateProductAlreadyExistsException extends RuntimeException{


		private static final long serialVersionUID = 1L;
		
		public AffiliateProductAlreadyExistsException(String message) {
	        super(message);
	    }
}
