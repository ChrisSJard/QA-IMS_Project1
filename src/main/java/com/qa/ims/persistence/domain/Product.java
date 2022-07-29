package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Product {
	
	private Long productid;
	private String description;
	private String name;
	private Double value;

	public Product(String name, String description, Double value) {
		this.setName(name);
		this.setDescription(description);
		this.setValue(value);
	}
	
	public Product(Long productid, String name, String description, Double value) {
		this.setProductid(productid);
		this.setName(name);
		this.setDescription(description);
		this.setValue(value);
	}
	
	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", description=" + description + ", name=" + name + ", value= "
				+ value + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, name, productid, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Objects.equals(productid, other.productid) && Objects.equals(value, other.value);
	}

	
	
	
	
	

}
