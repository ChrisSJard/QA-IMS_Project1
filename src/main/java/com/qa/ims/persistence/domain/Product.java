package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Product {
	
	private Long productid;
	private String description;
	private String name;

	public Product(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Product(Long productid, String name, String description) {
		this.setProductid(productid);
		this.setName(name);
		this.setDescription(description);
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

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, name, productid);
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
				&& Objects.equals(productid, other.productid);
	}
	
	

}
