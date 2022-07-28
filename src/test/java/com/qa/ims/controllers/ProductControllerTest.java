package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ProductController;
import com.qa.ims.persistence.dao.ProductDAO;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	@Mock
	private Utils utilsMock;

	@Mock
	private ProductDAO daoMock;

	@InjectMocks
	private ProductController controllerMock;

	@Test
	public void testCreate() {
		final String description = "This is the description";
		final String name = "productTester";
		final Double value = 10.0;
		final Product created = new Product(name, description, value);

		Mockito.when(utilsMock.getString()).thenReturn(name , description);
		Mockito.when(utilsMock.getDouble()).thenReturn(value);
		Mockito.when(daoMock.create(created)).thenReturn(created);

		assertEquals(created, controllerMock.create());

		Mockito.verify(utilsMock, Mockito.times(2)).getString();
		Mockito.verify(utilsMock, Mockito.times(1)).getDouble();
		Mockito.verify(daoMock, Mockito.times(1)).create(created);
	}


	@Test
	public void testReadAll() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(1L, "item name", "item description", 50.0));

		Mockito.when(daoMock.readAll()).thenReturn(products);

		assertEquals(products, controllerMock.readAll());

		Mockito.verify(daoMock, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Product updated = new Product(1L, "item name", "item description", 50.0);

		Mockito.when(this.utilsMock.getLong()).thenReturn(1L);
		Mockito.when(this.utilsMock.getString()).thenReturn(updated.getName(), updated.getDescription());
		Mockito.when(this.utilsMock.getDouble()).thenReturn(updated.getValue());
		Mockito.when(this.daoMock.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controllerMock.update());

		Mockito.verify(this.utilsMock, Mockito.times(1)).getLong();
		Mockito.verify(this.utilsMock, Mockito.times(2)).getString();
		Mockito.verify(this.utilsMock, Mockito.times(1)).getDouble();
		Mockito.verify(this.daoMock, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utilsMock.getLong()).thenReturn(ID);
		Mockito.when(daoMock.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controllerMock.delete());

		Mockito.verify(utilsMock, Mockito.times(1)).getLong();
		Mockito.verify(daoMock, Mockito.times(1)).delete(ID);
	}

}
