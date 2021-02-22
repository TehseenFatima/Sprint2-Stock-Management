package com.cg.ovs.exception;

public class StockIDExceptionResponse {
	private String stockIdentifier;

	public StockIDExceptionResponse(String stockIdentifier) {
		super();
		this.stockIdentifier = stockIdentifier;
	}

	public String getStockIdentifier() {
		return stockIdentifier;
	}

	public void setStockIdentifier(String stockIdentifier) {
		this.stockIdentifier = stockIdentifier;
	}



}
