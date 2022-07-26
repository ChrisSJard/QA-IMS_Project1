package com.qa.ims.persistence.domain;

import java.sql.Date;
import java.util.Objects;

public class Order {
	
	private Long orderID;
	private Date orderDate;
	private Long customerID;
	private Long productID;
	
	public Order(Date dateNow, Long customerid, Long productid) {
		this.customerID = customerid;
		this.productID = productid;
	}
	
	public Order(Long id, Long productid) {
		this.setOrderID(id);
		this.setProductID(productid);
		
	}
	
	public Order(Long id, Date orderDate, Long customerid,Long productid) {
		this.setOrderID(id);
		this.setProductID(productid);
		this.setOrderDate(orderDate);
		this.setCustomerID(customerid);
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderDate=" + orderDate + ", customerID=" + customerID + ", productID="
				+ productID + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerID, orderDate, orderID, productID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerID, other.customerID) && Objects.equals(orderDate, other.orderDate)
				&& Objects.equals(orderID, other.orderID) && Objects.equals(productID, other.productID);
	}
	
	
}
