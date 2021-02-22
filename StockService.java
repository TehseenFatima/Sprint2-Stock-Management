package com.cg.ovs.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ovs.domain.Stock;
import com.cg.ovs.exception.StockIdException;
import com.cg.ovs.respository.StockRepository;

@Service
@Transactional
public class StockService implements StockServiceImpl{
	@Autowired
	private StockRepository stockRepository;
	
	public Stock saveOrUpdate(Stock stock) {
		try {
			stock.setStockIdentifier(stock.getStockIdentifier().toUpperCase());
			return stockRepository.save(stock);
		}catch(Exception e) {
			throw new StockIdException("Stock Id : "+stock.getStockIdentifier().toUpperCase()+"already exists");
		}
	}
 public Stock findStockByStockIdentifier(String stockIdentifier) {
	 Stock stock = stockRepository.findByStockIdentifier(stockIdentifier.toUpperCase());
	 if(stock==null) {
		 throw new StockIdException("Stock Id : "+stockIdentifier.toUpperCase()+"does not exist");
	 }
	 return null;
 }
 public Iterable<Stock> getAllStocks(){
	 return stockRepository.findAll();
 }
 public void deleteStockByIdentifier(String stockIdentifier) {
	 Stock stock = stockRepository.findByStockIdentifier(stockIdentifier.toUpperCase());
	 if(stock == null) {
		 throw new StockIdException("cannot delete stock with id :"+stockIdentifier.toUpperCase()+"This stock doesnot exist");
	 }
	 stockRepository.delete(stock);
 }
}

