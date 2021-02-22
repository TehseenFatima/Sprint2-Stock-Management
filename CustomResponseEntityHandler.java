package com.cg.ovs.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@RestController
public class CustomResponseEntityHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<Object> handleStockIdException(StockIdException ex, WebRequest request){
		StockIDExceptionResponse stockIdExceptionResponse =  new StockIDExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(stockIdExceptionResponse,HttpStatus.BAD_REQUEST);
	}	
	
	@ExceptionHandler
	public ResponseEntity<Object> handleStockNotFoundException(StockNotFoundException ex, WebRequest request){
		StockNotFoundExceptionResponse stockNotFoundExceptionResponse =  new StockNotFoundExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(stockNotFoundExceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
}
