package com.cg.ovs.exception;

public class StockNotFoundExceptionResponse {
	private String stockNotFound;

		public StockNotFoundExceptionResponse(String stockNotFound) {
			super();
			this.stockNotFound = stockNotFound;
		}

		public String getProjectNotFound() {
			return stockNotFound;
		}

		public void setStockNotFound(String stockNotFound) {
			this.stockNotFound = stockNotFound;
		}
		
		

	}



