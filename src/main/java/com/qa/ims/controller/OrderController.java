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
		LOGGER.info("Please enter a customer id number (must exist in database)");
		Long custID = utils.getLong();
		LOGGER.info("Please enter delivery date xxxx-xx-xx");
		Date requiredDate = utils.getDate();
		Date dateNow = Date.valueOf(LocalDate.now());
		LOGGER.info("Please enter a item id number (must exist in database)");
		Long prodID = utils.getLong();
		Order order = orderDAO.create(new Order(custID, dateNow, requiredDate, prodID));
		return (order != null) ? order : null;
		//LOGGER.info("Order succesfully made\n");
		//LOGGER.info(order);
		//return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter your order id ref of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter new date of delivery xxxx-xx-xx");
		Date requiredDate = utils.getDate();
		Order order = orderDAO.update(new Order(id, requiredDate));
		LOGGER.info("Order succesfully updated\n");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		LOGGER.info("Order succesfully deleted\n");
		return orderDAO.delete(id);
	}

}
