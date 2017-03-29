-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cit345groupproject
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `AccountID` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerID` int(11) NOT NULL,
  `UserName` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`AccountID`),
  KEY `CustomerID_idx` (`CustomerID`),
  CONSTRAINT `CustomerID` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1002,2,'salexander1','qrrUXH'),(1003,3,'klopez2','TQMkWf'),(1004,4,'msanders3','WKXv22'),(1005,5,'jmcdonald4','gxyYgkPY6Fx1'),(1006,6,'rbutler5','6Wh9YY1nK'),(1007,7,'ecarroll6','X5SkWF'),(1008,8,'lmedina7','HCYoXkRbnmpY'),(1009,9,'rjames8','7hHwjE'),(1010,10,'ccampbell9','zlLR4fBj4ZD');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chargehistory`
--

DROP TABLE IF EXISTS `chargehistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chargehistory` (
  `CustomerID` int(11) NOT NULL,
  `ShipmentID` int(11) NOT NULL,
  `DatePaid` datetime NOT NULL,
  `TotalPrice` double NOT NULL,
  `CreditCardID` int(16) NOT NULL,
  PRIMARY KEY (`CustomerID`,`ShipmentID`),
  KEY `ShipmentIDFK_idx` (`ShipmentID`),
  CONSTRAINT `CustomerIDFK ` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ShipmentIDFK` FOREIGN KEY (`ShipmentID`) REFERENCES `shipment` (`ShipmentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chargehistory`
--

LOCK TABLES `chargehistory` WRITE;
/*!40000 ALTER TABLE `chargehistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `chargehistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract` (
  `ContractNumber` int(11) NOT NULL AUTO_INCREMENT,
  `AccountNumber` int(11) NOT NULL,
  `ContractTier` enum('Bronze','Silver','Gold') NOT NULL,
  `StartDate` datetime NOT NULL,
  `EndDate` datetime NOT NULL,
  PRIMARY KEY (`ContractNumber`),
  KEY `AccountNumberFK_idx` (`AccountNumber`),
  KEY `TierFK_idx` (`ContractTier`),
  KEY `AccountNumberFKcontract_idx` (`AccountNumber`),
  KEY `TierFKcontract_idx` (`ContractTier`),
  CONSTRAINT `AccountFK` FOREIGN KEY (`AccountNumber`) REFERENCES `account` (`AccountID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `TierFK` FOREIGN KEY (`ContractTier`) REFERENCES `contracttype` (`Teir`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (3,1002,'Silver','2017-03-28 00:00:00','2018-03-28 00:00:00'),(4,1003,'Bronze','2017-03-28 00:00:00','2018-03-28 00:00:00'),(5,1004,'Silver','2017-03-28 00:00:00','2018-03-28 00:00:00'),(6,1005,'Silver','2017-03-28 00:00:00','2018-03-28 00:00:00'),(7,1006,'Bronze','2017-03-28 00:00:00','2018-03-28 00:00:00'),(8,1007,'Gold','2017-03-28 00:00:00','2018-03-28 00:00:00'),(9,1008,'Silver','2017-03-28 00:00:00','2018-03-28 00:00:00'),(10,1009,'Bronze','2017-03-28 00:00:00','2018-03-28 00:00:00'),(11,1010,'Silver','2017-03-28 00:00:00','2018-03-28 00:00:00');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contracttype`
--

DROP TABLE IF EXISTS `contracttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contracttype` (
  `Teir` enum('Bronze','Silver','Gold') NOT NULL,
  `Price` double NOT NULL,
  `Discount` int(11) NOT NULL,
  PRIMARY KEY (`Teir`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contracttype`
--

LOCK TABLES `contracttype` WRITE;
/*!40000 ALTER TABLE `contracttype` DISABLE KEYS */;
INSERT INTO `contracttype` VALUES ('Bronze',50,10),('Silver',100,15),('Gold',200,25);
/*!40000 ALTER TABLE `contracttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `PhoneNumber` varchar(45) NOT NULL,
  `State` varchar(45) NOT NULL,
  `Street` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `Zip` int(11) NOT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Jason','Edwards','jedwards0@google.ca','1-(814)917-5577','Pennsylvania','7 Arkansas Street','Erie',16550),(2,'Fred','Robertson','frobertson1@who.int','1-(714)572-4576','California','179 Browning Way','Santa Ana',92725),(3,'Juan','Greene','jgreene2@mozilla.com','1-(337)802-7457','Louisiana','5505 Canary Parkway','Lake Charles',70607),(4,'Lillian','Lawson','llawson3@godaddy.com','1-(804)246-3685','Virginia','2374 Ryan Place','Richmond',23293),(5,'Maria','Romero','mromero4@webmd.com','1-(508)601-8492','Massachusetts','65964 Packers Terrace','Brockton',2405),(6,'George','Bowman','gbowman5@github.io','1-(903)920-2752','Texas','6394 Northridge Hill','Tyler',75710),(7,'Randy','Wells','rwells6@nytimes.com','1-(602)709-0377','Arizona','3 Rowland Park','Scottsdale',85260),(8,'Peter','Frazier','pfrazier7@joomla.org','1-(808)104-7131','Hawaii','969 Crowley Way','Honolulu',96820),(9,'Maria','Thomas','mthomas8@squidoo.com','1-(952)233-1563','Minnesota','2 Utah Plaza','Maple Plain',55579),(10,'Martin','Mason','mmason9@pbs.org','1-(317)227-1154','Indiana','26944 Annamark Crossing','Indianapolis',46231);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `declarationform`
--

DROP TABLE IF EXISTS `declarationform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `declarationform` (
  `FormID` int(11) NOT NULL AUTO_INCREMENT,
  `PackageID` int(11) NOT NULL,
  `Contents` varchar(45) NOT NULL,
  `Value` double NOT NULL,
  PRIMARY KEY (`FormID`),
  KEY `ShipmentIDDF_idx` (`PackageID`),
  CONSTRAINT `PackageIDDF` FOREIGN KEY (`PackageID`) REFERENCES `packages` (`packageID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `declarationform`
--

LOCK TABLES `declarationform` WRITE;
/*!40000 ALTER TABLE `declarationform` DISABLE KEYS */;
INSERT INTO `declarationform` VALUES (1,1,'Baby',53.46),(2,2,'Automotive',4.63),(3,3,'Books',86.49),(4,4,'Jewelery',11.73),(5,5,'Games',12),(6,6,'Shoes',21.84),(7,7,'Industrial',46.51),(8,8,'Toys',57.97),(9,9,'Beauty',88.58),(10,10,'Kids',69.43),(11,11,'Jewelery',40.36),(12,12,'Tools',88.4),(13,13,'Music',81.05),(14,14,'Electronics',74.74),(15,15,'Computers',16.21),(16,16,'Kids',47.96),(17,17,'Computers',83.49),(18,18,'Health',55.47),(19,19,'Clothing',53.81),(20,20,'Baby',78.32),(21,21,'Clothing',71.3),(22,22,'Kids',58.69),(23,23,'Clothing',17.12),(24,24,'Outdoors',97.08),(25,25,'Games',84.56),(26,26,'Books',19.26),(27,27,'Games',48.38),(28,28,'Electronics',14.93),(29,29,'Movies',35.43),(30,30,'Jewelery',1.8),(31,31,'Electronics',86.95),(32,32,'Toys',5.15),(33,33,'Industrial',89.36),(34,34,'Garden',28.35),(35,35,'Kids',40.65),(36,36,'Home',30.25),(37,37,'Toys',53.63),(38,38,'Health',92.6),(39,39,'Books',89.66),(40,40,'Kids',48.01),(41,41,'Grocery',48.01),(42,42,'Beauty',64.73),(43,43,'Computers',9.51),(44,44,'Garden',81.46),(45,45,'Health',13.58),(46,46,'Jewelery',85.58),(47,47,'Computers',76.45),(48,48,'Jewelery',36.8),(49,49,'Toys',79.2),(50,50,'Jewelery',23.52),(51,51,'Automotive',45.65),(52,52,'Grocery',38.62),(53,53,'Books',97.01),(54,54,'Garden',45.46),(55,55,'Sports',4.47),(56,56,'Home',84.98),(57,57,'Kids',26.53),(58,58,'Music',42.43),(59,59,'Outdoors',88.67),(60,60,'Electronics',80.96),(61,61,'Industrial',6.77),(62,62,'Sports',7.96),(63,63,'Movies',46.23),(64,64,'Books',94.74),(65,65,'Beauty',52.52),(66,66,'Kids',77.93),(67,67,'Music',96.95),(68,68,'Movies',73.31),(69,69,'Industrial',55.32),(70,70,'Outdoors',35.82),(71,71,'Computers',30.81),(72,72,'Tools',70.44),(73,73,'Garden',14.85),(74,74,'Tools',49.23),(75,75,'Books',56.36),(76,76,'Home',94.05),(77,77,'Health',64.94),(78,78,'Outdoors',14.82),(79,79,'Automotive',5.49),(80,80,'Beauty',2.99),(81,81,'Health',60.34),(82,82,'Games',87.5),(83,83,'Industrial',19.62),(84,84,'Computers',86.99),(85,85,'Shoes',15.8),(86,86,'Kids',15.24),(87,87,'Garden',70.09),(88,88,'Games',32.67),(89,89,'Garden',83.22),(90,90,'Health',55.76),(91,91,'Shoes',62.46),(92,92,'Shoes',87.38),(93,93,'Kids',53.9),(94,94,'Shoes',78.18),(95,95,'Books',56.28),(96,96,'Grocery',8.16),(97,97,'Shoes',97.84),(98,98,'Industrial',62.08),(99,99,'Health',44.73),(100,100,'Jewelery',62.31),(101,101,'Baby',24.93),(102,102,'Home',16.87),(103,103,'Outdoors',56.07),(104,104,'Movies',89.53),(105,105,'Home',52.45),(106,106,'Grocery',79.59),(107,107,'Kids',26.48),(108,108,'Movies',73.47),(109,109,'Sports',30.1),(110,110,'Shoes',98.78),(111,111,'Movies',43.09),(112,112,'Electronics',5.1),(113,113,'Industrial',31.47),(114,114,'Baby',47.65),(115,115,'Industrial',93.31),(116,116,'Outdoors',44.73),(117,117,'Clothing',73.53),(118,118,'Shoes',43.95),(119,119,'Clothing',53.83),(120,120,'Movies',78.31),(121,121,'Industrial',99.12),(122,122,'Health',11.98),(123,123,'Sports',6.8),(124,124,'Books',82.3),(125,125,'Outdoors',23.19),(126,126,'Health',43.53),(127,127,'Beauty',79.26),(128,128,'Books',5.62),(129,129,'Health',58.45),(130,130,'Clothing',3.68),(131,131,'Beauty',98.11),(132,132,'Outdoors',88.57),(133,133,'Clothing',48.82),(134,134,'Garden',62.02),(135,135,'Baby',23.97),(136,136,'Computers',95.88),(137,137,'Tools',79.52),(138,138,'Sports',37.94),(139,139,'Garden',98.33),(140,140,'Jewelery',87.64),(141,141,'Grocery',23.23),(142,142,'Industrial',77.56),(143,143,'Sports',53.04),(144,144,'Books',1.58),(145,145,'Garden',45.5),(146,146,'Industrial',20.08),(147,147,'Music',67.4),(148,148,'Baby',63.92),(149,149,'Automotive',2.73),(150,150,'Home',20.84),(151,151,'Music',98.91),(152,152,'Grocery',47.42),(153,153,'Electronics',91.32),(154,154,'Tools',11.71),(155,155,'Clothing',79.89),(156,156,'Games',32.27),(157,157,'Games',74.52),(158,158,'Industrial',84.7),(159,159,'Home',74.23),(160,160,'Games',39.27),(161,161,'Baby',86.25),(162,162,'Industrial',86.32),(163,163,'Industrial',16.77),(164,164,'Shoes',18.14),(165,165,'Computers',20.02),(166,166,'Automotive',78.99),(167,167,'Garden',93.2),(168,168,'Clothing',67.41),(169,169,'Shoes',8.77),(170,170,'Home',31.09),(171,171,'Health',14.05),(172,172,'Home',11.17),(173,173,'Electronics',78.17),(174,174,'Electronics',63.51),(175,175,'Sports',1.08),(176,176,'Sports',92.35),(177,177,'Sports',81.61),(178,178,'Jewelery',20.58),(179,179,'Books',21.51),(180,180,'Books',70.08),(181,181,'Clothing',95.5),(182,182,'Garden',17.49),(183,183,'Grocery',30.23),(184,184,'Music',23.52),(185,185,'Computers',82.98),(186,186,'Shoes',38.04),(187,187,'Music',48.82),(188,188,'Grocery',39.14),(189,189,'Games',35.28),(190,190,'Tools',46.62),(191,191,'Electronics',49.34),(192,192,'Outdoors',83.3),(193,193,'Sports',15.91),(194,194,'Garden',28.2),(195,195,'Beauty',0.32),(196,196,'Music',32.87),(197,197,'Games',81.72),(198,198,'Garden',50.88),(199,199,'Music',33.89),(200,200,'Music',74.5);
/*!40000 ALTER TABLE `declarationform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packages`
--

DROP TABLE IF EXISTS `packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `packages` (
  `packageID` int(11) NOT NULL AUTO_INCREMENT,
  `shipmentID` int(11) NOT NULL,
  `Dimensions` varchar(45) NOT NULL,
  `Weight` double NOT NULL,
  `Fragile` enum('Yes','No') NOT NULL,
  `Hazardous` enum('Yes','No') NOT NULL,
  PRIMARY KEY (`packageID`),
  KEY `packageShipmentIdFK_idx` (`shipmentID`),
  CONSTRAINT `packageShipmentIdFK` FOREIGN KEY (`shipmentID`) REFERENCES `shipment` (`ShipmentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packages`
--

LOCK TABLES `packages` WRITE;
/*!40000 ALTER TABLE `packages` DISABLE KEYS */;
INSERT INTO `packages` VALUES (1,1,'3 x 6 x 9',62,'No','Yes'),(2,2,'12 x 12 x 11',67,'No','Yes'),(3,3,'8 x 11 x 11',55,'No','Yes'),(4,4,'11 x 5 x 3',79,'No','No'),(5,5,'6 x 7 x 4',53,'No','Yes'),(6,6,'4 x 9 x 12',29,'Yes','No'),(7,7,'9 x 12 x 1',50,'Yes','Yes'),(8,8,'1 x 7 x 3',92,'No','Yes'),(9,9,'5 x 7 x 4',27,'No','Yes'),(10,10,'9 x 8 x 2',59,'No','Yes'),(11,11,'9 x 2 x 12',76,'Yes','Yes'),(12,12,'2 x 7 x 1',83,'Yes','No'),(13,13,'7 x 5 x 9',49,'Yes','No'),(14,14,'7 x 4 x 8',57,'No','No'),(15,15,'2 x 8 x 5',21,'No','Yes'),(16,16,'12 x 6 x 8',88,'Yes','Yes'),(17,17,'4 x 4 x 2',7,'No','No'),(18,18,'3 x 4 x 3',98,'No','No'),(19,19,'5 x 2 x 1',63,'Yes','No'),(20,20,'12 x 10 x 2',50,'Yes','Yes'),(21,21,'3 x 6 x 12',18,'Yes','No'),(22,22,'5 x 9 x 10',7,'Yes','No'),(23,23,'2 x 8 x 2',67,'Yes','Yes'),(24,24,'6 x 1 x 8',23,'Yes','No'),(25,25,'11 x 7 x 11',85,'No','Yes'),(26,26,'9 x 10 x 5',30,'Yes','Yes'),(27,27,'6 x 12 x 10',68,'Yes','Yes'),(28,28,'9 x 6 x 2',11,'Yes','No'),(29,29,'3 x 6 x 12',75,'No','No'),(30,30,'10 x 12 x 7',31,'Yes','Yes'),(31,31,'12 x 12 x 7',40,'No','Yes'),(32,32,'9 x 4 x 9',36,'No','Yes'),(33,33,'11 x 4 x 4',73,'No','No'),(34,34,'8 x 3 x 8',57,'No','Yes'),(35,35,'9 x 1 x 5',84,'Yes','No'),(36,36,'12 x 11 x 5',6,'No','Yes'),(37,37,'3 x 3 x 1',51,'No','Yes'),(38,38,'10 x 2 x 8',70,'Yes','Yes'),(39,39,'8 x 3 x 3',71,'No','Yes'),(40,40,'3 x 12 x 8',93,'No','Yes'),(41,41,'1 x 5 x 10',23,'No','No'),(42,42,'10 x 4 x 3',63,'Yes','Yes'),(43,43,'5 x 11 x 2',94,'No','No'),(44,44,'9 x 7 x 4',75,'Yes','No'),(45,45,'3 x 5 x 1',93,'No','Yes'),(46,46,'9 x 11 x 8',95,'Yes','Yes'),(47,47,'8 x 1 x 12',34,'No','Yes'),(48,48,'11 x 12 x 2',92,'Yes','Yes'),(49,49,'7 x 1 x 3',9,'Yes','No'),(50,50,'6 x 3 x 8',15,'Yes','No'),(51,51,'10 x 5 x 10',54,'Yes','Yes'),(52,52,'12 x 12 x 3',58,'No','No'),(53,53,'11 x 4 x 10',44,'Yes','Yes'),(54,54,'10 x 8 x 11',65,'No','Yes'),(55,55,'1 x 7 x 1',12,'Yes','Yes'),(56,56,'3 x 1 x 5',79,'Yes','Yes'),(57,57,'12 x 2 x 2',19,'Yes','No'),(58,58,'10 x 4 x 1',42,'Yes','No'),(59,59,'9 x 2 x 9',95,'No','No'),(60,60,'11 x 4 x 6',11,'No','Yes'),(61,61,'1 x 12 x 10',79,'No','Yes'),(62,62,'4 x 12 x 11',17,'No','No'),(63,63,'7 x 1 x 12',23,'No','Yes'),(64,64,'9 x 3 x 9',59,'No','No'),(65,65,'9 x 2 x 7',61,'Yes','Yes'),(66,66,'2 x 9 x 10',31,'Yes','No'),(67,67,'4 x 8 x 6',62,'Yes','Yes'),(68,68,'9 x 6 x 12',54,'No','No'),(69,69,'1 x 3 x 1',93,'Yes','Yes'),(70,70,'3 x 10 x 11',1,'Yes','Yes'),(71,71,'2 x 10 x 4',25,'No','No'),(72,72,'10 x 8 x 8',97,'Yes','No'),(73,73,'8 x 10 x 5',80,'Yes','Yes'),(74,74,'4 x 1 x 5',45,'Yes','No'),(75,75,'6 x 7 x 1',29,'No','No'),(76,76,'7 x 1 x 4',86,'No','Yes'),(77,77,'5 x 3 x 3',87,'Yes','Yes'),(78,78,'9 x 7 x 9',61,'No','Yes'),(79,79,'11 x 3 x 3',14,'Yes','No'),(80,80,'8 x 4 x 2',23,'No','Yes'),(81,81,'6 x 5 x 1',42,'No','Yes'),(82,82,'5 x 3 x 11',71,'No','No'),(83,83,'5 x 9 x 7',68,'Yes','Yes'),(84,84,'3 x 10 x 5',53,'Yes','No'),(85,85,'10 x 3 x 9',34,'No','Yes'),(86,86,'5 x 12 x 11',74,'No','No'),(87,87,'12 x 6 x 5',95,'Yes','No'),(88,88,'10 x 10 x 2',5,'No','Yes'),(89,89,'10 x 6 x 4',91,'Yes','Yes'),(90,90,'7 x 1 x 6',62,'Yes','Yes'),(91,91,'3 x 6 x 2',42,'No','No'),(92,92,'6 x 7 x 3',44,'No','No'),(93,93,'12 x 6 x 3',53,'Yes','No'),(94,94,'7 x 6 x 8',25,'No','Yes'),(95,95,'3 x 12 x 1',47,'No','No'),(96,96,'11 x 3 x 8',6,'No','Yes'),(97,97,'3 x 5 x 2',31,'No','No'),(98,98,'12 x 7 x 5',41,'Yes','Yes'),(99,99,'7 x 9 x 4',48,'No','No'),(100,100,'6 x 9 x 1',37,'Yes','Yes'),(101,1,'3 x 6 x 9',62,'No','Yes'),(102,2,'12 x 12 x 11',67,'No','Yes'),(103,3,'8 x 11 x 11',55,'No','Yes'),(104,4,'11 x 5 x 3',79,'No','No'),(105,5,'6 x 7 x 4',53,'No','Yes'),(106,6,'4 x 9 x 12',29,'Yes','No'),(107,7,'9 x 12 x 1',50,'Yes','Yes'),(108,8,'1 x 7 x 3',92,'No','Yes'),(109,9,'5 x 7 x 4',27,'No','Yes'),(110,10,'9 x 8 x 2',59,'No','Yes'),(111,11,'9 x 2 x 12',76,'Yes','Yes'),(112,12,'2 x 7 x 1',83,'Yes','No'),(113,13,'7 x 5 x 9',49,'Yes','No'),(114,14,'7 x 4 x 8',57,'No','No'),(115,15,'2 x 8 x 5',21,'No','Yes'),(116,16,'12 x 6 x 8',88,'Yes','Yes'),(117,17,'4 x 4 x 2',7,'No','No'),(118,18,'3 x 4 x 3',98,'No','No'),(119,19,'5 x 2 x 1',63,'Yes','No'),(120,20,'12 x 10 x 2',50,'Yes','Yes'),(121,21,'3 x 6 x 12',18,'Yes','No'),(122,22,'5 x 9 x 10',7,'Yes','No'),(123,23,'2 x 8 x 2',67,'Yes','Yes'),(124,24,'6 x 1 x 8',23,'Yes','No'),(125,25,'11 x 7 x 11',85,'No','Yes'),(126,26,'9 x 10 x 5',30,'Yes','Yes'),(127,27,'6 x 12 x 10',68,'Yes','Yes'),(128,28,'9 x 6 x 2',11,'Yes','No'),(129,29,'3 x 6 x 12',75,'No','No'),(130,30,'10 x 12 x 7',31,'Yes','Yes'),(131,31,'12 x 12 x 7',40,'No','Yes'),(132,32,'9 x 4 x 9',36,'No','Yes'),(133,33,'11 x 4 x 4',73,'No','No'),(134,34,'8 x 3 x 8',57,'No','Yes'),(135,35,'9 x 1 x 5',84,'Yes','No'),(136,36,'12 x 11 x 5',6,'No','Yes'),(137,37,'3 x 3 x 1',51,'No','Yes'),(138,38,'10 x 2 x 8',70,'Yes','Yes'),(139,39,'8 x 3 x 3',71,'No','Yes'),(140,40,'3 x 12 x 8',93,'No','Yes'),(141,41,'1 x 5 x 10',23,'No','No'),(142,42,'10 x 4 x 3',63,'Yes','Yes'),(143,43,'5 x 11 x 2',94,'No','No'),(144,44,'9 x 7 x 4',75,'Yes','No'),(145,45,'3 x 5 x 1',93,'No','Yes'),(146,46,'9 x 11 x 8',95,'Yes','Yes'),(147,47,'8 x 1 x 12',34,'No','Yes'),(148,48,'11 x 12 x 2',92,'Yes','Yes'),(149,49,'7 x 1 x 3',9,'Yes','No'),(150,50,'6 x 3 x 8',15,'Yes','No'),(151,51,'10 x 5 x 10',54,'Yes','Yes'),(152,52,'12 x 12 x 3',58,'No','No'),(153,53,'11 x 4 x 10',44,'Yes','Yes'),(154,54,'10 x 8 x 11',65,'No','Yes'),(155,55,'1 x 7 x 1',12,'Yes','Yes'),(156,56,'3 x 1 x 5',79,'Yes','Yes'),(157,57,'12 x 2 x 2',19,'Yes','No'),(158,58,'10 x 4 x 1',42,'Yes','No'),(159,59,'9 x 2 x 9',95,'No','No'),(160,60,'11 x 4 x 6',11,'No','Yes'),(161,61,'1 x 12 x 10',79,'No','Yes'),(162,62,'4 x 12 x 11',17,'No','No'),(163,63,'7 x 1 x 12',23,'No','Yes'),(164,64,'9 x 3 x 9',59,'No','No'),(165,65,'9 x 2 x 7',61,'Yes','Yes'),(166,66,'2 x 9 x 10',31,'Yes','No'),(167,67,'4 x 8 x 6',62,'Yes','Yes'),(168,68,'9 x 6 x 12',54,'No','No'),(169,69,'1 x 3 x 1',93,'Yes','Yes'),(170,70,'3 x 10 x 11',1,'Yes','Yes'),(171,71,'2 x 10 x 4',25,'No','No'),(172,72,'10 x 8 x 8',97,'Yes','No'),(173,73,'8 x 10 x 5',80,'Yes','Yes'),(174,74,'4 x 1 x 5',45,'Yes','No'),(175,75,'6 x 7 x 1',29,'No','No'),(176,76,'7 x 1 x 4',86,'No','Yes'),(177,77,'5 x 3 x 3',87,'Yes','Yes'),(178,78,'9 x 7 x 9',61,'No','Yes'),(179,79,'11 x 3 x 3',14,'Yes','No'),(180,80,'8 x 4 x 2',23,'No','Yes'),(181,81,'6 x 5 x 1',42,'No','Yes'),(182,82,'5 x 3 x 11',71,'No','No'),(183,83,'5 x 9 x 7',68,'Yes','Yes'),(184,84,'3 x 10 x 5',53,'Yes','No'),(185,85,'10 x 3 x 9',34,'No','Yes'),(186,86,'5 x 12 x 11',74,'No','No'),(187,87,'12 x 6 x 5',95,'Yes','No'),(188,88,'10 x 10 x 2',5,'No','Yes'),(189,89,'10 x 6 x 4',91,'Yes','Yes'),(190,90,'7 x 1 x 6',62,'Yes','Yes'),(191,91,'3 x 6 x 2',42,'No','No'),(192,92,'6 x 7 x 3',44,'No','No'),(193,93,'12 x 6 x 3',53,'Yes','No'),(194,94,'7 x 6 x 8',25,'No','Yes'),(195,95,'3 x 12 x 1',47,'No','No'),(196,96,'11 x 3 x 8',6,'No','Yes'),(197,97,'3 x 5 x 2',31,'No','No'),(198,98,'12 x 7 x 5',41,'Yes','Yes'),(199,99,'7 x 9 x 4',48,'No','No'),(200,100,'6 x 9 x 1',37,'Yes','Yes');
/*!40000 ALTER TABLE `packages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payments` (
  `AccoutNumber` int(11) NOT NULL,
  `ShipmentID` int(11) NOT NULL,
  `DueDate` datetime NOT NULL,
  `AmountDue` double NOT NULL,
  `DatePaid` datetime NOT NULL,
  `paymentscol` varchar(45) NOT NULL,
  PRIMARY KEY (`AccoutNumber`,`ShipmentID`),
  KEY `ShipmentID_idx` (`ShipmentID`),
  CONSTRAINT `AcountNumFK` FOREIGN KEY (`AccoutNumber`) REFERENCES `account` (`AccountID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ShipmentID` FOREIGN KEY (`ShipmentID`) REFERENCES `shipment` (`ShipmentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipment`
--

DROP TABLE IF EXISTS `shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment` (
  `ShipmentID` int(11) NOT NULL AUTO_INCREMENT,
  `ShipCustomerID` int(11) NOT NULL,
  `StoreID` int(11) NOT NULL,
  `ShipMethod` int(11) NOT NULL,
  `Street` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `State` varchar(45) NOT NULL,
  `Zip` int(11) NOT NULL,
  `ExpectedDelivery` datetime NOT NULL,
  `ShipmentDate` datetime NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`ShipmentID`),
  KEY `CustomerID_idx` (`ShipCustomerID`),
  KEY `CustomerID` (`ShipCustomerID`),
  KEY `StoreID_idx` (`StoreID`),
  KEY `ShipmentMethodFK_idx` (`ShipMethod`),
  CONSTRAINT `ShipCustomerID` FOREIGN KEY (`ShipCustomerID`) REFERENCES `customer` (`CustomerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ShipmentMethodFK` FOREIGN KEY (`ShipMethod`) REFERENCES `shipmentmethod` (`ShipmentMethodID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `StoreID` FOREIGN KEY (`StoreID`) REFERENCES `store` (`StoreID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment`
--

LOCK TABLES `shipment` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
INSERT INTO `shipment` VALUES (1,8,8,6000,'2241 Prentice Parkway','Nashville','Tennessee',37215,'2016-05-30 06:50:13','2017-03-07 21:54:22',10.5),(2,1,9,5100,'27003 Sachtjen Alley','Amarillo','Texas',79116,'2016-11-05 07:35:09','2017-03-07 21:43:39',58.59),(3,3,7,6101,'6 Cherokee Way','Lancaster','Pennsylvania',17622,'2016-07-18 18:10:34','2017-03-09 22:34:41',55.45),(4,5,8,5100,'6756 Prairie Rose Point','Nashville','Tennessee',37220,'2016-05-31 13:26:47','2017-03-09 23:43:10',5.01),(5,9,4,5100,'0 Shoshone Way','Ann Arbor','Michigan',48107,'2017-02-13 13:34:33','2017-03-06 00:57:45',29.32),(6,2,8,6010,'551 Shopko Hill','Miami','Florida',33261,'2016-08-06 22:56:05','2017-03-09 01:32:53',57.01),(7,4,3,5010,'43666 Laurel Hill','Sioux Falls','South Dakota',57110,'2017-02-03 23:33:06','2017-03-07 12:35:12',93.53),(8,6,4,6001,'8 Springs Trail','Montgomery','Alabama',36104,'2016-07-24 04:52:36','2017-03-07 18:50:58',42.51),(9,10,1,4010,'49 Iowa Junction','Miami','Florida',33180,'2016-11-01 19:05:52','2017-03-07 17:08:19',60.27),(10,6,5,6010,'69 Moland Way','Columbus','Ohio',43231,'2016-08-14 10:58:50','2017-03-06 23:43:28',57.3),(11,9,3,5110,'7 Fair Oaks Center','Bethesda','Maryland',20816,'2016-10-14 09:07:35','2017-03-08 02:06:20',80.47),(12,8,4,4101,'08542 8th Alley','San Jose','California',95118,'2017-01-01 19:44:03','2017-03-06 05:01:15',81.31),(13,9,5,5100,'362 6th Avenue','Shawnee Mission','Kansas',66286,'2016-07-09 16:29:32','2017-03-06 18:06:08',38.57),(14,9,9,6011,'56 Daystar Alley','Charlotte','North Carolina',28210,'2017-01-27 00:19:30','2017-03-09 14:28:35',1.92),(15,8,6,5111,'1311 Loftsgordon Plaza','Louisville','Kentucky',40266,'2017-01-23 11:06:31','2017-03-06 03:00:27',39.05),(16,10,5,5010,'39 Kinsman Point','Los Angeles','California',90076,'2016-06-30 02:37:22','2017-03-06 15:19:41',39.95),(17,7,1,5000,'28 Village Road','Lancaster','Pennsylvania',17622,'2016-07-30 06:07:28','2017-03-08 00:49:42',78.46),(18,9,1,4011,'6 Lien Street','Fresno','California',93709,'2016-09-05 02:27:15','2017-03-09 21:24:58',91.02),(19,5,7,4010,'5 Katie Way','Van Nuys','California',91411,'2017-01-20 13:31:14','2017-03-08 12:14:44',69.36),(20,7,10,6011,'31 Bluejay Drive','Duluth','Georgia',30195,'2017-02-17 02:59:22','2017-03-08 13:15:04',33.49),(21,9,5,5111,'4459 Acker Alley','Saint Louis','Missouri',63158,'2016-05-02 09:36:51','2017-03-06 17:18:16',75.66),(22,4,7,6110,'2 Esker Crossing','Hartford','Connecticut',6120,'2016-12-21 14:51:27','2017-03-09 17:47:59',6.58),(23,4,1,6010,'552 Florence Parkway','Washington','District of Columbia',20067,'2016-07-04 15:43:07','2017-03-06 21:19:37',77.52),(24,8,2,4110,'44460 Canary Alley','New York City','New York',10029,'2016-08-08 20:08:52','2017-03-06 08:39:27',63.44),(25,5,6,6011,'81348 Golf View Plaza','Columbus','Georgia',31998,'2016-10-13 09:00:02','2017-03-08 19:27:00',61.71),(26,9,10,4101,'2041 Miller Place','Pittsburgh','Pennsylvania',15230,'2016-12-08 13:53:17','2017-03-08 17:31:55',59.34),(27,9,5,5111,'633 Brown Alley','Omaha','Nebraska',68144,'2017-02-09 22:29:49','2017-03-06 00:56:04',3.61),(28,5,10,4000,'67019 Bay Trail','New Hyde Park','New York',11044,'2016-12-31 10:44:08','2017-03-06 10:33:26',5.12),(29,3,8,4010,'87 Gina Terrace','Tucson','Arizona',85743,'2017-02-06 19:14:59','2017-03-07 10:58:53',60.32),(30,6,3,4011,'58545 Hanover Crossing','Miami','Florida',33190,'2016-03-25 01:09:53','2017-03-09 05:01:47',4.76),(31,9,2,4110,'359 Havey Drive','Houston','Texas',77095,'2016-09-25 10:57:28','2017-03-09 23:32:57',41.89),(32,1,9,6101,'74 Calypso Drive','Brooklyn','New York',11236,'2017-03-06 18:06:15','2017-03-09 07:13:52',23.5),(33,4,9,5100,'2153 Comanche Court','Peoria','Arizona',85383,'2016-09-06 02:51:16','2017-03-07 05:26:23',69.31),(34,3,10,6101,'2 Calypso Drive','Louisville','Kentucky',40205,'2016-07-21 02:51:38','2017-03-08 21:26:58',40.78),(35,2,4,4100,'303 Montana Road','Columbus','Georgia',31914,'2016-05-06 13:45:27','2017-03-06 17:33:46',12.62),(36,10,2,4110,'52 Hallows Junction','Saint Louis','Missouri',63126,'2016-11-05 12:34:58','2017-03-07 22:31:57',45.47),(37,8,7,5111,'0 Stone Corner Hill','Flushing','New York',11388,'2016-06-19 14:10:25','2017-03-08 05:00:35',81.44),(38,7,1,4101,'431 South Court','Chicago','Illinois',60663,'2016-04-05 06:04:00','2017-03-07 06:02:10',37.33),(39,5,3,6110,'839 Kinsman Way','Schenectady','New York',12325,'2017-01-16 14:18:08','2017-03-08 20:15:48',62.02),(40,8,4,5011,'320 Kennedy Circle','Charlotte','North Carolina',28247,'2016-05-09 22:45:46','2017-03-07 07:36:33',92.28),(41,7,5,4010,'5 Surrey Hill','Indianapolis','Indiana',46231,'2016-08-06 22:33:02','2017-03-08 12:07:45',72.21),(42,10,1,4011,'7442 Fallview Avenue','Kansas City','Missouri',64153,'2016-12-23 01:32:08','2017-03-07 20:09:55',53.12),(43,5,4,4011,'7806 Weeping Birch Alley','Brockton','Massachusetts',2405,'2016-12-19 22:17:35','2017-03-08 20:08:15',15.33),(44,4,7,6100,'774 International Pass','Harrisburg','Pennsylvania',17140,'2016-04-18 15:57:17','2017-03-07 01:13:34',59.26),(45,2,5,4100,'87469 Jana Center','Little Rock','Arkansas',72215,'2016-12-26 04:46:18','2017-03-09 14:24:36',78.13),(46,7,2,4101,'24 Eagle Crest Plaza','Las Vegas','Nevada',89193,'2016-09-05 02:30:29','2017-03-09 14:40:18',28.05),(47,2,10,6001,'588 Maryland Junction','San Luis Obispo','California',93407,'2016-09-25 13:08:18','2017-03-08 12:26:43',2.07),(48,6,1,4101,'5 Nevada Avenue','Providence','Rhode Island',2912,'2016-05-07 11:22:57','2017-03-09 21:59:43',50.38),(49,1,3,6001,'9 Burning Wood Crossing','Jackson','Mississippi',39204,'2016-09-04 09:43:25','2017-03-06 23:35:25',68.31),(50,8,5,6111,'70 Blackbird Drive','Oklahoma City','Oklahoma',73104,'2016-09-03 06:46:21','2017-03-06 00:57:21',38.83),(51,9,8,5110,'3464 Golf Course Place','San Antonio','Texas',78235,'2016-04-08 06:30:08','2017-03-06 05:16:43',31.08),(52,2,4,6001,'80 Parkside Park','Charleston','West Virginia',25313,'2016-09-10 17:55:51','2017-03-06 01:28:46',37.99),(53,3,5,4111,'67228 Kinsman Point','Philadelphia','Pennsylvania',19151,'2016-10-27 08:06:44','2017-03-08 23:36:35',57.89),(54,10,5,6101,'328 Hagan Hill','Washington','District of Columbia',20244,'2016-10-19 02:59:14','2017-03-09 23:43:23',16.59),(55,4,1,4111,'3 Lillian Circle','Raleigh','North Carolina',27658,'2016-05-14 02:46:13','2017-03-08 13:31:55',21.94),(56,2,5,5111,'021 Vahlen Center','Evansville','Indiana',47737,'2016-09-24 17:03:11','2017-03-09 18:10:33',69.7),(57,5,3,4000,'78535 Nevada Park','Beaumont','Texas',77713,'2016-03-24 04:24:57','2017-03-07 01:59:14',36.26),(58,10,1,4111,'03294 Division Lane','Corpus Christi','Texas',78475,'2016-08-28 23:29:56','2017-03-07 15:58:12',49.55),(59,1,5,6000,'7725 Lien Avenue','Albuquerque','New Mexico',87115,'2017-01-11 02:50:53','2017-03-08 20:18:51',82.55),(60,3,10,4011,'8657 Sunnyside Court','Great Neck','New York',11024,'2016-12-10 09:53:29','2017-03-08 15:58:48',64.52),(61,7,8,6100,'669 Algoma Crossing','Los Angeles','California',90071,'2016-10-10 05:34:17','2017-03-09 12:37:47',76.86),(62,7,5,5110,'39826 Kingsford Circle','Colorado Springs','Colorado',80930,'2016-04-18 12:27:49','2017-03-08 20:05:50',50.09),(63,5,2,6101,'369 Eastlawn Plaza','Hattiesburg','Mississippi',39404,'2016-07-11 17:59:17','2017-03-07 07:08:59',1.24),(64,3,7,5001,'454 West Way','San Diego','California',92115,'2016-07-04 09:33:31','2017-03-07 13:59:35',48.89),(65,9,5,6010,'3309 Eagan Lane','Portsmouth','Virginia',23705,'2016-11-08 16:21:04','2017-03-07 14:29:34',75.67),(66,3,6,4000,'74 Barby Park','Charlottesville','Virginia',22908,'2016-07-18 19:39:20','2017-03-09 11:21:57',34.1),(67,8,7,6110,'7117 Morrow Junction','Sacramento','California',94230,'2017-03-14 17:15:04','2017-03-08 19:50:41',8.89),(68,2,7,4010,'12119 Daystar Parkway','Lincoln','Nebraska',68517,'2016-11-04 05:43:33','2017-03-08 13:57:44',78.16),(69,6,9,5001,'844 Sugar Hill','Mansfield','Ohio',44905,'2016-06-30 00:26:46','2017-03-07 01:23:50',55.08),(70,2,4,5111,'21 Jenifer Parkway','Las Vegas','Nevada',89120,'2016-04-21 20:20:23','2017-03-06 03:33:48',64.62),(71,4,2,4001,'594 Fremont Junction','Sacramento','California',94250,'2017-03-03 04:35:01','2017-03-08 05:04:19',94.84),(72,10,2,4110,'044 Jay Park','Brooklyn','New York',11254,'2017-01-11 16:26:31','2017-03-07 12:19:15',49.22),(73,10,7,4100,'27866 Scofield Terrace','Pittsburgh','Pennsylvania',15220,'2017-01-26 17:34:31','2017-03-08 12:40:15',53.61),(74,8,4,5111,'9 Annamark Avenue','Clearwater','Florida',33758,'2016-10-20 21:36:54','2017-03-08 13:48:13',40.69),(75,2,9,4000,'42 Nelson Center','Birmingham','Alabama',35205,'2016-04-28 13:44:58','2017-03-08 01:18:29',52.17),(76,7,9,4010,'61362 Di Loreto Drive','New York City','New York',10155,'2016-11-15 07:02:38','2017-03-08 20:53:55',82.07),(77,10,8,6110,'074 Green Ridge Terrace','Long Beach','California',90810,'2016-09-25 16:49:53','2017-03-09 04:56:26',61.26),(78,3,2,5000,'24064 Oneill Park','Chula Vista','California',91913,'2016-09-16 03:45:05','2017-03-06 05:35:25',44.94),(79,7,5,6111,'890 Hanover Street','Huntington','West Virginia',25716,'2017-02-01 16:41:34','2017-03-07 12:02:23',94.07),(80,5,5,5111,'1 Graedel Plaza','Waterbury','Connecticut',6705,'2016-05-15 14:02:05','2017-03-06 05:11:23',27.18),(81,1,8,4011,'1 Elmside Parkway','Philadelphia','Pennsylvania',19136,'2016-12-01 18:15:58','2017-03-06 08:09:14',55.83),(82,10,6,6111,'2 Main Lane','Las Vegas','Nevada',89160,'2016-12-28 21:05:46','2017-03-06 02:18:09',63.72),(83,6,8,5010,'99 Canary Center','Greensboro','North Carolina',27415,'2017-01-05 00:48:48','2017-03-09 13:19:12',25.66),(84,4,8,6000,'8887 Anniversary Parkway','San Diego','California',92160,'2016-03-19 15:35:21','2017-03-06 18:13:17',89.01),(85,5,8,4010,'7 Tony Trail','Arlington','Texas',76016,'2016-10-24 11:16:35','2017-03-08 12:39:50',57),(86,8,1,5001,'5 Fairfield Street','Lawrenceville','Georgia',30045,'2017-02-17 23:11:14','2017-03-09 11:59:57',63.63),(87,7,7,5101,'4122 Hoard Terrace','Largo','Florida',33777,'2017-03-04 21:43:50','2017-03-06 19:17:16',92.14),(88,5,9,5100,'794 Pond Terrace','Roanoke','Virginia',24034,'2016-09-08 10:53:25','2017-03-09 12:32:45',36.48),(89,5,7,4001,'06511 Bashford Circle','Washington','District of Columbia',20268,'2016-06-04 15:20:27','2017-03-06 00:14:14',59.65),(90,9,7,6101,'5 Maple Wood Circle','El Paso','Texas',79977,'2016-10-04 14:48:53','2017-03-06 12:43:03',57.03),(91,10,1,6000,'5464 Hazelcrest Park','Washington','District of Columbia',20566,'2016-08-07 23:25:20','2017-03-08 15:56:51',31.73),(92,1,6,4011,'773 Chive Park','Boise','Idaho',83757,'2016-10-24 23:08:48','2017-03-09 06:07:00',9.68),(93,5,10,5011,'9 Rowland Terrace','Minneapolis','Minnesota',55480,'2017-01-08 13:55:13','2017-03-06 01:46:26',91.26),(94,5,2,5100,'3 Thompson Hill','Stamford','Connecticut',6912,'2016-04-20 21:18:19','2017-03-07 07:07:34',54.71),(95,9,5,6111,'6093 Hermina Lane','Louisville','Kentucky',40298,'2016-09-07 21:48:48','2017-03-08 12:25:36',21.08),(96,1,6,5000,'8494 Rusk Pass','Tulsa','Oklahoma',74116,'2016-08-27 07:43:21','2017-03-06 04:54:30',53.49),(97,3,7,4000,'65218 Michigan Plaza','Spartanburg','South Carolina',29319,'2016-12-28 19:58:24','2017-03-08 04:29:16',50.21),(98,3,1,6011,'29 Forest Drive','Brea','California',92822,'2016-03-27 12:58:15','2017-03-06 10:53:59',9.87),(99,9,4,5001,'15216 Cascade Pass','Boston','Massachusetts',2119,'2016-05-13 04:56:29','2017-03-08 15:39:39',48.46),(100,4,8,6000,'6 Barby Parkway','Duluth','Minnesota',55805,'2016-06-12 00:35:46','2017-03-06 10:45:22',31.44);
/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipmentmethod`
--

DROP TABLE IF EXISTS `shipmentmethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipmentmethod` (
  `ShipmentMethodID` int(11) NOT NULL,
  `Hazardous` enum('Yes','No') NOT NULL,
  `Oversized` enum('Yes','No') NOT NULL,
  `International` enum('Yes','No') NOT NULL,
  `Price` double NOT NULL,
  `Speed` enum('Overnight','Express','Regular') CHARACTER SET cp850 NOT NULL,
  PRIMARY KEY (`ShipmentMethodID`),
  UNIQUE KEY `ShipmentMethodID_UNIQUE` (`ShipmentMethodID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipmentmethod`
--

LOCK TABLES `shipmentmethod` WRITE;
/*!40000 ALTER TABLE `shipmentmethod` DISABLE KEYS */;
INSERT INTO `shipmentmethod` VALUES (4000,'No','No','No',30,'Overnight'),(4001,'Yes','No','No',32,'Overnight'),(4010,'No','Yes','No',32,'Overnight'),(4011,'Yes','Yes','No',34,'Overnight'),(4100,'No','No','Yes',32,'Overnight'),(4101,'Yes','No','Yes',34,'Overnight'),(4110,'No','Yes','Yes',34,'Overnight'),(4111,'Yes','Yes','Yes',36,'Overnight'),(5000,'No','No','No',20,'Express'),(5001,'Yes','No','No',22,'Express'),(5010,'No','Yes','No',22,'Express'),(5011,'Yes','Yes','No',24,'Express'),(5100,'No','No','Yes',22,'Express'),(5101,'Yes','No','Yes',24,'Express'),(5110,'No','Yes','Yes',24,'Express'),(5111,'Yes','Yes','Yes',26,'Express'),(6000,'No','No','No',10,'Regular'),(6001,'Yes','No','No',12,'Regular'),(6010,'No','Yes','No',12,'Regular'),(6011,'Yes','Yes','No',14,'Regular'),(6100,'No','No','Yes',12,'Regular'),(6101,'Yes','No','Yes',14,'Regular'),(6110,'No','Yes','Yes',14,'Regular'),(6111,'Yes','Yes','Yes',16,'Regular');
/*!40000 ALTER TABLE `shipmentmethod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store` (
  `StoreID` int(11) NOT NULL AUTO_INCREMENT,
  `PhoneNumber` varchar(45) NOT NULL,
  `Street` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `State` varchar(45) NOT NULL,
  `Zip` int(11) NOT NULL,
  PRIMARY KEY (`StoreID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,'1-(862)496-8299','9934 Scofield Avenue','Newark','New Jersey',7188),(2,'1-(315)965-9214','09 8th Way','Syracuse','New York',13217),(3,'1-(239)323-9486','0 Shelley Road','Naples','Florida',33963),(4,'1-(404)471-7681','03046 American Ash Terrace','Atlanta','Georgia',31132),(5,'1-(303)207-7154','91836 Loftsgordon Junction','Denver','Colorado',80299),(6,'1-(816)526-2211','9300 Autumn Leaf Terrace','Kansas City','Missouri',64179),(7,'1-(682)790-9981','0 Butterfield Place','Fort Worth','Texas',76178),(8,'1-(260)486-5414','3999 Del Mar Road','Fort Wayne','Indiana',46862),(9,'1-(214)477-4318','2 Vahlen Parkway','Dallas','Texas',75260),(10,'1-(724)635-7284','6748 Helena Avenue','New Castle','Pennsylvania',16107);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tracking`
--

DROP TABLE IF EXISTS `tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tracking` (
  `TrackingID` int(11) NOT NULL,
  `Date` datetime NOT NULL,
  `CurrentLocation` varchar(45) NOT NULL,
  `Status` varchar(45) NOT NULL,
  `CurrentMode` varchar(45) NOT NULL,
  PRIMARY KEY (`TrackingID`,`Date`),
  CONSTRAINT `TrackingIDFK` FOREIGN KEY (`TrackingID`) REFERENCES `shipment` (`ShipmentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tracking`
--

LOCK TABLES `tracking` WRITE;
/*!40000 ALTER TABLE `tracking` DISABLE KEYS */;
INSERT INTO `tracking` VALUES (1,'2016-11-23 00:58:47','Shangmofang','In Transit','Freight'),(2,'2016-09-08 21:03:27','Arroio do Meio','In Transit','Air'),(3,'2017-02-27 10:18:38','Usman’','In Transit','Rail'),(4,'2016-08-14 02:00:04','Chalon-sur-Saône','In Transit','Air'),(5,'2016-04-21 10:58:50','Jinchang','In Transit','Freight'),(6,'2016-11-13 18:39:30','Fundación','In Transit','Freight'),(7,'2016-12-24 21:16:46','Arāk','In Transit','Air'),(8,'2016-07-31 00:03:23','Shiyuetian','In Transit','Rail'),(9,'2016-08-26 10:12:33','Trondheim','In Transit','Air'),(10,'2016-08-31 17:05:39','Kičevo','In Transit','Air'),(11,'2016-03-29 23:36:02','Berezniki','In Transit','Freight'),(12,'2016-08-31 17:23:39','Bremen','In Transit','Air'),(13,'2016-08-22 05:09:14','Columbeira','In Transit','Rail'),(14,'2016-04-29 02:58:43','Surcubamba','In Transit','Freight'),(15,'2016-09-05 12:00:03','Oropéndolas','In Transit','Air'),(16,'2016-12-07 13:14:10','Yoro','In Transit','Freight'),(17,'2016-12-20 06:12:19','Brzączowice','In Transit','Air'),(18,'2017-02-10 01:01:54','Pereira','In Transit','Freight'),(19,'2016-06-09 22:59:17','Chahe','In Transit','Rail'),(20,'2017-01-02 22:35:11','Ljupina','In Transit','Freight'),(21,'2017-02-14 16:55:31','Huancheng','In Transit','Freight'),(22,'2016-05-02 05:24:50','Pasar','In Transit','Air'),(23,'2016-06-07 23:18:13','Macroom','In Transit','Rail'),(24,'2016-12-22 10:43:01','Vitry-sur-Seine','In Transit','Freight'),(25,'2017-02-25 08:04:19','Orito','In Transit','Freight'),(26,'2017-01-10 21:44:21','Moycullen','In Transit','Air'),(27,'2016-12-11 19:05:12','Odessa','In Transit','Rail'),(28,'2017-01-20 15:38:58','Anlu','In Transit','Freight'),(29,'2016-07-27 07:35:39','El Corozal','In Transit','Freight'),(30,'2016-07-27 07:39:57','Pashiya','In Transit','Rail'),(31,'2016-04-09 13:53:04','Kaiyun','In Transit','Air'),(32,'2016-08-10 10:00:04','Shitong','In Transit','Freight'),(33,'2017-03-12 03:07:13','Urzhar','In Transit','Rail'),(34,'2016-09-17 15:01:50','Machachi','In Transit','Rail'),(35,'2017-01-30 07:40:34','Vrané nad Vltavou','In Transit','Rail'),(36,'2016-11-23 04:35:33','Osasco','In Transit','Freight'),(37,'2017-02-24 15:12:59','Västerås','In Transit','Freight'),(38,'2016-06-14 13:04:20','Dobra','In Transit','Rail'),(39,'2016-04-03 10:52:01','São Paulo','In Transit','Freight'),(40,'2016-08-11 08:32:30','Serrinha','In Transit','Air'),(41,'2016-05-17 23:39:24','Biliri','In Transit','Freight'),(42,'2016-06-10 03:33:04','Pukhavichy','In Transit','Air'),(43,'2016-11-10 22:18:02','Pukë','In Transit','Rail'),(44,'2016-04-01 00:30:18','Alicia','In Transit','Freight'),(45,'2016-12-05 19:30:12','Ratenggoji','In Transit','Air'),(46,'2016-04-11 15:58:36','Arroyo Salado','In Transit','Rail'),(47,'2016-04-17 11:39:37','Berestechko','In Transit','Rail'),(48,'2016-12-06 21:27:27','Maïné Soroa','In Transit','Rail'),(49,'2016-07-01 22:54:29','Rumāh','In Transit','Air'),(50,'2016-10-23 05:33:11','Girón','In Transit','Air'),(51,'2016-07-14 21:11:15','Weston','In Transit','Air'),(52,'2016-12-30 03:36:33','Balekersukamaju','In Transit','Freight'),(53,'2016-08-27 13:20:00','Borovo','In Transit','Freight'),(54,'2016-07-24 16:32:32','Shimen','In Transit','Freight'),(55,'2017-02-01 20:51:51','Tembayangan Barat','In Transit','Freight'),(56,'2017-01-31 21:54:15','Gurbuki','In Transit','Rail'),(57,'2017-03-09 09:34:18','Tarakan','In Transit','Air'),(58,'2016-08-24 16:31:28','Santol','In Transit','Rail'),(59,'2016-06-24 03:32:50','Bayaguana','In Transit','Air'),(60,'2017-01-16 15:00:04','Villa Florida','In Transit','Freight'),(61,'2016-04-27 20:14:53','Saskylakh','In Transit','Air'),(62,'2016-12-14 03:29:25','Pryazha','In Transit','Air'),(63,'2016-04-02 14:55:00','Gaofeng','In Transit','Freight'),(64,'2016-08-30 20:07:52','Sabanagrande','In Transit','Freight'),(65,'2016-07-18 01:55:57','Monze','In Transit','Rail'),(66,'2017-03-08 00:31:26','Nepomuceno','In Transit','Air'),(67,'2016-08-29 03:50:48','Kyzyl-Kyya','In Transit','Rail'),(68,'2017-01-02 15:43:52','Jiuxian','In Transit','Freight'),(69,'2016-06-23 02:13:58','Kopychyntsi','In Transit','Air'),(70,'2016-12-04 14:46:27','Marathókampos','In Transit','Freight'),(71,'2017-03-04 19:52:45','Santa María de Caparo','In Transit','Rail'),(72,'2016-08-04 06:29:49','Chinameca','In Transit','Freight'),(73,'2016-10-10 17:25:31','San Pablo','In Transit','Air'),(74,'2016-11-10 10:19:14','Caohezhang','In Transit','Freight'),(75,'2017-02-16 07:42:34','Salinggara','In Transit','Freight'),(76,'2017-01-10 09:48:23','Heba','In Transit','Air'),(77,'2016-12-09 12:25:09','Shangrao','In Transit','Rail'),(78,'2017-01-18 03:39:07','Rossosh’','In Transit','Freight'),(79,'2016-09-20 08:03:48','Porecatu','In Transit','Freight'),(80,'2016-03-31 07:48:15','Metsamor','In Transit','Air'),(81,'2016-10-05 05:09:37','Souziqiu','In Transit','Freight'),(82,'2017-01-03 14:39:17','Esmeraldas','In Transit','Rail'),(83,'2016-10-29 00:07:32','Washington','In Transit','Freight'),(84,'2017-01-24 08:35:01','Dayr Sāmit','In Transit','Rail'),(85,'2016-06-21 10:57:57','Pagatan','In Transit','Rail'),(86,'2016-07-16 01:16:03','Saumur','In Transit','Rail'),(87,'2016-05-30 07:29:38','Cachoeiras de Macacu','In Transit','Freight'),(88,'2016-07-15 21:17:26','Liucheng','In Transit','Air'),(89,'2016-12-06 03:18:14','San Casimiro','In Transit','Freight'),(90,'2016-09-08 07:04:30','Ia Kha','In Transit','Air'),(91,'2016-06-20 03:37:26','Tarłów','In Transit','Freight'),(92,'2016-05-01 14:47:11','Santiago del Estero','In Transit','Air'),(93,'2016-10-27 05:12:40','Catujal','In Transit','Freight'),(94,'2016-09-17 15:37:20','Xinzheng','In Transit','Air'),(95,'2016-08-31 06:47:56','Hīrna','In Transit','Rail'),(96,'2016-05-09 15:33:31','Bến Cầu','In Transit','Rail'),(97,'2017-01-02 07:40:23','Aguas del Padre','In Transit','Air'),(98,'2016-10-24 16:54:57','Uiasa','In Transit','Freight'),(99,'2016-06-15 17:36:38','Hujirt','In Transit','Air'),(100,'2016-11-07 04:13:23','Banyliv','In Transit','Rail');
/*!40000 ALTER TABLE `tracking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-29 13:49:43
