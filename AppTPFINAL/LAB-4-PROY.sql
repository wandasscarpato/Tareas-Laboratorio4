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
-- Table `lab4`.`Administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`Administrador` (
  `Usuario` INT NOT NULL,
  `Pass` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`Localidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`Localidad` (
  `ID_Localidad` INT NOT NULL,
  `Localidad` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Localidad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`Privincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`Privincia` (
  `ID_Provincia` INT NOT NULL,
  `Provincia` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Provincia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`Cliente` (
  `DNI` INT NOT NULL,
  `CUIL` INT NULL DEFAULT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Apellido` VARCHAR(45) NULL DEFAULT NULL,
  `Sexo` VARCHAR(45) NULL DEFAULT NULL,
  `Nacimiento` VARCHAR(45) NULL DEFAULT NULL,
  `Direccion` VARCHAR(45) NULL DEFAULT NULL,
  `ID_Localodad` INT NULL DEFAULT NULL,
  `ID_Provincia` INT NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `Telefono` INT NULL DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  INDEX `ID_Localodad_idx` (`ID_Localodad` ASC) VISIBLE,
  INDEX `ID_Provincia_idx` (`ID_Provincia` ASC) VISIBLE,
  CONSTRAINT `fk_id_localidad`
    FOREIGN KEY (`ID_Localodad`)
    REFERENCES `lab4`.`Localidad` (`ID_Localidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_provincia`
    FOREIGN KEY (`ID_Provincia`)
    REFERENCES `lab4`.`Privincia` (`ID_Provincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`Usuario` (
  `Usuario` VARCHAR(45) NOT NULL,
  `DNI` INT NULL DEFAULT NULL,
  `Pass` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Usuario`),
  INDEX `DNI_idx` (`DNI` ASC) VISIBLE,
  CONSTRAINT `fk_DNI-cliente`
    FOREIGN KEY (`DNI`)
    REFERENCES `lab4`.`Cliente` (`DNI`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`Tipo_cuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`Tipo_cuenta` (
  `ID_Tipo` INT NOT NULL,
  `Tipo` VARCHAR(45) NULL DEFAULT NULL,
  `Moneda` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Tipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`Cuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`Cuenta` (
  `N_Cuenta` INT NOT NULL,
  `ID_Tipo` INT NULL DEFAULT NULL,
  `Fecha_cracion` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `CBU` INT NULL DEFAULT NULL,
  `Saldo` DECIMAL(18,2) NULL DEFAULT NULL,
  `DNI` INT NULL DEFAULT NULL,
  PRIMARY KEY (`N_Cuenta`),
  INDEX `ID_Tipo_idx` (`ID_Tipo` ASC) VISIBLE,
  INDEX `DNI_idx` (`DNI` ASC) VISIBLE,
  CONSTRAINT `fk_DNI_cuenta`
    FOREIGN KEY (`DNI`)
    REFERENCES `lab4`.`Cliente` (`DNI`),
  CONSTRAINT `fk_ID_Tipo`
    FOREIGN KEY (`ID_Tipo`)
    REFERENCES `lab4`.`Tipo_cuenta` (`ID_Tipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`Tipo_Movimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`Tipo_Movimiento` (
  `ID_Tipo` INT NOT NULL,
  `Tipo_Movimiento` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Tipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`Movimientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`Movimientos` (
  `ID_Movimiento` INT NOT NULL,
  `Fecha` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `Detalle` VARCHAR(45) NULL DEFAULT NULL,
  `Importe` DECIMAL(18,2) NULL DEFAULT NULL,
  `ID_TIPO_M` INT NULL DEFAULT NULL,
  `N_Cuenta` INT NULL DEFAULT NULL,
  PRIMARY KEY (`ID_Movimiento`),
  INDEX `ID_TIPO_M_idx` (`ID_TIPO_M` ASC) VISIBLE,
  INDEX `N_Cuenta_idx` (`N_Cuenta` ASC) VISIBLE,
  CONSTRAINT `fk_N_Cuenta`
    FOREIGN KEY (`N_Cuenta`)
    REFERENCES `lab4`.`Cuenta` (`N_Cuenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ID_TIPO_M`
    FOREIGN KEY (`ID_TIPO_M`)
    REFERENCES `lab4`.`Tipo_Movimiento` (`ID_Tipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lab4`.`N_Prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab4`.`N_Prestamo` (
  `N_Prestamo` INT NOT NULL,
  `DNI` INT NULL DEFAULT NULL,
  `Fecha` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `importe_intereses` DECIMAL(18,2) NULL DEFAULT NULL,
  `importe_pedido` DECIMAL(18,2) NULL DEFAULT NULL,
  `plazo` INT NULL DEFAULT NULL,
  `montoXMes` DECIMAL(18,2) NULL DEFAULT NULL,
  `Cuotas` INT NULL DEFAULT NULL,
  `N_CuentaADepositar` INT NULL DEFAULT NULL,
  `Estado` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`N_Prestamo`),
  INDEX `FK_DNI` (`DNI` ASC) VISIBLE,
  CONSTRAINT `FK_DNI`
    FOREIGN KEY (`DNI`)
    REFERENCES `lab4`.`Cliente` (`DNI`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
