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
-- Table structure for table `crowdata`
--

DROP TABLE IF EXISTS `crowdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crowdata` (
  `index` int(11) NOT NULL AUTO_INCREMENT,
  `crowdName` varchar(45) NOT NULL,
  `crowdMtoiletCloset` int(11) DEFAULT NULL,
  `crowdMtoiletUrinal` int(11) DEFAULT NULL,
  `crowdWCloset` int(11) NOT NULL,
  `crowdLongitude` double DEFAULT NULL,
  `crowdLatitude` double DEFAULT NULL,
  `crowdAddr` varchar(45) DEFAULT NULL,
  `crowdEtc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`index`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='crowd sourcing info';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crowdata`
--

LOCK TABLES `crowdata` WRITE;
/*!40000 ALTER TABLE `crowdata` DISABLE KEYS */;
INSERT INTO `crowdata` VALUES (1,'산학협력관화장실',3,7,4,35.145162,129.008754,'부산광역시 사상구 주례로 47','동서대학교 내 산학협력관 3층에 위치한 화장실입니다.'),(2,'동서대산학협력화장실',2,2,2,129.008754,35.145162,'사상구 주례로 47','동서대학교 산학협력관 3층 화장실'),(3,'동서대학교 민석도서관',4,0,0,NULL,35.1442031860352,'대한민국 \n617-010 부산광역시 주례2동 동서대학교 민석도서관',NULL),(4,'테스트1',3,0,0,NULL,35.147533416748,'대한민국 \n617-012 부산광역시 주례동 167-20',NULL),(5,'테스드2',6,0,0,129.004379272461,35.1455268859863,'대한민국 \n617-010 부산광역시 null 107','터스드2'),(6,'UIT화장실',4,0,0,129.007247924805,35.1457328796387,'대한민국 \n617-010 부산광역시 주례동 88-10','6층건물'),(7,'테스트4',5,0,0,129.012435913086,35.1440887451172,'대한민국 \n617-012 부산광역시 주례동 산68','민석도서관'),(8,'테스트5',10,0,0,129.007034301758,35.1461982727051,'대한민국 \n617-010 부산광역시 주례동 동서대학교 글로벌빌리지',''),(9,'테스트6',3,7,10,129.012359619141,35.145679473877,'대한민국 \n617-012 부산광역시 주례동 84-192','터스드'),(10,'테스트6',7,5,7,129.008407592773,35.1485748291016,'대한민국 \n617-012 부산광역시 null 56-1','터스드'),(11,'주례중학교 화장실',7,4,4,129.013778686523,35.1481475830078,'대한민국 \n617-010 부산광역시 null ６８','주례중학교 화장실');
/*!40000 ALTER TABLE `crowdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-12 13:40:02
