-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `P_ID` varchar(20) NOT NULL,
  `F_NAME` varchar(30) DEFAULT NULL,
  `S_NAME` varchar(30) DEFAULT NULL,
  `AGE` varchar(20) DEFAULT NULL,
  `OPD` varchar(20) DEFAULT NULL,
  `GENDER` varchar(10) DEFAULT NULL,
  `M_STATUS` varchar(20) DEFAULT NULL,
  `P_DATE` date DEFAULT NULL,
  `ADDRESS` varchar(45) DEFAULT NULL,
  `CITY` varchar(20) DEFAULT NULL,
  `PHONE_NO` varchar(20) DEFAULT NULL,
  `DOCTOR_ID` varchar(45) DEFAULT NULL,
  `ACTIVE` char(2) DEFAULT NULL,
  PRIMARY KEY (`P_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('P101','daksh','kumar','55','neuro','Male','Married','2020-08-16','109 B-Sector Indrapuri','Bhopal','9131388238','D101','Y'),('P102','piyush','likhitkar','22','cardio','Male','UnMarried','2020-11-15','house no-5 laxmi nagar piplani','bhopal','9131388238','D102','Y'),('P103','bvcjh','gdjuyfg','54','Neurology','Male','Married','2020-11-15','jhsdgjfhsgdfjhsdb','bhopal','8319615528','D103',NULL),('P104','gcvhsgdv','bfvjhguyfd','45','neurology','Male','Married','2020-11-15','hdfjhygdsfuyhsvduyhfw','hdfgjs','8319615528','D104',NULL);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-04 14:56:56
