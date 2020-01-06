-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: newschema
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `datatest`
--

DROP TABLE IF EXISTS `datatest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datatest` (
  `ID` int(11) NOT NULL,
  `addrRoad` varchar(500) DEFAULT NULL,
  `toiletName` varchar(300) DEFAULT NULL,
  `longtitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datatest`
--

LOCK TABLES `datatest` WRITE;
/*!40000 ALTER TABLE `datatest` DISABLE KEYS */;
INSERT INTO `datatest` VALUES (1,'부산광역시 중구 대교로 140 (중앙동5가)','수미르공원',NULL,NULL),(2,'부산광역시 중구 샘길 10 (대청동1가)','복병산체육공원',NULL,NULL),(3,'부산광역시 서구 꽃마을로89','꽃마을',129.0087046,35.1212419),(4,'부산광역시 서구 망양로 57 (서대신동3가)','구덕야구장',129.0150055,35.1161361),(5,'부산광역시 서구 암남공원로 25 (암남동)','송도해수욕장2호',129.0157266,35.0737219),(6,'부산광역시 서구 암남공원로 25 (암남동)','송도해수욕장3호',129.0157266,35.0737219),(7,'부산광역시 서구 송도해변로 167 (암남동)','송림공원',129.0237127,35.0763995),(8,'부산광역시 서구 옥천로 161-5 (아미동2가)','아미골',129.01109,35.0995091),(9,NULL,'부민산체육공원',129.013788,35.104018),(10,NULL,'남항대교아래야영장',129.0237435,35.078952),(11,NULL,'암남체육공원',129.0176327,35.0673095),(12,'부산광역시 서구 암남공원로522번길 160 (암남동)','암남예비군교장',129.0134617,35.0711781),(13,'부산광역시 서구 천마산로209번길 103 (남부민동)','천마산체육공원',129.0170637,35.0889741),(14,NULL,'암남공원',129.0161047,35.0608773),(15,'부산광역시 서구 꽃마을로156번길 109 (서대신동3가','청소년수련원',129.0154772,35.1287769);
/*!40000 ALTER TABLE `datatest` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-12 13:40:01
