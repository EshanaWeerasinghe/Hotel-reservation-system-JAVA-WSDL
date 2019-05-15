-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.24-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema hotel_ms
--

CREATE DATABASE IF NOT EXISTS hotel_ms;
USE hotel_ms;

--
-- Definition of table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`,`first_name`,`last_name`,`mobile`,`email`,`username`,`password`) VALUES 
 (1,'No','Customer','-','-',NULL,NULL),
 (2,'Sachithra','Dilshan','0771378872','sdilshan12345@gmail.com','customer','customer');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Definition of table `double_rooms`
--

DROP TABLE IF EXISTS `double_rooms`;
CREATE TABLE `double_rooms` (
  `iddouble_rooms` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `availability` int(11) DEFAULT '0',
  `from_date` varchar(255) DEFAULT '-',
  `to_date` varchar(255) DEFAULT '-',
  `customet_id` int(11) DEFAULT '1',
  PRIMARY KEY (`iddouble_rooms`),
  KEY `hotel_id_dr_fk_idx` (`hotel_id`),
  KEY `customet_id_dr_fk_idx` (`customet_id`),
  CONSTRAINT `customet_id_dr_fk` FOREIGN KEY (`customet_id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `hotel_id_dr_fk` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`idhotel`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `double_rooms`
--

/*!40000 ALTER TABLE `double_rooms` DISABLE KEYS */;
INSERT INTO `double_rooms` (`iddouble_rooms`,`name`,`hotel_id`,`availability`,`from_date`,`to_date`,`customet_id`) VALUES 
 (1,'3/DR/1',3,0,'-','-',1),
 (2,'3/DR/2',3,0,'-','-',1),
 (3,'3/DR/3',3,0,'-','-',1),
 (4,'4/DR/1',4,0,'-','-',1),
 (5,'4/DR/2',4,0,'-','-',1),
 (6,'4/DR/3',4,0,'-','-',1),
 (7,'5/DR/1',5,0,'-','-',1),
 (8,'5/DR/2',5,0,'-','-',1),
 (9,'3/DR/1',3,0,'-','-',1),
 (10,'3/DR/2',3,0,'-','-',1),
 (11,'3/DR/3',3,0,'-','-',1),
 (12,'3/DR/4',3,0,'-','-',1),
 (13,'3/DR/5',3,0,'-','-',1);
/*!40000 ALTER TABLE `double_rooms` ENABLE KEYS */;


--
-- Definition of table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `idemployee` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `nic` varchar(45) DEFAULT NULL,
  `address_line1` varchar(45) DEFAULT NULL,
  `address_line2` varchar(45) DEFAULT NULL,
  `address_city` varchar(45) DEFAULT NULL,
  `address_postalcode` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `emp_category_id` int(11) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idemployee`),
  KEY `emp_category_id_fk_idx` (`emp_category_id`),
  KEY `hotel_id_employee_fk_idx` (`hotel_id`),
  CONSTRAINT `emp_category_id_fk` FOREIGN KEY (`emp_category_id`) REFERENCES `employee_category` (`idemployee_category`) ON UPDATE CASCADE,
  CONSTRAINT `hotel_id_employee_fk` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`idhotel`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='	';

--
-- Dumping data for table `employee`
--

/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`idemployee`,`first_name`,`last_name`,`nic`,`address_line1`,`address_line2`,`address_city`,`address_postalcode`,`mobile`,`user_name`,`password`,`emp_category_id`,`hotel_id`) VALUES 
 (1,'Sachithra','Dilshan','911580357v','No : 119','Morakele','Ihala Kottaramulla','15000','0771378872','admin','admin',1,1),
 (2,'Dilshan','Sachithra','911580357v','Seela Niwasa','Morakele','Ihala Kottaramulla','150247','0771378872','manager','manager',2,1),
 (3,'Dilshan','Sachithra','911580357v','Seela Niwasa','Morakele','Ihala Kottaramulla','150247','0771378872','supervisor','supervisor',3,3),
 (4,'Dilshan','Sachithra','911580357v','Seela Niwasa','Morakele','Ihala Kottaramulla','150247','0771378872','reception','reception',4,2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


--
-- Definition of table `employee_category`
--

DROP TABLE IF EXISTS `employee_category`;
CREATE TABLE `employee_category` (
  `idemployee_category` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idemployee_category`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee_category`
--

/*!40000 ALTER TABLE `employee_category` DISABLE KEYS */;
INSERT INTO `employee_category` (`idemployee_category`,`category_name`) VALUES 
 (1,'Global Admin'),
 (2,'Manager'),
 (3,'Supervisor'),
 (4,'Reception');
/*!40000 ALTER TABLE `employee_category` ENABLE KEYS */;


--
-- Definition of table `family_rooms`
--

DROP TABLE IF EXISTS `family_rooms`;
CREATE TABLE `family_rooms` (
  `idfamily_rooms` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `availability` int(11) DEFAULT '0',
  `from_date` varchar(255) DEFAULT '-',
  `to_date` varchar(255) DEFAULT '-',
  `customer_id` int(11) DEFAULT '1',
  PRIMARY KEY (`idfamily_rooms`),
  KEY `hotel_id_fr_fk_idx` (`hotel_id`),
  KEY `customer_id_fr_fk_idx` (`customer_id`),
  CONSTRAINT `customer_id_fr_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `hotel_id_fr_fk` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`idhotel`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `family_rooms`
