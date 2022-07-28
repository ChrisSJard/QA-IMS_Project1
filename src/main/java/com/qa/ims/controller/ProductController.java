package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ProductDAO;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.Utils;

public class ProductController implements CrudController<Product> {

	public static final Logger LOGGER = LogManager.getLogger();
	private ProductDAO productDAO;
	private Utils utils;
	
	public ProductController(ProductDAO productDAO, Utils utils) {
		super();
		this.productDAO = productDAO;
		this.utils = utils;
	}

	@Override
	public List<Product> readAll() {
		List<Product> products = productDAO.readAll();
		for (Product product : products) {
			LOGGER.info(product);
		}
		return products;
	}

	@Override
	public Product create() {
		LOGGER.info("Please enter a product name");
		String productName = utils.getString();
		LOGGER.info("Please enter a product description");
		String productDescription = utils.getString();
		LOGGER.info("Please enter a product value");
		try {
			Double value = utils.getDouble();
			if (value > 0 ) {
				Product product = productDAO.create(new Product(productName, productDescription, value));
				LOGGER.info("Product created");
				return product;
			}else {
				LOGGER.warn("number must be greater than zero");
			}
		} catch (Exception e) {
			LOGGER.warn("not a valid number");
		}
		return null;
	}

	@Override
	public Product update() {
		LOGGER.info("Please enter the id of the product you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a product name");
		String productName = utils.getString();
		LOGGER.info("Please enter a product description");
		String productDescription = utils.getString();
		LOGGER.info("Please enter a product value");
		Double value = utils.getDouble();
		Product product = productDAO.update(new Product(id, productName, productDescription, value));
		LOGGER.info("Product Updated");
		return product;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the product you would like to delete");
		Long id = utils.getLong();
		return productDAO.delete(id);
	}

}
