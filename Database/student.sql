-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: student
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `courseid` varchar(45) NOT NULL,
  `coursename` varchar(45) DEFAULT NULL,
  `deptid` varchar(45) DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  `pre_req` int(11) DEFAULT NULL,
  `seats_left` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('c1','Maths','d1',4,4,16),('c2','OS','d2',4,5,32),('c3','DAA','d3',4,2,57),('c4','AOS','d4',4,3,31),('c5','CNW','d2',3,3,62);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses_taken`
--

DROP TABLE IF EXISTS `courses_taken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses_taken` (
  `username` varchar(45) NOT NULL DEFAULT '',
  `courseid` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`username`,`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses_taken`
--

LOCK TABLES `courses_taken` WRITE;
/*!40000 ALTER TABLE `courses_taken` DISABLE KEYS */;
INSERT INTO `courses_taken` VALUES ('a1','c3'),('a5','c1'),('a9','c1'),('u1','c1'),('u1','c2'),('u1','c3'),('u1','c4'),('u1','c5'),('u2','c5'),('u3','c2');
/*!40000 ALTER TABLE `courses_taken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `nid` varchar(45) NOT NULL,
  `content` longtext,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES ('n1','Alert New Courses will be added soon!!!.'),('n2','New Course AOS is added please register as soon as possible!!.'),('n3','Registrations for maths are Closed Now!.'),('n4','Pre-requisites for DAA are Updated!.'),('n5','Last date of registration is extended for CNW!. ');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `deptid` varchar(45) DEFAULT NULL,
  `gpa` int(11) DEFAULT NULL,
  `sem` int(11) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `contact_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('a1','a1','d2',7,3,'ask@gmail.com','c3',675345),('a5','qwe','2',7,5,'van@gmail.com','g5',9898989),('a7','qwee','c1',8,5,'nn@gmail.com','hhh',900090890),('a9','qwee','q1',8,6,'vaAn@gmail.com','gygy',9000999),('u1','u1','d1',4,7,'defrt@gmail.com','c1',456287),('u2','u2','d2',8,5,'abc@gmail.com','c2',909090),('u3','u3','d3',7,7,'asdf@gmail.com','abcdef',98766436),('u4','u4','d4',8,4,'ert@gmail.com','c4',897657),('u5','u5','d5',6,2,'erduyt23@gmail.com','c5',897657),('u6','u6','d6',8,2,'deffrdhei@gmail.com','c6',645352),('u7','u7','d5',9,5,'abcgdef@gmail.com','c2',98745623);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-14 21:43:00
