-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: shoppingdb
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `tbl_addr`
--

DROP TABLE IF EXISTS `tbl_addr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_addr` (
  `adr_addr` varchar(255) NOT NULL,
  `member_id` varchar(45) DEFAULT NULL,
  `order_id` varchar(45) NOT NULL,
  PRIMARY KEY (`adr_addr`,`order_id`),
  KEY `FK_Addr_Member_idx` (`member_id`),
  KEY `FK_Addr_Order_idx` (`order_id`),
  KEY `FK_Addr_Order_new_idx` (`order_id`),
  CONSTRAINT `FK_Addr_Member` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`member_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Addr_Order_new` FOREIGN KEY (`order_id`) REFERENCES `tbl_order` (`order_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_addr`
--

LOCK TABLES `tbl_addr` WRITE;
/*!40000 ALTER TABLE `tbl_addr` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_addr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_member`
--

DROP TABLE IF EXISTS `tbl_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_member` (
  `member_id` varchar(45) NOT NULL,
  `pw` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `adr_addr` varchar(255) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  KEY `FK_Member_Addr_idx` (`adr_addr`),
  CONSTRAINT `FK_Member_Addr` FOREIGN KEY (`adr_addr`) REFERENCES `tbl_addr` (`adr_addr`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_member`
--

LOCK TABLES `tbl_member` WRITE;
/*!40000 ALTER TABLE `tbl_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_order`
--

DROP TABLE IF EXISTS `tbl_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_order` (
  `order_id` varchar(45) NOT NULL,
  `member_id` varchar(45) DEFAULT NULL,
  `product_code` int DEFAULT NULL,
  `product_name` varchar(45) DEFAULT NULL,
  `adr_addr` varchar(255) DEFAULT NULL,
  `odr_amount` int DEFAULT NULL,
  `odr_date` date DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_Member_Order_idx` (`member_id`),
  KEY `FK_Addr_Order_idx` (`adr_addr`),
  KEY `FK_Product_Order_idx` (`product_code`,`product_name`),
  CONSTRAINT `FK_Addr_Order` FOREIGN KEY (`adr_addr`) REFERENCES `tbl_addr` (`adr_addr`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Member_Order` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`member_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Product_Order` FOREIGN KEY (`product_code`, `product_name`) REFERENCES `tbl_product` (`product_code`, `product_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_order`
--

LOCK TABLES `tbl_order` WRITE;
/*!40000 ALTER TABLE `tbl_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_product`
--

DROP TABLE IF EXISTS `tbl_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_product` (
  `product_code` int NOT NULL,
  `product_name` varchar(45) NOT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`product_code`,`product_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_product`
--

LOCK TABLES `tbl_product` WRITE;
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-29 11:38:03
