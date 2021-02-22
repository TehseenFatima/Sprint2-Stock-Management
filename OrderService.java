package com.cg.ovs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ovs.domain.Orders;
import com.cg.ovs.domain.Stock;
import com.cg.ovs.exception.OrderIdException;
import com.cg.ovs.respository.OrderRepository;
import com.cg.ovs.respository.StockRepository;

@Service
@Transactional
public class OrderService implements OrderServiceImpl{
	@Autowired
	private OrderRepository or;
	
	@Autowired
	private StockRepository sr;
	
	public Orders save(Orders order) {
		try {
			return or.save(order);
		}catch(Exception e) {
			throw new OrderIdException("Order Id : "+order.getOrderId()+"already exists");
		}
	}

	
 public Iterable<Orders> getAllOrders(){
	 return or.findAll();
 }
 public void deleteOrderById(Integer orderId) {
	 Orders order = or.findByOrderId(orderId);
	 if(order == null) {
		 throw new OrderIdException("cannot delete stock with id :"+orderId+"This stock doesnot exist");
	 }
	 or.delete(order);
 }


public List<Stock> getOrderByID(Integer orderId) {
	List<Stock> b = sr.getStockByOrderID(orderId);
	return b;
}


}



