-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema lab4
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lab4
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab4` DEFAULT CHARACTER SET utf8 ;
USE `lab4` ;

-- -----------------------------------------------------
-- Table `lab4`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`administrador` (
  `Usuario` INT(11) NOT NULL,
  `Pass` VARCHAR(45) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`localidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`localidad` (
  `ID_Localidad` INT(11) NOT NULL,
  `Localidad` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Localidad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`privincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`privincia` (
  `ID_Provincia` INT(11) NOT NULL,
  `Provincia` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Provincia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`cliente` (
  `DNI` INT(11) NOT NULL,
  `CUIL` INT(11) NULL DEFAULT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Apellido` VARCHAR(45) NULL DEFAULT NULL,
  `Sexo` VARCHAR(45) NULL DEFAULT NULL,
  `Nacimiento` DATE NULL DEFAULT NULL,
  `Direccion` VARCHAR(45) NULL DEFAULT NULL,
  `ID_Localodad` INT(11) NULL DEFAULT NULL,
  `ID_Provincia` INT(11) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `Telefono` INT(11) NULL DEFAULT NULL,
  `Estado` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  INDEX `ID_Localodad_idx` (`ID_Localodad` ASC) VISIBLE,
  INDEX `ID_Provincia_idx` (`ID_Provincia` ASC) VISIBLE,
  CONSTRAINT `fk_id_localidad`
    FOREIGN KEY (`ID_Localodad`)
    REFERENCES `lab4`.`localidad` (`ID_Localidad`),
  CONSTRAINT `fk_id_provincia`
    FOREIGN KEY (`ID_Provincia`)
    REFERENCES `lab4`.`privincia` (`ID_Provincia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`cuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`cuenta` (
  `N_Cuenta` INT(11) NOT NULL AUTO_INCREMENT,
  `Fecha_cracion` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `Tipo` VARCHAR(45) NULL DEFAULT NULL,
  `CBU` INT(11) NOT NULL,
  `Saldo` DECIMAL(18,2) NULL DEFAULT NULL,
  `DNI` INT(11) NULL DEFAULT NULL,
  `Estado` TINYINT(4) NULL DEFAULT '1',
  PRIMARY KEY (`N_Cuenta`),
  INDEX `DNI_idx` (`DNI` ASC) VISIBLE,
  CONSTRAINT `fk_DNI_cuenta`
    FOREIGN KEY (`DNI`)
    REFERENCES `lab4`.`cliente` (`DNI`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`tipo_movimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`tipo_movimiento` (
  `ID_Tipo` INT(11) NOT NULL,
  `Tipo_Movimiento` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Tipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`movimientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`movimientos` (
  `ID_Movimiento` INT(11) NOT NULL,
  `Fecha` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `Detalle` VARCHAR(45) NULL DEFAULT NULL,
  `Importe` DECIMAL(18,2) NULL DEFAULT NULL,
  `ID_TIPO_M` INT(11) NULL DEFAULT NULL,
  `N_Cuenta` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Movimiento`),
  INDEX `ID_TIPO_M_idx` (`ID_TIPO_M` ASC) VISIBLE,
  INDEX `N_Cuenta_idx` (`N_Cuenta` ASC) VISIBLE,
  CONSTRAINT `fk_ID_TIPO_M`
    FOREIGN KEY (`ID_TIPO_M`)
    REFERENCES `lab4`.`tipo_movimiento` (`ID_Tipo`),
  CONSTRAINT `fk_N_Cuenta`
    FOREIGN KEY (`N_Cuenta`)
    REFERENCES `lab4`.`cuenta` (`N_Cuenta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`n_prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`n_prestamo` (
  `N_Prestamo` INT(11) NOT NULL AUTO_INCREMENT,
  `DNI` INT(11) NULL DEFAULT NULL,
  `Fecha` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `importe_intereses` DECIMAL(18,2) NULL DEFAULT NULL,
  `importe_pedido` DECIMAL(18,2) NULL DEFAULT NULL,
  `plazo` INT(11) NULL DEFAULT NULL,
  `montoXMes` DECIMAL(18,2) NULL DEFAULT NULL,
  `Cuotas` INT(11) NULL DEFAULT NULL,
  `N_CuentaADepositar` INT(11) NULL DEFAULT NULL,
  `Estado` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`N_Prestamo`),
  INDEX `FK_DNI` (`DNI` ASC) VISIBLE,
  CONSTRAINT `FK_DNI`
    FOREIGN KEY (`DNI`)
    REFERENCES `lab4`.`cliente` (`DNI`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`usuario` (
  `Usuario` VARCHAR(45) NOT NULL,
  `DNI` INT(11) NULL DEFAULT NULL,
  `Pass` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Usuario`),
  INDEX `DNI_idx` (`DNI` ASC) VISIBLE,
  CONSTRAINT `fk_DNI-cliente`
    FOREIGN KEY (`DNI`)
    REFERENCES `lab4`.`cliente` (`DNI`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
