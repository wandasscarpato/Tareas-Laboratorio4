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
-- Table structure for table `n_prestamo`
--

DROP TABLE IF EXISTS `n_prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `n_prestamo` (
  `N_Prestamo` int(11) NOT NULL,
  `DNI` int(11) DEFAULT NULL,
  `Fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `importe_intereses` decimal(18,2) DEFAULT NULL,
  `importe_pedido` decimal(18,2) DEFAULT NULL,
  `plazo` int(11) DEFAULT NULL,
  `montoXMes` decimal(18,2) DEFAULT NULL,
  `Cuotas` int(11) DEFAULT NULL,
  `N_CuentaADepositar` int(11) DEFAULT NULL,
  `Estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`N_Prestamo`),
  KEY `FK_DNI` (`DNI`),
  CONSTRAINT `FK_DNI` FOREIGN KEY (`DNI`) REFERENCES `cliente` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `n_prestamo`
--

LOCK TABLES `n_prestamo` WRITE;
/*!40000 ALTER TABLE `n_prestamo` DISABLE KEYS */;
INSERT INTO `n_prestamo` VALUES (1,1,'2021-07-04 23:31:11',10000.00,500.00,4,1000.00,230,1,1),(2,2,'2021-07-04 23:31:11',2222.00,2222.00,2,222.00,22,2,1),(3,3,'2021-07-04 23:31:11',33333.00,3333.00,3,333.00,33,3,1),(4,4,'2021-07-04 23:31:11',444.00,4444.00,44,444.00,4444,4,1),(5,5,'2021-07-04 23:31:11',5555.00,5555.00,5,555.00,55,5,1),(6,6,'2021-07-04 23:43:25',6666.00,6666.00,6,666.00,666,6,1),(7,1,'2021-07-04 23:45:04',1111.00,1111.00,1,111.00,11,1,0),(8,2,'2021-07-04 23:45:04',222.00,222.00,4,6.00,6,2,0),(9,3,'2021-07-04 23:45:04',22.00,44.00,4,6.00,7,2,0),(10,4,'2021-07-04 23:45:04',2.00,44.00,4,6.00,6,3,0),(11,5,'2021-07-04 23:45:04',222.00,44.00,44,666.00,5,2,0),(12,6,'2021-07-04 23:45:04',22222.00,4.00,5,6.00,43,4,0),(13,1,'2021-07-04 23:45:04',22.00,4.00,6,6.00,4,5,0);
/*!40000 ALTER TABLE `n_prestamo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-04 23:49:53