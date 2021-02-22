package com.cg.ovs.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovs.domain.Orders;
import com.cg.ovs.domain.Stock;
import com.cg.ovs.service.MapValidationErrorService;
import com.cg.ovs.service.OrderServiceImpl;
import com.cg.ovs.service.StockServiceImpl;

@RestController
@RequestMapping("/api/stock")
public class StockController {
	
@Autowired
private StockServiceImpl stockService;
@Autowired
private OrderServiceImpl orderService;
@Autowired
private MapValidationErrorService mapValidationErrorService;


@PostMapping("")
public ResponseEntity<?> createNewStock(@Valid @RequestBody Stock stock, BindingResult result) {
	ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
	if (errorMap != null)
		return errorMap;
	Stock sto = stockService.saveOrUpdate(stock);
	return new ResponseEntity<Stock>(sto, HttpStatus.OK);
}
@GetMapping("/{stockIdentifier}")
public ResponseEntity<?> getStockById(@PathVariable String stockIdentifier){
	Stock stock = stockService.findStockByStockIdentifier(stockIdentifier);
	return new ResponseEntity<Stock>(stock, HttpStatus.OK);
}
@GetMapping("/all")
public Iterable<Stock> getAllStocks(){
	return stockService.getAllStocks();
}
@DeleteMapping("/{stockIdentifier}")
public ResponseEntity<?> deleteStock(@PathVariable String stockIdentifier) {
	stockService.deleteStockByIdentifier(stockIdentifier);
	return new ResponseEntity<String>("Stock with id : "+stockIdentifier.toUpperCase()+" deleted successfully.",HttpStatus.OK);
}

@PostMapping("/createorder")
public ResponseEntity<?> createOrder(@Valid @RequestBody Orders orders, BindingResult result) {
	ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
	if (errorMap != null)
		return errorMap;
	Orders ord = orderService.save(orders);
	return new ResponseEntity<Orders>(ord, HttpStatus.OK);
}

@GetMapping("/orderId/{orderId}")
public List<Stock> getDealerByID(@PathVariable("orderId") Integer orderId) {
	List<Stock> dea=orderService.getOrderByID(orderId);
	return dea;
	
}
@GetMapping("/allorders")
public Iterable<Orders> getAllOrders(){
	return orderService.getAllOrders();
}
@DeleteMapping("/deleteorder/{orderId}")
public ResponseEntity<?> deleteById(@PathVariable Integer orderId) {
	orderService.deleteOrderById(orderId);
	return new ResponseEntity<String>("Stock with id : "+orderId+" deleted successfully.",HttpStatus.OK);
}
}








