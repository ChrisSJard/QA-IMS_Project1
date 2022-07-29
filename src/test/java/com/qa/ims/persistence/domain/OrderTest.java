package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Order.class).verify();
	}
	
	@Test 
	public void constructorTest() {
		final Date nowDate= Date.valueOf(LocalDate.now());
		final Date required = Date.valueOf("2022-07-29");
		Order object = new Order(1L, nowDate, 1L, required, 1L);
		assertTrue( object instanceof Order);
	}

}
