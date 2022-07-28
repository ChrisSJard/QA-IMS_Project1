package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ProductTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Product.class).verify();
	}
	
	@Test 
	public void constructorTest() {
		Product object = new Product(1L, "item name", "item description", 10.0);
		assertTrue( object instanceof Product);
	}

}
