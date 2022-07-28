package com.qa.ims.persistence.dao;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	
	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Ignore
	@Test
	public void testCreate() {
		final Date nowDate= Date.valueOf(LocalDate.now());
		final Date required = Date.valueOf("2022-07-29");
		final Order created = new Order(5L, nowDate, 1L, required, 1L);
		assertEquals(created, DAO.create(created));
	}
	
	
	@Test
	public void testReadAll() {
		final Date nowDate= Date.valueOf(LocalDate.now());
		final Date required = Date.valueOf("2022-07-29");
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, nowDate, 1L, required, 1L));
		expected.add(new Order(2L, nowDate, 1L, required, 1L));
		expected.add(new Order(3L, nowDate, 1L, required, 1L));
		assertEquals(expected, DAO.readAll());
	}
	
	@Ignore
	@Test
	public void testReadLatest() {
		final Date nowDate= Date.valueOf(LocalDate.now());
		final Date required = Date.valueOf("2022-07-29");
		assertEquals(new Order(1L, nowDate, 1L, required, 1L), DAO.readLatest());
	}
	
	@Ignore
	@Test
	public void testRead() {
		final Date nowDate= Date.valueOf(LocalDate.now());
		final Date required = Date.valueOf("2022-07-29");
		final long ID = 1L;
		assertEquals(new Order(ID,  nowDate, 1L, required, 1L), DAO.read(ID));
	}
	
	@Ignore
	@Test
	public void testUpdate() {
		final Date nowDate= Date.valueOf(LocalDate.now());
		final Date required = Date.valueOf("2022-07-29");
		final Order updated = new Order(2L, nowDate, 1L, required, 1L);
		assertEquals(updated, DAO.update(updated));

	}
	@Ignore
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}

}
