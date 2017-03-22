-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
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
-- Table structure for table `shipment`
--

DROP TABLE IF EXISTS `shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment` (
  `ShipmentID` int(11) NOT NULL AUTO_INCREMENT,
  `ShipCustomerID` int(11) NOT NULL,
  `StoreID` int(11) NOT NULL,
  `ShipMethod` varchar(45) NOT NULL,
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
  CONSTRAINT `ShipCustomerID` FOREIGN KEY (`ShipCustomerID`) REFERENCES `customer` (`CustomerID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `StoreID` FOREIGN KEY (`StoreID`) REFERENCES `store` (`StoreID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment`
--

LOCK TABLES `shipment` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
INSERT INTO `shipment` VALUES (1,8,8,'6000','2241 Prentice Parkway','Nashville','Tennessee',37215,'2016-05-30 06:50:13','2017-03-07 21:54:22',10.5),(2,1,9,'5100','27003 Sachtjen Alley','Amarillo','Texas',79116,'2016-11-05 07:35:09','2017-03-07 21:43:39',58.59),(3,3,7,'6101','6 Cherokee Way','Lancaster','Pennsylvania',17622,'2016-07-18 18:10:34','2017-03-09 22:34:41',55.45),(4,5,8,'5100','6756 Prairie Rose Point','Nashville','Tennessee',37220,'2016-05-31 13:26:47','2017-03-09 23:43:10',5.01),(5,9,4,'5100','0 Shoshone Way','Ann Arbor','Michigan',48107,'2017-02-13 13:34:33','2017-03-06 00:57:45',29.32),(6,2,8,'6010','551 Shopko Hill','Miami','Florida',33261,'2016-08-06 22:56:05','2017-03-09 01:32:53',57.01),(7,4,3,'5010','43666 Laurel Hill','Sioux Falls','South Dakota',57110,'2017-02-03 23:33:06','2017-03-07 12:35:12',93.53),(8,6,4,'6001','8 Springs Trail','Montgomery','Alabama',36104,'2016-07-24 04:52:36','2017-03-07 18:50:58',42.51),(9,10,1,'4010','49 Iowa Junction','Miami','Florida',33180,'2016-11-01 19:05:52','2017-03-07 17:08:19',60.27),(10,6,5,'6010','69 Moland Way','Columbus','Ohio',43231,'2016-08-14 10:58:50','2017-03-06 23:43:28',57.3),(11,9,3,'5110','7 Fair Oaks Center','Bethesda','Maryland',20816,'2016-10-14 09:07:35','2017-03-08 02:06:20',80.47),(12,8,4,'4101','08542 8th Alley','San Jose','California',95118,'2017-01-01 19:44:03','2017-03-06 05:01:15',81.31),(13,9,5,'5100','362 6th Avenue','Shawnee Mission','Kansas',66286,'2016-07-09 16:29:32','2017-03-06 18:06:08',38.57),(14,9,9,'6011','56 Daystar Alley','Charlotte','North Carolina',28210,'2017-01-27 00:19:30','2017-03-09 14:28:35',1.92),(15,8,6,'5111','1311 Loftsgordon Plaza','Louisville','Kentucky',40266,'2017-01-23 11:06:31','2017-03-06 03:00:27',39.05),(16,10,5,'5010','39 Kinsman Point','Los Angeles','California',90076,'2016-06-30 02:37:22','2017-03-06 15:19:41',39.95),(17,7,1,'5000','28 Village Road','Lancaster','Pennsylvania',17622,'2016-07-30 06:07:28','2017-03-08 00:49:42',78.46),(18,9,1,'4011','6 Lien Street','Fresno','California',93709,'2016-09-05 02:27:15','2017-03-09 21:24:58',91.02),(19,5,7,'4010','5 Katie Way','Van Nuys','California',91411,'2017-01-20 13:31:14','2017-03-08 12:14:44',69.36),(20,7,10,'6011','31 Bluejay Drive','Duluth','Georgia',30195,'2017-02-17 02:59:22','2017-03-08 13:15:04',33.49),(21,9,5,'5111','4459 Acker Alley','Saint Louis','Missouri',63158,'2016-05-02 09:36:51','2017-03-06 17:18:16',75.66),(22,4,7,'6110','2 Esker Crossing','Hartford','Connecticut',6120,'2016-12-21 14:51:27','2017-03-09 17:47:59',6.58),(23,4,1,'6010','552 Florence Parkway','Washington','District of Columbia',20067,'2016-07-04 15:43:07','2017-03-06 21:19:37',77.52),(24,8,2,'4110','44460 Canary Alley','New York City','New York',10029,'2016-08-08 20:08:52','2017-03-06 08:39:27',63.44),(25,5,6,'6011','81348 Golf View Plaza','Columbus','Georgia',31998,'2016-10-13 09:00:02','2017-03-08 19:27:00',61.71),(26,9,10,'4101','2041 Miller Place','Pittsburgh','Pennsylvania',15230,'2016-12-08 13:53:17','2017-03-08 17:31:55',59.34),(27,9,5,'5111','633 Brown Alley','Omaha','Nebraska',68144,'2017-02-09 22:29:49','2017-03-06 00:56:04',3.61),(28,5,10,'4000','67019 Bay Trail','New Hyde Park','New York',11044,'2016-12-31 10:44:08','2017-03-06 10:33:26',5.12),(29,3,8,'4010','87 Gina Terrace','Tucson','Arizona',85743,'2017-02-06 19:14:59','2017-03-07 10:58:53',60.32),(30,6,3,'4011','58545 Hanover Crossing','Miami','Florida',33190,'2016-03-25 01:09:53','2017-03-09 05:01:47',4.76),(31,9,2,'4110','359 Havey Drive','Houston','Texas',77095,'2016-09-25 10:57:28','2017-03-09 23:32:57',41.89),(32,1,9,'6101','74 Calypso Drive','Brooklyn','New York',11236,'2017-03-06 18:06:15','2017-03-09 07:13:52',23.5),(33,4,9,'5100','2153 Comanche Court','Peoria','Arizona',85383,'2016-09-06 02:51:16','2017-03-07 05:26:23',69.31),(34,3,10,'6101','2 Calypso Drive','Louisville','Kentucky',40205,'2016-07-21 02:51:38','2017-03-08 21:26:58',40.78),(35,2,4,'4100','303 Montana Road','Columbus','Georgia',31914,'2016-05-06 13:45:27','2017-03-06 17:33:46',12.62),(36,10,2,'4110','52 Hallows Junction','Saint Louis','Missouri',63126,'2016-11-05 12:34:58','2017-03-07 22:31:57',45.47),(37,8,7,'5111','0 Stone Corner Hill','Flushing','New York',11388,'2016-06-19 14:10:25','2017-03-08 05:00:35',81.44),(38,7,1,'4101','431 South Court','Chicago','Illinois',60663,'2016-04-05 06:04:00','2017-03-07 06:02:10',37.33),(39,5,3,'6110','839 Kinsman Way','Schenectady','New York',12325,'2017-01-16 14:18:08','2017-03-08 20:15:48',62.02),(40,8,4,'5011','320 Kennedy Circle','Charlotte','North Carolina',28247,'2016-05-09 22:45:46','2017-03-07 07:36:33',92.28),(41,7,5,'4010','5 Surrey Hill','Indianapolis','Indiana',46231,'2016-08-06 22:33:02','2017-03-08 12:07:45',72.21),(42,10,1,'4011','7442 Fallview Avenue','Kansas City','Missouri',64153,'2016-12-23 01:32:08','2017-03-07 20:09:55',53.12),(43,5,4,'4011','7806 Weeping Birch Alley','Brockton','Massachusetts',2405,'2016-12-19 22:17:35','2017-03-08 20:08:15',15.33),(44,4,7,'6100','774 International Pass','Harrisburg','Pennsylvania',17140,'2016-04-18 15:57:17','2017-03-07 01:13:34',59.26),(45,2,5,'4100','87469 Jana Center','Little Rock','Arkansas',72215,'2016-12-26 04:46:18','2017-03-09 14:24:36',78.13),(46,7,2,'4101','24 Eagle Crest Plaza','Las Vegas','Nevada',89193,'2016-09-05 02:30:29','2017-03-09 14:40:18',28.05),(47,2,10,'6001','588 Maryland Junction','San Luis Obispo','California',93407,'2016-09-25 13:08:18','2017-03-08 12:26:43',2.07),(48,6,1,'4101','5 Nevada Avenue','Providence','Rhode Island',2912,'2016-05-07 11:22:57','2017-03-09 21:59:43',50.38),(49,1,3,'6001','9 Burning Wood Crossing','Jackson','Mississippi',39204,'2016-09-04 09:43:25','2017-03-06 23:35:25',68.31),(50,8,5,'6111','70 Blackbird Drive','Oklahoma City','Oklahoma',73104,'2016-09-03 06:46:21','2017-03-06 00:57:21',38.83),(51,9,8,'5110','3464 Golf Course Place','San Antonio','Texas',78235,'2016-04-08 06:30:08','2017-03-06 05:16:43',31.08),(52,2,4,'6001','80 Parkside Park','Charleston','West Virginia',25313,'2016-09-10 17:55:51','2017-03-06 01:28:46',37.99),(53,3,5,'4111','67228 Kinsman Point','Philadelphia','Pennsylvania',19151,'2016-10-27 08:06:44','2017-03-08 23:36:35',57.89),(54,10,5,'6101','328 Hagan Hill','Washington','District of Columbia',20244,'2016-10-19 02:59:14','2017-03-09 23:43:23',16.59),(55,4,1,'4111','3 Lillian Circle','Raleigh','North Carolina',27658,'2016-05-14 02:46:13','2017-03-08 13:31:55',21.94),(56,2,5,'5111','021 Vahlen Center','Evansville','Indiana',47737,'2016-09-24 17:03:11','2017-03-09 18:10:33',69.7),(57,5,3,'4000','78535 Nevada Park','Beaumont','Texas',77713,'2016-03-24 04:24:57','2017-03-07 01:59:14',36.26),(58,10,1,'4111','03294 Division Lane','Corpus Christi','Texas',78475,'2016-08-28 23:29:56','2017-03-07 15:58:12',49.55),(59,1,5,'6000','7725 Lien Avenue','Albuquerque','New Mexico',87115,'2017-01-11 02:50:53','2017-03-08 20:18:51',82.55),(60,3,10,'4011','8657 Sunnyside Court','Great Neck','New York',11024,'2016-12-10 09:53:29','2017-03-08 15:58:48',64.52),(61,7,8,'6100','669 Algoma Crossing','Los Angeles','California',90071,'2016-10-10 05:34:17','2017-03-09 12:37:47',76.86),(62,7,5,'5110','39826 Kingsford Circle','Colorado Springs','Colorado',80930,'2016-04-18 12:27:49','2017-03-08 20:05:50',50.09),(63,5,2,'6101','369 Eastlawn Plaza','Hattiesburg','Mississippi',39404,'2016-07-11 17:59:17','2017-03-07 07:08:59',1.24),(64,3,7,'5001','454 West Way','San Diego','California',92115,'2016-07-04 09:33:31','2017-03-07 13:59:35',48.89),(65,9,5,'6010','3309 Eagan Lane','Portsmouth','Virginia',23705,'2016-11-08 16:21:04','2017-03-07 14:29:34',75.67),(66,3,6,'4000','74 Barby Park','Charlottesville','Virginia',22908,'2016-07-18 19:39:20','2017-03-09 11:21:57',34.1),(67,8,7,'6110','7117 Morrow Junction','Sacramento','California',94230,'2017-03-14 17:15:04','2017-03-08 19:50:41',8.89),(68,2,7,'4010','12119 Daystar Parkway','Lincoln','Nebraska',68517,'2016-11-04 05:43:33','2017-03-08 13:57:44',78.16),(69,6,9,'5001','844 Sugar Hill','Mansfield','Ohio',44905,'2016-06-30 00:26:46','2017-03-07 01:23:50',55.08),(70,2,4,'5111','21 Jenifer Parkway','Las Vegas','Nevada',89120,'2016-04-21 20:20:23','2017-03-06 03:33:48',64.62),(71,4,2,'4001','594 Fremont Junction','Sacramento','California',94250,'2017-03-03 04:35:01','2017-03-08 05:04:19',94.84),(72,10,2,'4110','044 Jay Park','Brooklyn','New York',11254,'2017-01-11 16:26:31','2017-03-07 12:19:15',49.22),(73,10,7,'4100','27866 Scofield Terrace','Pittsburgh','Pennsylvania',15220,'2017-01-26 17:34:31','2017-03-08 12:40:15',53.61),(74,8,4,'5111','9 Annamark Avenue','Clearwater','Florida',33758,'2016-10-20 21:36:54','2017-03-08 13:48:13',40.69),(75,2,9,'4000','42 Nelson Center','Birmingham','Alabama',35205,'2016-04-28 13:44:58','2017-03-08 01:18:29',52.17),(76,7,9,'4010','61362 Di Loreto Drive','New York City','New York',10155,'2016-11-15 07:02:38','2017-03-08 20:53:55',82.07),(77,10,8,'6110','074 Green Ridge Terrace','Long Beach','California',90810,'2016-09-25 16:49:53','2017-03-09 04:56:26',61.26),(78,3,2,'5000','24064 Oneill Park','Chula Vista','California',91913,'2016-09-16 03:45:05','2017-03-06 05:35:25',44.94),(79,7,5,'6111','890 Hanover Street','Huntington','West Virginia',25716,'2017-02-01 16:41:34','2017-03-07 12:02:23',94.07),(80,5,5,'5111','1 Graedel Plaza','Waterbury','Connecticut',6705,'2016-05-15 14:02:05','2017-03-06 05:11:23',27.18),(81,1,8,'4011','1 Elmside Parkway','Philadelphia','Pennsylvania',19136,'2016-12-01 18:15:58','2017-03-06 08:09:14',55.83),(82,10,6,'6111','2 Main Lane','Las Vegas','Nevada',89160,'2016-12-28 21:05:46','2017-03-06 02:18:09',63.72),(83,6,8,'5010','99 Canary Center','Greensboro','North Carolina',27415,'2017-01-05 00:48:48','2017-03-09 13:19:12',25.66),(84,4,8,'6000','8887 Anniversary Parkway','San Diego','California',92160,'2016-03-19 15:35:21','2017-03-06 18:13:17',89.01),(85,5,8,'4010','7 Tony Trail','Arlington','Texas',76016,'2016-10-24 11:16:35','2017-03-08 12:39:50',57),(86,8,1,'5001','5 Fairfield Street','Lawrenceville','Georgia',30045,'2017-02-17 23:11:14','2017-03-09 11:59:57',63.63),(87,7,7,'5101','4122 Hoard Terrace','Largo','Florida',33777,'2017-03-04 21:43:50','2017-03-06 19:17:16',92.14),(88,5,9,'5100','794 Pond Terrace','Roanoke','Virginia',24034,'2016-09-08 10:53:25','2017-03-09 12:32:45',36.48),(89,5,7,'4001','06511 Bashford Circle','Washington','District of Columbia',20268,'2016-06-04 15:20:27','2017-03-06 00:14:14',59.65),(90,9,7,'6101','5 Maple Wood Circle','El Paso','Texas',79977,'2016-10-04 14:48:53','2017-03-06 12:43:03',57.03),(91,10,1,'6000','5464 Hazelcrest Park','Washington','District of Columbia',20566,'2016-08-07 23:25:20','2017-03-08 15:56:51',31.73),(92,1,6,'4011','773 Chive Park','Boise','Idaho',83757,'2016-10-24 23:08:48','2017-03-09 06:07:00',9.68),(93,5,10,'5011','9 Rowland Terrace','Minneapolis','Minnesota',55480,'2017-01-08 13:55:13','2017-03-06 01:46:26',91.26),(94,5,2,'5100','3 Thompson Hill','Stamford','Connecticut',6912,'2016-04-20 21:18:19','2017-03-07 07:07:34',54.71),(95,9,5,'6111','6093 Hermina Lane','Louisville','Kentucky',40298,'2016-09-07 21:48:48','2017-03-08 12:25:36',21.08),(96,1,6,'5000','8494 Rusk Pass','Tulsa','Oklahoma',74116,'2016-08-27 07:43:21','2017-03-06 04:54:30',53.49),(97,3,7,'4000','65218 Michigan Plaza','Spartanburg','South Carolina',29319,'2016-12-28 19:58:24','2017-03-08 04:29:16',50.21),(98,3,1,'6011','29 Forest Drive','Brea','California',92822,'2016-03-27 12:58:15','2017-03-06 10:53:59',9.87),(99,9,4,'5001','15216 Cascade Pass','Boston','Massachusetts',2119,'2016-05-13 04:56:29','2017-03-08 15:39:39',48.46),(100,4,8,'6000','6 Barby Parkway','Duluth','Minnesota',55805,'2016-06-12 00:35:46','2017-03-06 10:45:22',31.44);
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
  PRIMARY KEY (`ShipmentMethodID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipmentmethod`
--

LOCK TABLES `shipmentmethod` WRITE;
/*!40000 ALTER TABLE `shipmentmethod` DISABLE KEYS */;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-21 18:05:52
