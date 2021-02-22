package com.cg.ovs;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ovs.domain.Stock;
import com.cg.ovs.respository.StockRepository;
import com.cg.ovs.service.StockService;

@SpringBootTest
public class StockApplicationTests {
    
	@Autowired
	private StockService stockService;
	
	@MockBean
	private StockRepository stockRepository;

	@Test
	public void saveOrUpdate() {
		Stock stock = new Stock();
		stock.setStockId(1);
		stock.setName("Brinjal");
		stock.setType("Vegetable");
		stock.setCategory("Dry");
		stock.setPrice(20.00);
		stock.setQuantity(5);
		
		Mockito.when(stockRepository.save(stock)).thenReturn(stock);
		assertThat(stockService.saveOrUpdate(stock)).isEqualTo(stock);
	}
}



