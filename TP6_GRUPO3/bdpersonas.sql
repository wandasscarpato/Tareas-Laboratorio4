CREATE SCHEMA `bdpersonas` ;

CREATE TABLE `bdpersonas`.`personas` (
  `dni` VARCHAR(8) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  PRIMARY KEY (`dni`));
