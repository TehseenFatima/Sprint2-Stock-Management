package com.cg.ovs.respository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ovs.domain.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

	Stock findByStockIdentifier(String stockIdentifier);

	@Query("select s from Orders o,Stock s where o.orderId=s.orders and o.orderId=:orderId")	
	List<Stock> getStockByOrderID(Integer orderId);	



}



