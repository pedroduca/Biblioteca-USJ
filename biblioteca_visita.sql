-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `visita`
--

DROP TABLE IF EXISTS `visita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `visita` (
  `id_visita` int(11) NOT NULL AUTO_INCREMENT,
  `int_alunos` int(11) DEFAULT NULL,
  `dt_visita` datetime DEFAULT NULL,
  `ds_observacao` varchar(300) DEFAULT NULL,
  `id_professor` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_visita`),
  UNIQUE KEY `id_visita_UNIQUE` (`id_visita`),
  KEY `id_fk_professor` (`id_professor`),
  CONSTRAINT `id_fk_professor` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visita`
--

LOCK TABLES `visita` WRITE;
/*!40000 ALTER TABLE `visita` DISABLE KEYS */;
INSERT INTO `visita` VALUES (1,0,'2019-07-03 00:00:00','teste',1),(2,0,'2019-07-03 00:00:00','teste',1),(3,0,'2019-07-03 00:00:00','teste',1),(4,0,'2019-07-03 00:00:00','teste',1),(5,0,'2019-07-03 00:00:00','teste',1),(6,0,'2019-07-03 00:00:00','teste',1),(7,0,'2019-07-03 00:00:00','teste',1),(8,0,'2019-07-03 00:00:00','teste',1),(9,0,'2019-07-03 00:00:00','teste',1),(10,0,'2019-07-03 00:00:00','teste',1),(11,0,'2019-07-03 00:00:00','teste',1),(12,0,'2019-07-03 00:00:00','teste',1);
/*!40000 ALTER TABLE `visita` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-04 14:32:06
