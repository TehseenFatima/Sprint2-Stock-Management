package com.cg.ovs.service;

import java.util.List;

import com.cg.ovs.domain.Orders;
import com.cg.ovs.domain.Stock;

public interface OrderServiceImpl {

	public Orders save(Orders order);
	
	public Iterable<Orders> getAllOrders();
	
	public void deleteOrderById(Integer orderId);
	
	public List<Stock> getOrderByID(Integer orderId);
	
	


}
