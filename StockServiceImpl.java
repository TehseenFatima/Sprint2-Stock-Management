package com.cg.ovs.service;

import com.cg.ovs.domain.Stock;

public interface StockServiceImpl {

	
	public Stock saveOrUpdate(Stock stock);
	
	public Stock findStockByStockIdentifier(String stockIdentifier);
	
	public Iterable<Stock> getAllStocks();
	
	public void deleteStockByIdentifier(String stockIdentifier);
}
