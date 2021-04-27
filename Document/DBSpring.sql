-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`customer` (
  `email` VARCHAR(45) NOT NULL,
  `id` INT NULL DEFAULT NULL,
  `name` VARCHAR(60) NULL DEFAULT NULL,
  `address` VARCHAR(100) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`payment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`payment_type` (
  `id` INT NOT NULL,
  `type_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`payment_data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`payment_data` (
  `id` INT NOT NULL,
  `data_name` VARCHAR(255) NOT NULL,
  `data_type` VARCHAR(255) NOT NULL,
  `payment_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_payment_data_payment_type1_idx` (`payment_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_payment_data_payment_type1`
    FOREIGN KEY (`payment_type_id`)
    REFERENCES `mydb`.`payment_type` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`shipments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`shipments` (
  `id` INT NOT NULL,
  `time_created` DATETIME NOT NULL,
  `shipping_address` VARCHAR(45) NOT NULL,
  `products_price` DECIMAL(8,2) NOT NULL,
  `delivery_cost` DECIMAL(8,2) NOT NULL,
  `final_price` DECIMAL(8,2) NOT NULL,
  `payment_type_id` INT NOT NULL,
  `customer_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_shipments_payment_type1_idx` (`payment_type_id` ASC) VISIBLE,
  INDEX `fk_shipments_customer1_idx` (`customer_email` ASC) VISIBLE,
  CONSTRAINT `fk_shipments_customer1`
    FOREIGN KEY (`customer_email`)
    REFERENCES `mydb`.`customer` (`email`),
  CONSTRAINT `fk_shipments_payment_type1`
    FOREIGN KEY (`payment_type_id`)
    REFERENCES `mydb`.`payment_type` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`payment_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`payment_details` (
  `id` INT NOT NULL,
  `value` VARCHAR(255) NOT NULL,
  `Payment_data_id` INT NOT NULL,
  `shipments_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Payment_details_Payment_data1_idx` (`Payment_data_id` ASC) VISIBLE,
  INDEX `fk_payment_details_shipments1_idx` (`shipments_id` ASC) VISIBLE,
  CONSTRAINT `fk_Payment_details_Payment_data1`
    FOREIGN KEY (`Payment_data_id`)
    REFERENCES `mydb`.`payment_data` (`id`),
  CONSTRAINT `fk_payment_details_shipments1`
    FOREIGN KEY (`shipments_id`)
    REFERENCES `mydb`.`shipments` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`supplier` (
  `id` INT NOT NULL,
  `supplier_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`products` (
  `id` INT NOT NULL,
  `product_name` VARCHAR(45) NOT NULL,
  `product_description` VARCHAR(255) NOT NULL,
  `product_type` VARCHAR(45) NOT NULL,
  `unit` VARCHAR(45) NOT NULL,
  `price_per_unit` DECIMAL(8,2) NOT NULL,
  `supplier_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Products_Supplier_idx` (`supplier_id` ASC) VISIBLE,
  CONSTRAINT `fk_Products_Supplier`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `mydb`.`supplier` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`shipment_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`shipment_details` (
  `id` VARCHAR(45) NOT NULL,
  `products_id` INT NOT NULL,
  `shipments_id` INT NOT NULL,
  `quantity` DECIMAL(8,2) NOT NULL,
  `price_per_unit` DECIMAL(8,2) NOT NULL,
  `price` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_products_has_shipments_shipments1_idx` (`shipments_id` ASC) VISIBLE,
  INDEX `fk_products_has_shipments_products1_idx` (`products_id` ASC) VISIBLE,
  CONSTRAINT `fk_products_has_shipments_products1`
    FOREIGN KEY (`products_id`)
    REFERENCES `mydb`.`products` (`id`),
  CONSTRAINT `fk_products_has_shipments_shipments1`
    FOREIGN KEY (`shipments_id`)
    REFERENCES `mydb`.`shipments` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
