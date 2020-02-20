DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `author` varchar(256) DEFAULT NULL,
  `price` varchar(256) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`id`, `name`, `author`, `price`, `status`)
VALUES
	(1,'数据结构教程（第五版）','李春葆','59.50',0),
	(2,'数据库系统原理与设计','万常选','59.90',0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;