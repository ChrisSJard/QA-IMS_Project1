package com.qa.ims.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order>{

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order: orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a customer id number");
		Long custID = utils.getLong();
		LOGGER.info("Please enter delivery date xxxx-xx-xx");
		String deliveryDate = utils.getString();
		Date requiredDate=Date.valueOf(deliveryDate);//converting string into sql date 
		Date dateNow = Date.valueOf(LocalDate.now());
		Order order = orderDAO.create(new Order(custID, dateNow, requiredDate));
		LOGGER.info("Order succesfully made");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter your order id ref of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter new date of delivery xxxx-xx-xx");
		String deliveryDate = utils.getString();
		Date requiredDate=Date.valueOf(deliveryDate);
		Order order = orderDAO.update(new Order(id, requiredDate));
		return order;
	}

	@Override
	public int delete() {
		return 0;
	}

}