--

/*!40000 ALTER TABLE `family_rooms` DISABLE KEYS */;
INSERT INTO `family_rooms` (`idfamily_rooms`,`name`,`hotel_id`,`availability`,`from_date`,`to_date`,`customer_id`) VALUES 
 (1,'3/FR/1',3,0,'-','-',1),
 (2,'3/FR/2',3,0,'-','-',1),
 (3,'3/FR/3',3,0,'-','-',1),
 (4,'3/FR/4',3,0,'-','-',1),
 (5,'4/FR/1',4,0,'-','-',1),
 (6,'4/FR/2',4,0,'-','-',1),
 (7,'4/FR/3',4,0,'-','-',1),
 (8,'4/FR/4',4,0,'-','-',1),
 (9,'5/FR/1',5,0,'-','-',1),
 (10,'5/FR/2',5,0,'-','-',1),
 (11,'5/FR/3',5,0,'-','-',1),
 (12,'3/FR/1',3,0,'-','-',1),
 (13,'3/FR/2',3,0,'-','-',1),
 (14,'3/FR/3',3,0,'-','-',1),
 (15,'3/FR/4',3,0,'-','-',1),
 (16,'3/FR/5',3,0,'-','-',1),
 (17,'3/FR/6',3,0,'-','-',1);
/*!40000 ALTER TABLE `family_rooms` ENABLE KEYS */;


--
-- Definition of table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `idhotel` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_Name` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `single_rooms` int(11) DEFAULT NULL,
  `double_rooms` int(11) DEFAULT NULL,
  `family_rooms` int(11) DEFAULT NULL,
  PRIMARY KEY (`idhotel`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hotel`
--

/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` (`idhotel`,`hotel_Name`,`location`,`single_rooms`,`double_rooms`,`family_rooms`) VALUES 
 (1,'Wanamaura','Kandy',NULL,NULL,NULL),
 (2,'Walimaliga','Hikkaduwa',NULL,NULL,NULL),
 (3,'test 1','test location',2,3,4),
 (4,'test 2','test location2',2,3,4),
 (5,'test 3','test location3',1,2,3),
 (6,'test 1','test location',4,5,6);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;


--
-- Definition of table `single_rooms`
--

DROP TABLE IF EXISTS `single_rooms`;
CREATE TABLE `single_rooms` (
  `idsingle_room` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `availability` int(11) DEFAULT '0',
  `from_date` varchar(255) DEFAULT '-',
  `to_date` varchar(255) DEFAULT '-',
  `customer_id` int(11) DEFAULT '1',
  PRIMARY KEY (`idsingle_room`),
  KEY `hotel_id_sr_fk_idx` (`hotel_id`),
  KEY `customer_id_sr_fk_idx` (`customer_id`),
  CONSTRAINT `customer_id_sr_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `hotel_id_sr_fk` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`idhotel`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `single_rooms`
--

/*!40000 ALTER TABLE `single_rooms` DISABLE KEYS */;
INSERT INTO `single_rooms` (`idsingle_room`,`name`,`hotel_id`,`availability`,`from_date`,`to_date`,`customer_id`) VALUES 
 (1,'3/SR/1',3,1,'2016-05-12','2016-05-15',2),
 (2,'3/SR/2',3,1,'2016-05-12','2016-05-15',2),
 (3,'4/SR/1',4,0,'-','-',1),
 (4,'4/SR/2',4,0,'-','-',1),
 (5,'5/SR/1',5,0,'-','-',1),
 (6,'3/SR/1',3,1,'2016-05-12','2016-05-15',2),
 (7,'3/SR/2',3,0,'-','-',1),
 (8,'3/SR/3',3,0,'-','-',1),
 (9,'3/SR/4',3,0,'-','-',1);
/*!40000 ALTER TABLE `single_rooms` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
