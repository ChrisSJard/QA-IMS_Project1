package com.qa.ims.persistence.domain;

import java.sql.Date;
import java.util.Objects;

public class Order {
	
	private Long id;
	private Date orderDate;
	private Long customerID;
	private Date requiredDate;
	private Long productid;
	
	public Order(Long customerid, Date dateNow, Date requiredDate, Long productid) {
		this.customerID = customerid;
		this.orderDate = dateNow;
		this.requiredDate = requiredDate;
		this.productid = productid;
	}
	
	public Order(Long id, Date requiredDate) {
		this.setOrderID(id);
		this.setRequiredDate(requiredDate);
		
	}
	
	public Order(Long orderID, Date orderDate, Long customerID, Date requiredDate, Long productID) {
		this.setOrderID(orderID);
		this.setOrderDate(orderDate);
		this.setCustomerID(customerID);
		this.setRequiredDate(requiredDate);
		this.setProductid(productID);
	}

	public Long getOrderID() {
		return id;
	}

	public void setOrderID(Long orderID) {
		this.id = orderID;
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

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", customerID=" + customerID + ", requiredDate="
				+ requiredDate + ", productid=" + productid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerID, id, orderDate, productid, requiredDate);
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
		return Objects.equals(customerID, other.customerID) && Objects.equals(id, other.id)
				&& Objects.equals(orderDate, other.orderDate) && Objects.equals(productid, other.productid)
				&& Objects.equals(requiredDate, other.requiredDate);
	}
	
	

	
	
	
}
