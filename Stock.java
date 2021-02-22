package com.cg.ovs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


    @Entity
	@Table(name="stock")
	public class Stock {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private int stockId;
	   	private String name;
	    private String type;
	    private String category;
		private double price;
		private int quantity;
		private String stockIdentifier;
		
		
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		@ManyToOne
		@JoinColumn(name="orderId")
		private Orders orders;
		
		public Orders getOrders() {
			return orders;
		}
		public void setOrders(Orders orders) {
			this.orders = orders;
		}
		
		public int getStockId() {
			return stockId;
		}
		public void setStockId(int stockId) {
			this.stockId = stockId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getStockIdentifier() {
			return stockIdentifier;
		}
		public void setStockIdentifier(String stockIdentifier) {
			this.stockIdentifier = stockIdentifier;
		}



		
	
}