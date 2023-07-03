-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: shoppingmall
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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `user_id` int DEFAULT NULL,
  `item_id` int DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `product` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homepage_faq`
--

DROP TABLE IF EXISTS `homepage_faq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `homepage_faq` (
  `pg_faq_id` int NOT NULL,
  `pg_question` varchar(400) NOT NULL,
  `pg_answer` varchar(2000) NOT NULL,
  PRIMARY KEY (`pg_faq_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homepage_faq`
--

LOCK TABLES `homepage_faq` WRITE;
/*!40000 ALTER TABLE `homepage_faq` DISABLE KEYS */;
/*!40000 ALTER TABLE `homepage_faq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homepage_notice`
--

DROP TABLE IF EXISTS `homepage_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `homepage_notice` (
  `pg_notice_id` int NOT NULL,
  `pg_title` varchar(400) NOT NULL,
  `pg_notice` varchar(2000) NOT NULL,
  PRIMARY KEY (`pg_notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homepage_notice`
--

LOCK TABLES `homepage_notice` WRITE;
/*!40000 ALTER TABLE `homepage_notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `homepage_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `item_id` int NOT NULL,
  `item_type` varchar(20) NOT NULL,
  `item_price` int NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `item_shippingfee` int NOT NULL,
  `item_discription` varchar(200) NOT NULL,
  `item_discription_dt` varchar(200) NOT NULL,
  `item_stock` int NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `item_type1` (`item_type`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`item_type`) REFERENCES `product_type1` (`item_type1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_img`
--

DROP TABLE IF EXISTS `product_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_img` (
  `item_id` int NOT NULL,
  `item_img1` varchar(1000) NOT NULL,
  `item_img2` varchar(1000) NOT NULL,
  `item_img3` varchar(1000) NOT NULL,
  KEY `item_id` (`item_id`),
  CONSTRAINT `product_img_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `product` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_img`
--

LOCK TABLES `product_img` WRITE;
/*!40000 ALTER TABLE `product_img` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_type1`
--

DROP TABLE IF EXISTS `product_type1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_type1` (
  `item_type1` varchar(20) NOT NULL,
  `item_type2` varchar(20) NOT NULL,
  PRIMARY KEY (`item_type1`),
  KEY `item_type2` (`item_type2`),
  CONSTRAINT `product_type1_ibfk_1` FOREIGN KEY (`item_type2`) REFERENCES `product_type2` (`item_type2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type1`
--

LOCK TABLES `product_type1` WRITE;
/*!40000 ALTER TABLE `product_type1` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_type1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_type2`
--

DROP TABLE IF EXISTS `product_type2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_type2` (
  `item_type2` varchar(20) NOT NULL,
  PRIMARY KEY (`item_type2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type2`
--

LOCK TABLES `product_type2` WRITE;
/*!40000 ALTER TABLE `product_type2` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_type2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_info`
--

DROP TABLE IF EXISTS `purchase_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_info` (
  `order_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `item_id` int DEFAULT NULL,
  `order_date` date NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `purchase_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `purchase_info_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `product` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_info`
--

LOCK TABLES `purchase_info` WRITE;
/*!40000 ALTER TABLE `purchase_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `review_id` int NOT NULL,
  `user_id` int NOT NULL,
  `item_id` int NOT NULL,
  `review` varchar(10000) NOT NULL,
  PRIMARY KEY (`review_id`),
  KEY `user_id` (`user_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `product` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `user_lastestview` int NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_age` int DEFAULT NULL,
  `user_addr` varchar(200) NOT NULL,
  `user_addr_dt` varchar(50) NOT NULL,
  `user_pnum` int NOT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_isadmin` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `user_serialnum` int NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `user_pw` varchar(200) NOT NULL,
  `user_nickname` varchar(50) NOT NULL,
  `user_lastest_login` date NOT NULL,
  `user_issleeped` tinyint(1) NOT NULL,
  KEY `user_serialnum` (`user_serialnum`),
  CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`user_serialnum`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-12 13:29:08
