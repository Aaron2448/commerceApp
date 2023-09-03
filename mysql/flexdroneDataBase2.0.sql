CREATE DATABASE  IF NOT EXISTS `flexdronedb2.0` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `flexdronedb2.0`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: flexdronedb2.0
-- ------------------------------------------------------
-- Server version	5.7.40-log

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
-- Table structure for table `access_control_role`
--

DROP TABLE IF EXISTS `access_control_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `access_control_role` (
  `access_control_role_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`access_control_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `access_control_role`
--

LOCK TABLES `access_control_role` WRITE;
/*!40000 ALTER TABLE `access_control_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `access_control_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `access_control_role_privilege`
--

DROP TABLE IF EXISTS `access_control_role_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `access_control_role_privilege` (
  `role_id` bigint(20) NOT NULL,
  `privilege_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `access_control_role_privilege`
--

LOCK TABLES `access_control_role_privilege` WRITE;
/*!40000 ALTER TABLE `access_control_role_privilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `access_control_role_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campaign`
--

DROP TABLE IF EXISTS `campaign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campaign` (
  `campaign_id` bigint(20) NOT NULL,
  `end_date` datetime DEFAULT NULL,
  `campaign_name` varchar(255) DEFAULT NULL,
  `campaign_objective` varchar(255) DEFAULT NULL,
  `campaign_sponsor` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`campaign_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campaign`
--

LOCK TABLES `campaign` WRITE;
/*!40000 ALTER TABLE `campaign` DISABLE KEYS */;
/*!40000 ALTER TABLE `campaign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campaign_customer`
--

DROP TABLE IF EXISTS `campaign_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campaign_customer` (
  `campaign_customer_id` bigint(20) NOT NULL,
  `customers_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campaign_customer`
--

LOCK TABLES `campaign_customer` WRITE;
/*!40000 ALTER TABLE `campaign_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `campaign_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campaign_seq`
--

DROP TABLE IF EXISTS `campaign_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campaign_seq` (
  `campaign_seq_next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campaign_seq`
--

LOCK TABLES `campaign_seq` WRITE;
/*!40000 ALTER TABLE `campaign_seq` DISABLE KEYS */;
/*!40000 ALTER TABLE `campaign_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_campaign`
--

DROP TABLE IF EXISTS `customer_campaign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_campaign` (
  `customer_campaign_id` bigint(20) NOT NULL,
  `campaigns_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_campaign`
--

LOCK TABLES `customer_campaign` WRITE;
/*!40000 ALTER TABLE `customer_campaign` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_campaign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_seq`
--

DROP TABLE IF EXISTS `customer_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_seq` (
  `customer_seq_next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_seq`
--

LOCK TABLES `customer_seq` WRITE;
/*!40000 ALTER TABLE `customer_seq` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enquiry`
--

DROP TABLE IF EXISTS `enquiry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enquiry` (
  `enquiry_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `allocated_staff_id` int(11) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `customer_message` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `enquiry_type` varchar(255) NOT NULL,
  `is_refunded` bit(1) DEFAULT NULL,
  `is_returned` bit(1) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `resolution_action` varchar(255) DEFAULT NULL,
  `resolve_by_id` int(11) DEFAULT NULL,
  `resolve_date` date DEFAULT NULL,
  PRIMARY KEY (`enquiry_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enquiry`
--

LOCK TABLES `enquiry` WRITE;
/*!40000 ALTER TABLE `enquiry` DISABLE KEYS */;
/*!40000 ALTER TABLE `enquiry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enquiry_seq`
--

DROP TABLE IF EXISTS `enquiry_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enquiry_seq` (
  `enquiry_seq_next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enquiry_seq`
--

LOCK TABLES `enquiry_seq` WRITE;
/*!40000 ALTER TABLE `enquiry_seq` DISABLE KEYS */;
/*!40000 ALTER TABLE `enquiry_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO hibernate_sequence (next_val) VALUES (30);
--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `order_at` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `payment_method` varchar(255) NOT NULL,
  `dispatched_on` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,0,'customer_placed','10 testing First entry without db change','2023/03/09 13:46:42','aaron.marinelli898@gmail.com','Credit Card',NULL),(2,0,'customer_placed','after altering sql data base','2023/03/09 14:09:25','aaron.marinelli898@gmail.com','Credit Card',NULL);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `privilege` (
  `privilege_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `external_note` varchar(255) DEFAULT NULL,
  `external_stock` bigint(20) DEFAULT NULL,
  `image_url` varchar(1000) DEFAULT NULL,
  `internal_note` varchar(255) DEFAULT NULL,
  `internal_stock` bigint(20) DEFAULT NULL,
  `is_part` bit(1) DEFAULT NULL,
  `min_stock_level` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity_in_cart` int(11) DEFAULT NULL,
  `reorder_point` bigint(20) DEFAULT NULL,
  `retail_price` float DEFAULT NULL,
  `sku` varchar(255) NOT NULL,
  PRIMARY KEY  (`product_id`),
  UNIQUE KEY `UK_q1mafxn973ldq80m1irp3mpvq` (`sku`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

-- LOCK TABLES `product` WRITE;
-- /*!40000 ALTER TABLE `product` DISABLE KEYS */;
-- INSERT INTO `product` VALUES (1,'Battery','Red, 4kg, 44Wh capacity','',19,'https://cdn.shopify.com/s/files/1/0594/7945/7990/products/AerooIntelligentFlightBattery_1024x1024@2x.jpg?v=1632188925','',11,_binary '',12,'Harpo Intelligent Flight Battery',1,0,22900,'Har-Bat-Inn-P-R-B23-SM-0003'),(2,'Wings','Yellow, 575mm flying wing','',52,'https://m.media-amazon.com/images/I/71MBrlR3CKL._AC_SX679_.jpg','',38,_binary '',12,'DXT Flight Wings',1,0,10300,'DXT-Win-Gua-P-W-D12-ME-0004'),(3,'Controller','20X20 Flight Controller V2.1','',30,'https://www.d1store.com.au/images/products/DJI-RC-02.jpg','',12,_binary '',15,'Awesome Flight Controller DJI',1,0,7000,'Awe-Con-DJI-D-B-A10-MI-0006'),(4,'Radio','Lite long range module','',30,'https://www.radioparts.com.au/images/ProductImages/08607292.jpg','',20,_binary '',13,'Fan Long Range Communication Radio',1,0,8500,'Fan-Rad-Syn-P-B-A07-VS-0007'),(5,'Charger','Yellow, Nano battery 200W 8A','Out of stock',0,'https://www.auselectronicsdirect.com.au/assets/full/PS1178.jpg?20220321231425','',5,_binary '',15,'Element Nano Battery Charger',1,0,3200,'Ele-Cha-Inn-M-W-B23-SM-0008'),(6,'Transmitter','Black, 30 x 23 x 5.5mm, 7g, 6V - 26V (2S - 6S)','',19,'https://m.media-amazon.com/images/I/51rAjhJFZRL._AC_UF894,1000_QL80_.jpg','',18,_binary '',14,'Coms Pro Transmitter',1,0,9990,'Com-Tra-Gua-D-B-D12-ME-0009'),(7,'Motor','Red, 30 x 23 x 5.5mm, 6g, 6V - 26V (2S - 6S)','',39,'https://ae01.alicdn.com/kf/He2d0abfda0ae419a9eb09ba9578370a9a/Diatone-RcMA-F1-Traversing-Machine-Carbon-Fiber-Frame-1-6-Inch-3S-Power-With-Protection-Ring.jpg_Q90.jpg_.webp','',20,_binary '',12,'Power Technology CF-Arm Frame',1,0,9900,'Pow-Mot-Ple-P-W-D12-MI-0001'),(8,'RTF Drone','8GB of Storage Space, 3-Axis Gimbal with Dual Cameras, Up to 46 Minutes of Flight Time, Up to 9.3-Mile Transmission Range, RC-N1 OcuSync 2.0 Remote Included ','',14,'https://www.dpreview.com/files/p/articles/0047640267/1974DC4F-DA77-4A39-AEA4-1991FF1063BD.jpeg','',13,_binary '\0',10,'Epic Mavic 3',1,0,89600,'Epi-RTF-DJI-D-B-A13-LA-0001'),(9,'Camera','UAV Low-Light Navigation Camera with maximized low-light sensitivity','',17,'https://www.d1store.com.au/images/products/D1store_Zenmuse_h20t_product_image.jpg','',23,_binary '',10,'UAV photogrammetry camera',1,0,53000,'UAV-Cam-Lam-P-B-B23-MI-0002'),(10,'Propeller','Eachine 6/7mm 4-Blade propellers  0.8mm haft for brushed motors.','',16,'https://assets.kogan.com/images/dronesxpress/DRX-11395349413924/1-43d5513bb9-eachine-e58-drone-propeller-guard-propellers-drones-xpress_a2fbd67d-3b47-4536-8082-502967f69538.jpg?auto=webp&canvas=753%2C502&fit=bounds&height=502&quality=75&width=753','',33,_binary '',12,'Eachine E58 Drone Propeller Guard',1,0,2500,'Eac-Prop-Tal-M-B-D12-VS-0001'),(11,'Battery','Rechargeable Lithium Battery7.4V 350mAh TR003 Dron','Out of stock',0,'https://cdn.shopify.com/s/files/1/0153/9135/9024/products/O-100C-1550-4S1P-XT60-3_1800x1800.jpg?v=1657715325','Low Stock',2,_binary '',14,'Drone Diy Spare Parts Lithium Battery',1,0,20000,'Dro-Bat-Lui-P-R-A10-SM-0001'),(12,'Wings','White - Quick Release Foldable Wings - Flight Tested - Essential DJI Mavic Pro Accessory','',12,'https://imgaz2.staticbg.com/thumb/large/oaupload/banggood/images/48/9C/ab1f2777-d16f-4491-a494-5a40cb7fe860.png.webp','',34,_binary '',10,'Long Distance Fixed Wing',1,0,11500,'Lon-Win-Fer-P-R-A07-ME-0001'),(13,'Controller','2.4GHz AFHDS RC Transmitter w/ FS-iA6B Receiver','',25,'https://cdn.shopify.com/s/files/1/0428/1981/3533/products/41fjVuboD1L_900x.jpg?v=1658479879','',23,_binary '',12,'S550 DIY Drone Kit Unassembly PNF 6-Axle Helicopter PIX4 Flight Control ',1,0,12200,'S55-Con-Jiv-D-W-B23-MI-0001'),(14,'Charger','12V 1A Power Supply Adapter, Plug 5.5mm x 2.1mm','',31,'https://cdn.shopify.com/s/files/1/1477/4314/products/9ac2a28ff6caef064b9cc8bba4267902fc85d7d8.png?v=1614732240','',21,_binary '',15,'FPV AC Power ',1,0,3000,'FPV-Char-Sun-M-R-A19-SM-0007'),(15,'Motor',' T-Motor F1507 1507 2700KV 3-6S. (4PCs)','',20,'https://ae01.alicdn.com/kf/Hfb80d0c98f8d4ee3a3aeae1decc869a5P.jpg','',19,_binary '',15,'Eachine 220W motor',1,0,8900,'Eac-Mot-Lea-P-R-D22-MI-0003'),(16,'Wings','730mm Wingspan Dual Motor EPP FPV Racer RC Airplane Fixed Wing KIT/PNP','',32,'https://ae01.alicdn.com/kf/Sf7d1376549154d2aa4280b8f05a58eb2N/K911-AE8-PRO-MAX-GPS-Rc-Drone-Accessories-Propellers-Blades-K911max-Quadcopter-Props-Spare-Parts.jpg_Q90.jpg_.webp','',20,_binary '',15,'CoDrone Pro Wings',1,0,11500,'CoD-Win-Jet-D-W-C23-MI-0003'),(17,'Controller','Program Detailed Flight Plans in 2D/3D, Uses Intel\'s Mission Control Software','',18,'https://www.modelflight.com.au/media/catalog/product/s/p/spmrftx1_b0.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560','',15,_binary '',12,'Intel Cockpit Remote Controller for Falcon 8+ Octacopter Radio Controllers ...',1,0,11500,'Int-Con-Dro-P-W-A11-VS-0002'),(18,'Radio','Certa 6V/12V 9 Stage Smart Battery Charger 2/4/6.5 Amp','',20,'https://www.modelflight.com.au/media/catalog/product/S/P/SPMR14000_A5_WZK7S072.jpg.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=560&width=700&canvas=700:560','',25,_binary '',12,'GPS 2.4g Selfie RC Radio',1,0,9000,'GPS-Rad-Fly-M-B-B20-SM-0002'),(19,'Charger','1.5m, 20W, Battery Voltage 6V/12V, IP65, Weight 400g, 19 x 5 x4 cm','',20,'https://assets.kogan.com/files/external/2022-Oct-Hero-Update/CT5SMTBTCHA_new_hero.jpg?auto=webp&bg-color=fff&canvas=753%2C502&fit=bounds&height=502&quality=75&width=753','',18,_binary '',15,'Certif 6V/12V Smart Battery',1,0,3000,'Cer-Char-Spi-D-R-C23-ME-0002'),(20,'Frame','Built In Camera 4K UHD w/ 3X Batteries Pro Kit','',20,'https://assets.kogan.com/images/dronesxpress/DRX-32607096012836/1-470ccac488-f3-drone-drones-drones-xpress-gps-5g-4k-3b_d621a69e-ed65-43fc-9520-c9bb905347f0.jpg?auto=webp&bg-color=fff&canvas=753%2C502&fit=bounds&height=502&quality=75&width=753','',32,_binary '',15,'5GDrone',1,0,9090,'5GD-Fra-Rop-P-W-B2-MI-0005'),(21,'RTF Drone','4k Camera, S Flight Mode, Super-Wide 150 FOV, Emergency Brake and Hover','',18,'https://cdn.shopify.com/s/files/1/0024/9803/5810/products/511193-Product-0-I-637503754147543757_75f1131b-7001-4e1a-bb76-cff49545ed8a.jpg?v=1614740766','',15,_binary '\0',10,'Leviation FPV 4K Drone Combo',1,0,90000,'Lev-RTF-Fig-D-W-C14-LA-0004'),(22,'Camera','Black, 250g, 4K motorized action camera.','',12,'https://www.netnest.com.au/Content/images/SEFLCF6308000.webp','Reorder',10,_binary '',12,'Magnify 4k Camera ',1,0,60900,'Mag-Cam-Lam-P-B-A09-MI-0005'),(23,'Propeller','Green, lightweight, plastic propellers ','',32,'https://cdn.shopify.com/s/files/1/2472/2530/products/1242_carbon_propellers_5000x.jpg?v=1593496474','',8,_binary '',15,'SweepPro Propeller',1,0,1900,'Swe-Pro-Tal-P-W-B12-VS-0006'),(24,'Battery','Red, 4kg, 44Wh capacity','',19,'https://m.media-amazon.com/images/I/51IcmpVEswL._AC_UF894,1000_QL80_.jpg','',11,_binary '',12,'Ovol Battery',1,0,22900,'Ovo-Bat-Lui-D-R-B05-SM-0007'),(25,'Wings','White - Quick Release Foldable Wings - Flight Tested - Essential DJI Mavic Pro Accessory','',52,'https://crkphotoimaging.com.au/product_image/ts1616532956/rc_600x600/DJIMAVIC2PT13/dji-mavic-2-pt13-low-noise-propellers-pair---cw---ccw---yc-sj-gg000035-03-34-03.jpg','',38,_binary '',12,'EliteDrone wings',1,0,10300,'Eli-Win-Fer-M-W-C01-MI-0008'),(26,'Controller','20X20 Flight Controller V2.1','',30,'https://www.ozled.com.au/assets/full/22GO601.png?20220719094440','',12,_binary '',15,'LangoLingo Command Controller',1,0,7800,'Lan-Con-Jiv-P-B-C13-VS-0009'),(27,'Radio','2.4GHz AFHDS RC Transmitter w/ FS-iA6B Receiver','',30,'https://m.media-amazon.com/images/I/61tDPvWSRdL._AC_SX679_.jpg','',20,_binary '',13,'Avantree TR927 Radio',1,0,8500,'Ava-Rad-Lya-P-B-D17-SM-0010'),(28,'Charger','Program Detailed Flight Plans in 2D/3D, Uses Intel\'s Mission Control Software','Out of stock',0,'https://www.auselectronicsdirect.com.au/assets/full/PS1083.jpg?20210309031357','',5,_binary '',15,'Zaperuni 10 Amps Charger',1,0,3200,'Zap-Cha-Sun-D-W-A04-SM-0011'),(29,'Transmitter','1.5m, 20W, Battery Voltage 6V/12V, IP65, Weight 400g, 19 x 5 x4 cm','',19,'https://d33i9xhtscn2ox.cloudfront.net/images/MED600_JW-P-881506.jpg','',18,_binary '',14,'Yundt Pro Transmitter',1,0,9990,'Yun-Tra-Ado-D-B-A07-ME-0012'),(30,'Motor','Built In Camera 4K UHD w/ 3X Batteries Pro Kit','',39,'https://au.element14.com/productimages/standard/en_US/51AC6761-40.jpg','',20,_binary '',12,'EagleMight SA1234 Motor',1,0,9900,'Eag-Mot-Lea-M-W-C09-MI-0014'),(31,'Camera','Night vision Camera with maximized low-light sensitivity','',17,'https://imgaz.staticbg.com/thumb/large/oaupload/banggood/images/89/81/a54be28f-4a13-4247-9b77-4f64c33f94d8.jpg.webp','',23,_binary '',10,'Twilight Night Vision Camera',1,0,60900,'Twi-Cam-Jet-P-B-D20-MI-0016'),(32,'Propeller','Eachine 6/7mm 4-Blade propellers  0.8mm haft for brushed motors.','',16,'https://cdn.shopify.com/s/files/1/0016/7215/1101/products/product-image-800313356_1080x.jpg?v=1571708533','',33,_binary '',12,'10Pcs Quick Release Propellers',1,0,1900,'10P-Pro-Dro-P-B-D14-VS-0017'),(33,'Battery','Red, 4kg, 40Wh capacity','Out of stock',0,'https://www.auselectronicsdirect.com.au/assets/full/TR9037.jpg?20220209115255','Low Stock',2,_binary '',14,'5G Compact Pro Kit Battery',1,0,18000,'5GC-Bat-Fly-D-R-C09-SM-0018'),(34,'Wings','Red - Quick Release Foldable Wings - Flight Tested - Essential DJI Mavic Pro Accessory','',12,'https://ae01.alicdn.com/kf/S537c9091650b48a48d2a276360e770e1A/4DRC-V2-Mini-Folding-Drone-Quadcopter-Main-Blade-Propeller-Wing-Spare-Part-RC-Helicopter-Replacement-Rotor.jpg_Q90.jpg_.webp','',34,_binary '',10,'Extreme Power Wings',1,0,10300,'Ext-Win-Spi-M-R-C08-ME-0019'),(35,'Controller','Program Detailed Flight Plans in 2D/3D, Uses Intel\'s Mission Control Software','',25,'https://m.media-amazon.com/images/I/61B6a3qp5TL._AC_SL1000_.jpg','',23,_binary '',12,'RogerThat Remote Controller',1,0,12000,'Rog-Con-Rop-P-B-D18-MI-0020'),(36,'Radio','2.4GHz AFHDS RC Transmitter w/ FS-iA6B Receiver','',23,'https://cdn.shopify.com/s/files/1/1477/4314/products/A7301768.jpg?v=1624629588','',15,_binary '',12,'Portable High Freq Radio',1,0,6000,'Port-Rad-Fig-P-R-D19-SM-0021'),(37,'Charger','1.5m, 20W, Battery Voltage 6V/12V, IP65, Weight 400g, 19 x 5 x4 cm','',31,'https://assets.kogan.com/images/zoestore/ZOE-RM13038/1-5a463fe816-rm13038-1-0868-a3ir.jpg?auto=webp&bg-color=fff&canvas=753%2C502&fit=bounds&height=502&quality=75&width=753','',21,_binary '',15,'Bzz Bzz Portable Switchable Charger',1,0,3200,'Bzz-Cha-Gua-D-W-D08-SM-0022'),(38,'Transmitter','Black, 30 x 23 x 5.5mm, 7g, 6V - 26V (2S - 6S)','',31,'https://fpvfrenzy.com/wp-content/uploads/2016/02/rc-transmitter-300x300.jpg','',20,_binary '',15,'Rath Reciever Transmitter',1,0,9990,'Rat-Tra-DJI-D-B-C07-ME-0023'),(39,'Motor',' T-Motor F1507 1507 2700KV 3-6S. (4PCs)','',20,'https://cdn.shopify.com/s/files/1/0003/8859/5740/products/Internet_20200406_184848_1_600x.jpg?v=1621132432','',19,_binary '',15,'Rayg Roar Motor',1,0,9900,'Ray-Mot-Inn-M-B-A20-MI-0025'),(40,'RTF Drone','Built In Camera 4K UHD w/ 3X Batteries Pro Kit','',20,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT50i_AzjbsLe9BBBSM86qCjWdYZrpwyRsmg&usqp=CAU','',19,_binary '\0',10,'Viper-V Drone with VR Headset',1,0,89600,'Vip-RTF-Gua-D-R-B16-LA-0026'),(41,'Camera','Black, 230g, 4K motorized action camera.','',32,'https://assets.kogan.com/images/dronesxpress/DRX-31490456289316/1-ea35558b60-gimbal-repair-part-for-dji-mavic-2-pro-drone-camera-gimbals-drones-xpress-mavic-2-zoom_338f5d23-5f0b-4898-9b22-04498df73c09.jpg?auto=webp&bg-color=fff&canvas=753%2C502&fit=bounds&height=502&quality=75&width=753','',20,_binary '',15,'Dig-Digital Action Camera',1,0,60900,'Dig-Cam-Ple-P-R-B24-MI-0027'),(42,'Propeller','Green, lightweight, plastic propellers ','',18,'https://m.media-amazon.com/images/I/61gUGFNzB1L._SY355_.jpg','',15,_binary '',12,'CemKiz Propellers',1,0,1900,'Cem-Pro-Ple-P-W-C14-VS-0028'),(43,'Battery','Rechargeable Lithium Battery7.4V 350mAh TR003 Dron','',20,'https://cdn.shopify.com/s/files/1/0261/5125/6149/products/FULLSEND-6S-1550mAh-fpv-lipo-battery-xm2-store-3_1600x.jpg?v=1641268028','',25,_binary '',12,'Max Power Battery',1,0,21500,'Max-Bat-DJI-D-R-D01-SM-0029'),(44,'Wings','730mm Wingspan Dual Motor EPP FPV Racer RC Airplane Fixed Wing KIT/PNP','',20,'https://asset1.djicdn.com/uploads/product_photo/image/577/s1000_06.jpg','',18,_binary '',15,'Vital wings',1,0,10300,'Vit-Win-Lam-M-R-C01-ME-0030'),(45,'Controller','Program Detailed Flight Plans in 2D/3D, Uses Intel\'s Mission Control Software','',20,'https://img.aeroexpo.online/images_ar/photo-g/171303-13774119.jpg','',32,_binary '',15,'RC Remote Controller',1,0,12000,'RCR-Con-Fly-P-W-C02-MI-0031'),(46,'Charger','1.5m, 20W, Battery Voltage 6V/12V, IP65, Weight 400g, 19 x 5 x4 cm','',20,'https://www.d1store.com.au/images/products/Mavic-Air-2-Car-Charger-1.jpg','',19,_binary '',10,'NRG Portable Charger',1,0,3200,'NRG-Cha-Rop-D-B-A09-SM-0033'),(47,'Motor','Built In Camera 4K UHD w/ 3X Batteries Pro Kit','',20,'https://sc04.alicdn.com/kf/H7774bf237906420dae44a0c1609a4d74M.jpg','',25,_binary '',12,'Phantom 360 Motor',1,0,9900,'Pha-Mot-Tal-M-R-A06-MI-0036'),(48,'RTF Drone','4k Camera, S Flight Mode, Super-Wide 150 FOV, Emergency Brake and Hover','',20,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR41vfb6vUOLMfRo-6WS1zcKU4kv8Wx1G4BHA&usqp=CAU','',18,_binary '\0',15,'Professional Drone with 4k Camera',1,0,89600,'Pro-RTF-Lam-D-B-C08-LA-0037'),(49,'base','Beginner base model','notesTest',211,'https://stormsend1.djicdn.com/tpc/uploads/carousel/image/7a52cbc2c1fc7b080f62574d33a82e75@origin.jpg','notesTest',334,_binary '\0',334,'Beginner Base Model',0,334,1320,'224454001'),(50,'base','Beginner base model','notesTest',434,'https://stormsend1.djicdn.com/tpc/uploads/carousel/image/0d6a58a5c7ee8f474e5a34113c5d6d37@origin.jpg','notesTest',557,_binary '\0',557,'Enterprise Base Model',0,557,2520,'294454002'),(51,'base','Beginner base model','notesTest',657,'https://stormsend1.djicdn.com/tpc/uploads/carousel/image/c32d1f20946a1eea7e76c61eb90fd797@origin.jpg','notesTest',780,_binary '\0',780,'Sports Base Model',0,780,3720,'294454003'),(52,'battery','45 Minutes of flying time','notesTest',880,'https://cdn.shopify.com/s/files/1/0063/3946/1231/products/Untitled2_946x946.jpg?v=1611454888','notesTest',1003,_binary '\0',1003,'10000 Mah Battery',0,1003,4220,'224454004'),(53,'battery','60 Minutes of flying time','notesTest',1103,'https://cdn.shopify.com/s/files/1/0063/3946/1231/products/Untitled_7b74f7e6-2282-4471-9227-41f42e0dfafb_1080x1080.jpg?v=1611454888','notesTest',1226,_binary '\0',1226,'20000 Mah Battery',0,1226,4920,'294454005'),(54,'battery','90 Minutes of flying time','notesTest',1326,'https://cdn.shopify.com/s/files/1/0063/3946/1231/products/Untitled1_f74c4167-af04-4eca-b612-b55f42662428_1080x1080.jpg?v=1611454888','notesTest',1449,_binary '\0',1449,'30000 Mah Battery',0,1449,5820,'297454006'),(55,'propeller','Dual blade','notesTest',1549,'https://cdn.shopify.com/s/files/1/0024/9803/5810/products/643487-Product-1-I_2240x.jpg?v=1572320430','notesTest',1672,_binary '\0',1672,'F22 Propeller',0,1672,6320,'214454007'),(56,'propeller','Triple Blade','notesTest',1772,'https://m.media-amazon.com/images/I/41uw6jVUdtS._AC_UF894,1000_QL80_.jpg','notesTest',1895,_binary '\0',1895,'F33 Propeller',0,1895,7020,'244454008'),(57,'propeller','Quad Blade','notesTest',1995,'https://www.unmannedsystemstechnology.com/wp-content/uploads/2020/05/drone-propeller.png','notesTest',2118,_binary '\0',2118,'F44 Propeller',0,2118,7920,'212454009'),(58,'camera','Camera 1','notesTest',2218,'https://cdn.shopify.com/s/files/1/0063/3946/1231/products/mmexport1574955222637_800x800.jpg?v=1616779308','notesTest',2341,_binary '\0',2341,'Camera 11',0,2341,8420,'2114454010'),(59,'camera','Camera 2','notesTest',2441,'https://cdn.shopify.com/s/files/1/0063/3946/1231/products/mmexport1610816889862_800x800.jpg?v=1616073826','notesTest',2564,_binary '\0',2564,'Camera 22',0,2564,9120,'2414454011'),(60,'camera','Camera 3','notesTest',2664,'https://cdn.shopify.com/s/files/1/0063/3946/1231/products/01_2400x2400.jpg?v=1646165290','notesTest',2787,_binary '\0',2787,'Camera 33',0,2787,10020,'2122454012');
-- /*!40000 ALTER TABLE `product` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `product_image`
-- delete   UNIQUE KEY `product_id_UNIQUE` (`product_id`)

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_image` (
  `product_id` bigint NOT NULL,
  `images` varchar(1000) DEFAULT NULL,
   KEY `FK6oo0cvcdtb6qmwsga468uuukk` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--   FOREIGN KEY (`product_id`) REFERENCES product(`product_id`)
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_order`
--

DROP TABLE IF EXISTS `product_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_order` (
  `product_order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `quantity` bigint(20) NOT NULL,
  `sku` varchar(255) NOT NULL,
  `sold_price` float NOT NULL,
  PRIMARY KEY (`product_order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_order`
--

LOCK TABLES `product_order` WRITE;
/*!40000 ALTER TABLE `product_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_supplier`
--

DROP TABLE IF EXISTS `product_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_supplier` (
  `product_supplier_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cost_price` float DEFAULT NULL,
  `lead_time` bigint(20) DEFAULT NULL,
  `product_product_id` bigint(20) DEFAULT NULL,
  `supplier_supplier_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`product_supplier_id`),
  KEY `FKra5akb3b24pggqhfvg136hpm7` (`product_product_id`),
  KEY `FK4yfxe0cn8335akitp4r4dc3wc` (`supplier_supplier_id`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_supplier`
--

LOCK TABLES `product_supplier` WRITE; 
/*!40000 ALTER TABLE `product_supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reorder`
--

DROP TABLE IF EXISTS `reorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reorder` (
  `reorder_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `arrival_date` bigint(20) DEFAULT NULL,
  `expected_date` bigint(20) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `reorder_at` bigint(20) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `total_cost` float DEFAULT NULL,
  `unit_cost` float DEFAULT NULL,
  `product_supplier_id` bigint(20) NOT NULL,
  PRIMARY KEY (`reorder_id`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--  ,
 -- FOREIGN KEY (`product_supplier_id`) REFERENCES product_supplier(product_supllier_id)
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reorder`
--

LOCK TABLES `reorder` WRITE;
/*!40000 ALTER TABLE `reorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `reorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_customer`
--

DROP TABLE IF EXISTS `return_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `return_customer` (
  `return_customer_id` bigint(20) DEFAULT NULL,
  `return_id` bigint(20) NOT NULL,
  PRIMARY KEY (`return_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_customer`
--

LOCK TABLES `return_customer` WRITE;
/*!40000 ALTER TABLE `return_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_seq`
--

DROP TABLE IF EXISTS `return_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `return_seq` (
  `return_seq_next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_seq`
--

LOCK TABLES `return_seq` WRITE;
/*!40000 ALTER TABLE `return_seq` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_user`
--

DROP TABLE IF EXISTS `staff_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_user` (
  `staff_user_id` bigint(20) NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `payroll_id` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`staff_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_user`
--

LOCK TABLES `staff_user` WRITE;
/*!40000 ALTER TABLE `staff_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_user_seq`
--

DROP TABLE IF EXISTS `staff_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_user_seq` (
  `staff_user_seq_next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_user_seq`
--

LOCK TABLES `staff_user_seq` WRITE;
/*!40000 ALTER TABLE `staff_user_seq` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `supplier_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `is_using2fa` bit(1) NOT NULL,
  `job_industry` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `postcode` int(11) NOT NULL,
  `secret` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,NULL,'admin@email.com','Sarabjeet Singh',NULL,_binary '\0',NULL,NULL,NULL,'$2a$10$92k5aBofnKOUyiTOsyAj2ect9GqcqHrmHv8JWzwcBd6HcS4k1hL8K',0,'T7BS2DBRUQRKZ65MNSATNLVWRJFCUZFF',NULL,'admin'),(2,NULL,NULL,NULL,'noahmiller238@gmail.com','John Doe',NULL,_binary '\0',NULL,NULL,NULL,'$2a$10$MqNmGEejvviACg.IbyIRTuz8MrsoBKU0ESTAPapuFEKLja2SZu1tK',0,'JQU3DAY32QRJKS5FVQJVKOB3QWLWR5F4',NULL,'johnsmith');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_access_control_role`
--

DROP TABLE IF EXISTS `user_access_control_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_access_control_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_access_control_role`
--

LOCK TABLES `user_access_control_role` WRITE;
/*!40000 ALTER TABLE `user_access_control_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_access_control_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_extra_privilege`
--

DROP TABLE IF EXISTS `user_extra_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_extra_privilege` (
  `user_id` bigint(20) NOT NULL,
  `privilege_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_extra_privilege`
--

LOCK TABLES `user_extra_privilege` WRITE;
/*!40000 ALTER TABLE `user_extra_privilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_extra_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse_user`
--

DROP TABLE IF EXISTS `warehouse_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehouse_user` (
  `warehouse_user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department` int(11) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`warehouse_user_id`),
  UNIQUE KEY `UK_dp9vm47wyl2c7utenba4pt1mh` (`email`),
  UNIQUE KEY `UK_gli3oyqledvc8c8hepxj9fj96` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse_user`
--

LOCK TABLES `warehouse_user` WRITE;
/*!40000 ALTER TABLE `warehouse_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `warehouse_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-16 10:08:07
