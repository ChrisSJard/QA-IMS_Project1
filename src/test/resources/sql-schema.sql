CREATE database IF NOT EXISTS imsTest;
USE `imsTest` ;
DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `products`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `order_products`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `products` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) DEFAULT NULL,
    `description` VARCHAR(120) DEFAULT NULL,
    `value` DOUBLE DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `orders` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11),
    `order_date` Date,
    `required_date` Date,
    `product_id` Date,
    PRIMARY KEY (`id`),
    foreign key (`customer_id`) references customers(id)
);

CREATE TABLE IF NOT EXISTS `order_products` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `product_id` INT(11),
    `order_id` INT(11),
    PRIMARY KEY (`id`),
    foreign key (`product_id`) references products(id),
    foreign key (`order_id`) references orders(id)
);