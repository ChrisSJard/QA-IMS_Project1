package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long customerID = 1L, productID = 1L;
		final Date orderDate = Date.valueOf(LocalDate.now());
		final String deliveryDate = "2022-09-20";
		final Date requiredDate = Date.valueOf("2022-09-20");
				
		final Order created = new Order(customerID, orderDate, requiredDate, productID);

		Mockito.when(utils.getLong()).thenReturn(customerID, productID);
		Mockito.when(utils.getDate()).thenReturn(requiredDate);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getDate();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		final Date dateNow = Date.valueOf(LocalDate.now());
		final Date requiredDate = Date.valueOf("2022-09-20");
		orders.add(new Order(1L, dateNow, 1l, requiredDate, 1l ));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		final Date requiredDate = Date.valueOf("2022-09-20");
		Order updated = new Order(1L, requiredDate);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getDate()).thenReturn(updated.getRequiredDate());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getDate();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}