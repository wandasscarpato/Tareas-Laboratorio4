-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: lab4
-- ------------------------------------------------------
-- Server version	5.7.33-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `DNI` int(11) NOT NULL,
  `CUIL` int(11) DEFAULT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `Sexo` varchar(45) DEFAULT NULL,
  `Nacimiento` date DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `ID_Localodad` int(11) DEFAULT NULL,
  `ID_Provincia` int(11) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `Estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  KEY `ID_Localodad_idx` (`ID_Localodad`),
  KEY `ID_Provincia_idx` (`ID_Provincia`),
  CONSTRAINT `fk_id_localidad` FOREIGN KEY (`ID_Localodad`) REFERENCES `localidad` (`ID_Localidad`),
  CONSTRAINT `fk_id_provincia` FOREIGN KEY (`ID_Provincia`) REFERENCES `privincia` (`ID_Provincia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,1,'usuario1','usuario1','Masculino','2021-08-01','direccion 1',4,4,'usuario1@gmail.com',1111,1),(2,2,'usuario2','usuario2','Masculino','2021-07-30','direccion 2',2,1,'usuario2@gmail.com',2222,1),(3,3,'usuario3','usuario3','Masculino','2021-07-14','direccion 3',3,1,'usuario3@gmail.com',333,1),(4,4,'usuario4','usuario4','Masculino','2021-07-24','direccion 4',1,1,'usuario5@gmail.com',4,1),(5,5,'usuario4','usuario4','Masculino','1999-03-23','direccion 5',1,1,'usuario1@gmail.com',555,1),(6,6,'usuario','usu2','Femenino','2021-02-11','Pasteur',5,2,'usuario1@gmail.com',555,1),(7,7,'usuario','usu3','Femenino','2021-02-11','Pasteur',4,2,'usuario1@gmail.com',444,1),(8,8,'usuaio','usu4','Femenino','2021-02-11','Pasteur',3,2,'usuario1@gmail.com',333,1),(9,9,'usuario','usu5','Femenino','2021-02-11','Pasteur',2,2,'usuario1@gmail.com',222,1),(10,10,'MOMO','momo','Masculino','2021-02-11','Pasteur',5,2,'usuario1@gmail.com',2223,1),(11,11,'Roberto','rober','Masculino','2021-02-11','Pasteur',1,1,'usuario1@gmail.com',3334,1),(12,12,'Tamara','tami','Femenino','2021-02-11','Pasteur',1,1,'usuario1@gmail.com',3334,1),(13,13,'Juan','juan','Masculino','2021-02-11','Pasteur',1,1,'usuario1@gmail.com',434,1),(14,14,'Pablo','pabli','Masculino','2021-02-11','Pasteur',1,1,'usuario1@gmail.com',4,1),(111,1112,'Fufi','Sc','Femeninio','2021-03-11','CPLM, Escobar',1,1,'fufi@gmail.com',4442,1),(1113,1111,'Popito','Tonais','Masculino','2021-02-11','Pasteur',5,2,'popito@gmial.com',5554,1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-04 23:49:54
