-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: vocabulary
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `vocab`
--

DROP TABLE IF EXISTS `vocab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vocab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dictionary` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `masu` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `te` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kanji` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `meaning` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vocab`
--

LOCK TABLES `vocab` WRITE;
/*!40000 ALTER TABLE `vocab` DISABLE KEYS */;
INSERT INTO `vocab` VALUES (1,'はいる','はいります','はいって','入る','to enter'),(2,'つける','つけます','つけて',NULL,'to turn on'),(3,'よむ','よみます','よんで','読む','to read'),(4,'かす','かします','かして',NULL,'to lend'),(5,'すてる','すてます','すてて',NULL,'to throw away'),(6,'あるく','あるきます','あるいて','歩く','to walk'),(7,'のる','のります','のって',NULL,'to ride'),(8,'かえす','かえします','かえして',NULL,'to return a thing'),(9,'のむ','のみます','のんで','飲む','to drink'),(10,'ねる','ねます','ねて',NULL,'to sleep'),(11,'かかる','かかります','かかって',NULL,'to take (amount of time / money)'),(12,'およぐ','およぎます','およいで',NULL,'to swim'),(13,'でかける','でかけます','でかけて','出かける','to go out'),(14,'いく','いきます','いって','行く','to go'),(15,'おきる','おきます','おきて',NULL,'to get up'),(16,'まつ','まちます','まって','待つ','to wait'),(17,'おしえる','おしえます','おしえて',NULL,'to teach'),(18,'きる','きります','きって',NULL,'to cut'),(19,'おりる','おります','おりて',NULL,'to get off'),(20,'おもう','おもいます','おもって',NULL,'to think'),(21,'かく','かきます','かいて','書く','to write'),(22,'つくる','つくります','つくって','作る','to make'),(23,'とる','とります','とって',NULL,'to take'),(24,'ふる','ふります','ふって',NULL,'to fall from the sky'),(25,'あける','あけます','あけて','開ける','to open something'),(26,'かえる','かえります','かえって','帰る','to return home'),(27,'はく','はきます','はいて',NULL,'to put on (below the waist)'),(28,'くる','きます','きて','来る','to come'),(29,'する','します','して',NULL,'to do'),(30,'うんてんする','うんてんします','うんてんして',NULL,'to drive'),(31,'みる','みます','みて','見る','to see'),(32,'かう','かいます','かって',NULL,'to keep (a pet)'),(33,'きる','きます','きて',NULL,'to wear (above the waist)'),(34,'しる','しります','しって',NULL,'to know'),(35,'さわる','さわります','さわって',NULL,'to touch'),(36,'わかる','わかります','わかって','分かる','to understand'),(37,'てつだう','てつだいます','てつだって',NULL,'to help'),(38,'つる','つります','つって',NULL,'to fish'),(39,'はなす','はなします','はなして','話す','to speak / to talk'),(40,'しめる','しめます','しめて','閉める','to close something'),(41,'かぶる','かぶります','かぶって',NULL,'to wear on your head'),(42,'つれてくる','つれてきます','つれてきて',NULL,'to bring a person'),(43,'もつ','持ちます','もって','持つ','to carry / to hold'),(44,'かう','かいます','かって','買う','to buy'),(45,'わすれる','わすれます','わすれて',NULL,'to forget'),(46,'もってくる','もってきます','もってきて',NULL,'to bring a thing'),(47,'やすむ','やすみます','やすんで','休む','to be absent / to rest'),(48,'いれる','いれます','いれて','入れる','to put in'),(49,'あう','あいます','あって','会う','to meet'),(50,'たべる','たべます','たべて','食べる','to eat'),(51,'でんわをかける','でんわをかけます','でんわをかけて','電話をかける','to make a phone call'),(52,'つかう','つかいます','つかって','使う','to use / to spend'),(53,'かりる','かります','かりて',NULL,'to borrow'),(54,'きく','ききます','きいて','聞く','to listen / to ask'),(55,'ならう','ならいます','ならって',NULL,'to learn'),(56,'シャワーをあびる','シャワーをあびます','シャワーをあびて',NULL,'to take a shower'),(57,'にずくりする','にずくりします','にずくりして',NULL,'to pack'),(58,'おく','おきます','おいて',NULL,'to put'),(59,'よやくする','よやくします','よやくして',NULL,'to make a reservation'),(60,'みせる','みせます','みせて','見せる','to show'),(61,'にげる','にげます','にげて',NULL,'to escape'),(62,'かたずける','かたずけます','かたずけて',NULL,'to clean up'),(63,'せつめいする','せつめいします','せつめいして',NULL,'to explain'),(64,'さそう','さそいます','さそって',NULL,'to invite'),(65,'おどる','おどります','おどって',NULL,'to dance'),(66,'おす','おします','おして',NULL,'to push (button/switch/etc)'),(67,'あらう','あらいます','あらって',NULL,'to wash'),(68,'かいぎする','かいぎします','かいぎして',NULL,'meeting (office)'),(69,'そうじする','そうじします','そうじして',NULL,'to vaccum'),(70,'かくにする','かくにします','かくにして',NULL,'to check'),(71,'ぬれる','ぬれます','ぬれて',NULL,'to become wet'),(72,'ことわる','ことわります','ことわって',NULL,'to refuse / to decline');
/*!40000 ALTER TABLE `vocab` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11 19:45:07
