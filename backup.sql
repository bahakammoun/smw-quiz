-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: backend
-- ------------------------------------------------------
-- Server version	5.7.17-0ubuntu0.16.04.1

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
-- Table structure for table `quest`
--

DROP TABLE IF EXISTS `quest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quest` (
  `quest_id` int(11) NOT NULL AUTO_INCREMENT,
  `quest` text,
  `asnwer` text,
  `wiki` text,
  PRIMARY KEY (`quest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quest`
--

LOCK TABLES `quest` WRITE;
/*!40000 ALTER TABLE `quest` DISABLE KEYS */;
INSERT INTO `quest` VALUES (1,'bla','blub',NULL),(2,'blabla','blubblubb',NULL),(3,'blabla','blubblubb',NULL),(4,'blabla','blubblubb',NULL),(5,'blabla','blubblubb',NULL),(6,'blabla','blubblubb',NULL),(7,'blabla','blubblubb',NULL),(8,'blabla','blubblubb',NULL),(9,'blabla','blubblubb',NULL),(10,'blabla','blubblubb',NULL),(11,'blabla','blubblubb',NULL),(12,'blabla','blubblubb',NULL),(13,'blabla','blubblubb',NULL),(14,'blabla','blubblubb',NULL),(15,'blabla','blubblubb',NULL),(16,'blabla','blubblubb',NULL),(17,'blabla','blubblubb',NULL),(18,'quest','allanswers',NULL),(19,'blabla','blubblubb',NULL),(20,'blabla','blubblubb','123');
/*!40000 ALTER TABLE `quest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `answerdQuest` int(11) DEFAULT NULL,
  `answerdCorrect` int(11) DEFAULT NULL,
  `answersPossible` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  `wiki` text,
  `feedback` text,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,4,3,2,1,2,NULL,NULL),(2,4,3,2,1,2,NULL,NULL),(3,4,3,2,1,2,NULL,NULL),(4,4,2,2,2,2,NULL,NULL),(5,4,2,2,2,2,NULL,NULL),(6,10,3,6,4,2,NULL,NULL),(7,6,5,4,3,2,NULL,NULL),(8,2,1,4,26,2,NULL,NULL),(9,5,4,8,4,3,NULL,NULL),(10,2,1,4,4,2,'wiki',NULL),(11,2,1,4,1,1,'wiki','Feedback'),(12,2,1,4,1,1,'wiki','Feedback'),(13,4,0,4,3,1,'Error','null'),(14,4,0,4,3,1,'Error','null'),(15,4,3,4,3,1,'Error','null'),(16,4,0,4,1,1,'Error','null'),(17,4,2,4,1,1,'Error','null'),(18,6,3,4,2,1,'Error','null'),(19,6,2,4,2,1,'Error','null'),(20,4,2,4,2,1,'Error','null'),(21,4,2,4,2,1,'Error','null'),(22,6,2,4,2,1,'Error','null'),(23,6,6,4,2,1,'Error','null'),(24,6,1,4,2,1,'Error','null'),(25,6,6,4,2,1,'Error','null'),(26,6,3,4,2,1,'Error','null'),(27,4,1,4,2,1,'Error','null'),(28,4,2,4,2,1,'Error','null'),(29,6,3,4,2,1,'Error','null'),(30,4,4,2,2,1,'Error','null'),(31,4,3,2,2,1,'Error','null'),(32,6,1,4,2,1,'Error','null'),(33,6,2,4,2,1,'Error','null'),(34,6,5,4,2,1,'Error','null'),(35,6,6,4,2,1,'Error','null'),(36,6,5,4,2,1,'Error','null'),(37,6,1,4,2,1,'Error','null'),(38,6,3,4,2,1,'Error','null'),(39,6,4,4,2,1,'Error','null'),(40,6,1,4,2,1,'Error','null'),(41,6,3,4,1,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','test'),(42,4,2,4,3,1,'Error','null'),(43,4,1,4,3,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','null'),(44,4,0,4,1,1,'https://amazonas.fzi.de/kel-2/','testw'),(45,4,3,6,4,5,'komisheswiki','oisoiosid'),(46,4,4,4,2,1,'Error','null'),(47,6,3,4,2,1,'Error','null'),(48,4,1,4,2,1,'Error','null'),(49,6,5,4,2,1,'Error','null'),(50,6,3,4,2,1,'Error','null'),(51,8,2,4,2,1,'Error','null'),(52,8,4,4,2,1,'Error','null'),(53,8,4,4,2,1,'Error','null'),(54,8,4,4,2,1,'Error','null'),(55,8,4,4,2,1,'Error','null'),(56,6,0,4,2,1,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedbackifuud'),(57,6,5,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(58,6,5,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(59,6,4,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','tolles quiz'),(60,6,5,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(61,6,5,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(62,6,4,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','kein deutscher Satzbau'),(63,6,4,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(64,6,4,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein FeedbackPlatz für dein Feedback'),(65,6,3,4,2,1,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(66,6,5,4,2,1,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(67,6,3,4,2,1,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(68,6,3,4,2,1,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(69,6,3,4,2,1,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(70,6,3,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(71,6,4,4,2,1,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(72,6,3,4,2,1,'https://amazonas.fzi.de/kel-2/','Platz für dein Feedback'),(73,6,1,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(74,6,1,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein FeedbackPlatz für dein Feedback'),(75,6,1,4,2,1,'https://amazonas.fzi.de/kel-2/','Platz für dein Feedback'),(76,6,3,4,2,1,'https://amazonas.fzi.de/kel-2/','Platz für dein Feedback'),(77,6,5,4,2,1,'https://amazonas.fzi.de/kel-2/','Platz für dein Feedback'),(78,6,2,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(79,6,1,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(80,6,2,4,2,1,'https://amazonas.fzi.de/kel-2/','Platz für dein Feedbackhuuj'),(81,6,3,4,2,1,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(82,6,3,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(83,4,3,4,1,2,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(84,4,0,4,1,3,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(85,4,1,4,1,4,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(86,4,4,4,1,4,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(87,20,18,4,1,1,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedbacktest'),(88,6,3,3,2,3,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','test'),(89,6,1,3,2,3,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','test'),(90,6,3,3,3,3,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','test'),(91,20,10,4,1,1,'https://amazonas.fzi.de/kel-2/','Platz für dein Feedback'),(92,20,7,4,1,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(93,20,7,4,1,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(94,20,8,4,1,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(95,20,15,4,1,1,'https://amazonas.fzi.de/kel-2/','Platz für dein Feedback'),(96,20,8,4,1,1,'https://amazonas.fzi.de/kel-2/','Platz für dein Feedback'),(97,20,5,4,1,1,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(98,10,6,4,2,4,'https://amazonas.fzi.de/kel-2/','Platz für dein Feedback'),(99,20,12,4,1,1,'https://amazonas.fzi.de/kel-1/','10/10 would do again'),(100,20,15,4,1,1,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(101,4,4,2,2,1,'https://amazonas.fzi.de/kel-2/','Test'),(102,4,4,2,4,4,'https://amazonas.fzi.de/kel-1/','Das ist mien Feedback '),(103,4,4,2,4,4,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Klappt es endlich?'),(104,4,4,2,4,4,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Klappt es endlich?'),(105,4,4,2,4,4,'https://amazonas.fzi.de/kel-1/','test mit komma'),(106,4,4,2,4,4,'https://amazonas.fzi.de/kel-1/','und was  ist mit komma am ende'),(107,20,7,4,1,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(108,10,4,4,1,1,'https://amazonas.fzi.de/kel-2/','Platz für dein Feedback'),(109,10,1,4,1,1,'eigenes Wiki hier eintragen','Platz für dein Feedback'),(110,4,2,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz fr dein Feedback'),(111,4,3,4,2,1,'https://amazonas.fzi.de/kel-2/','Platz fr dein Feedback'),(112,4,2,4,2,1,'https://amazonas.fzi.de/kel-1/','Platz fr dein Feedback'),(113,4,0,4,2,1,'https://amazonas.fzi.de/kel-1/','Platz fr dein Feedback'),(114,20,18,3,2,2,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(115,10,0,4,1,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','ich nix kapiere'),(116,10,7,4,1,1,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(117,4,2,2,4,4,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(118,4,2,2,4,4,'https://amazonas.fzi.de/kel-1/','feeeeedback'),(119,10,4,4,1,1,'https://amazonas.fzi.de/kel-2/','Platz für dein Feedback'),(120,10,1,4,3,2,'https://amazonas.fzi.de/kel-1/','Platz für dein Feedback'),(121,10,2,4,4,4,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(122,10,2,4,4,4,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein FeedbackPlatz für dein Feedback'),(123,10,2,4,4,4,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein FeedbackPlatz für dein FeedbackPlatz für dein Feedback'),(124,10,5,4,4,4,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','Platz für dein Feedback'),(125,4,2,4,2,1,'http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/','vorfuehrung'),(126,4,1,4,2,1,'https://amazonas.fzi.de/kel-1/','Platz fr dein Feedback');
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

-- Dump completed on 2017-02-18 15:02:13
