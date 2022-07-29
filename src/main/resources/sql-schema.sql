CREATE database IF NOT EXISTS ims;
drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`products` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) DEFAULT NULL,
    `description` VARCHAR(120) DEFAULT NULL,
    `value` DOUBLE DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11),
    `order_date` Date,
    `required_date` Date,
    `product_id` INT(11),
    PRIMARY KEY (`id`),
    foreign key (`customer_id`) references customers(id)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_products` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `product_id` INT(11),
    `order_id` INT(11),
    PRIMARY KEY (`id`),
    foreign key (`product_id`) references products(id),
    foreign key (`order_id`) references orders(id)
);

