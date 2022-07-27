package com.qa.ims.persistence.domain;

import java.sql.Date;
import java.util.Objects;

public class Order {
	
	private Long id;
	private Date orderDate;
	private Long customerID;
	private Date requiredDate;
	
	public Order(Long customerid, Date dateNow, Date requiredDate) {
		this.customerID = customerid;
		this.requiredDate = requiredDate;
	}
	
	public Order(Long id, Date requiredDate) {
		this.setOrderID(id);
		this.setRequiredDate(requiredDate);
		
	}
	
	public Order(Long orderID, Date orderDate, Long customerID, Date requiredDate) {
		this.setOrderID(id);
		this.setOrderDate(orderDate);
		this.setCustomerID(customerID);
		this.setRequiredDate(requiredDate);
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", customerID=" + customerID + ", requiredDate="
				+ requiredDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerID, id, orderDate, requiredDate);
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
				&& Objects.equals(orderDate, other.orderDate) && Objects.equals(requiredDate, other.requiredDate);
	}

	
	
	
}
