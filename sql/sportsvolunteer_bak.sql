-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.4-m14-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 sportsvolunteer 的数据库结构
DROP DATABASE IF EXISTS `sportsvolunteer`;
CREATE DATABASE IF NOT EXISTS `sportsvolunteer` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sportsvolunteer`;

-- 导出  表 sportsvolunteer.enterprise 结构
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE IF NOT EXISTS `enterprise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `enterpriseName` varchar(50) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phonenumber` varchar(20) DEFAULT NULL,
  `business` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  sportsvolunteer.enterprise 的数据：~6 rows (大约)
DELETE FROM `enterprise`;
/*!40000 ALTER TABLE `enterprise` DISABLE KEYS */;
INSERT INTO `enterprise` (`id`, `username`, `password`, `enterpriseName`, `address`, `phonenumber`, `business`) VALUES
	(1, 'admin', 'ISMvKXpXpadDiUoOSoAfww==', '呵呵企业', '', NULL, NULL),
	(2, 'root', 'Y6nw6nu5gFB5a2SehUgYRQ==', '哈哈企业', '', NULL, NULL),
	(3, 'gg', '4QrcOUm6Wau+VuBX8g+IPg==', '上海体育', '上海', '1838983728', '无'),
	(4, 'mm', '4QrcOUm6Wau+VuBX8g+IPg==', '中国移动', '甚至', '121212', '电话服务'),
	(5, 'ee', '4QrcOUm6Wau+VuBX8g+IPg==', 'ee', 'eeee', '121212', '22313'),
	(6, 'st', '4QrcOUm6Wau+VuBX8g+IPg==', '上海体育学院', '上海市杨浦区', '15201799999', '承办体育赛事'),
	(7, '企业1', '4QrcOUm6Wau+VuBX8g+IPg==', '1体育公司', '上海市杨浦区', '15201112222', '承办体育赛事');
/*!40000 ALTER TABLE `enterprise` ENABLE KEYS */;

-- 导出  表 sportsvolunteer.game 结构
DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL COMMENT '比赛介绍',
  `jobdescription` varchar(200) NOT NULL COMMENT '工作介绍',
  `begintime` timestamp NULL DEFAULT NULL,
  `endtime` timestamp NULL DEFAULT NULL,
  `address` varchar(100) NOT NULL,
  `salary` float NOT NULL,
  `personcount` int(11) NOT NULL,
  `enterpriseid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='比赛';

-- 正在导出表  sportsvolunteer.game 的数据：~19 rows (大约)
DELETE FROM `game`;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` (`id`, `name`, `description`, `jobdescription`, `begintime`, `endtime`, `address`, `salary`, `personcount`, `enterpriseid`) VALUES
	('09b779bc-1c8c-4b06-9ccc-b7d5a19c3474', 'cc', 'casdfasdfasdfasdfas', 'asdfasdf', '2018-01-07 00:03:00', '2018-01-15 00:03:00', 'asdf', 1213120, 100, 3),
	('0da4a71f-8c86-4902-87c2-35cd4d6e9ada', 'ee比赛', '呃呃呃深刻搭街坊卡时间的', '阿斯顿发生', '2018-01-04 00:04:00', '2018-01-04 00:04:00', '111', 111, 11, 5),
	('115eba06-1b1c-4ea4-b1a2-91616d766d78', '333', '333', '333', '2018-01-08 00:03:00', '2018-01-15 00:03:00', '33', 333, 22, 3),
	('1338c66f-06bf-4666-bfa1-cb3c7e12e8e3', '赛事2', '体育赛事', '志愿者工作', '2018-01-01 00:02:00', '2018-01-03 00:02:00', '上海足球场', 500, 10, 7),
	('1fe177c8-05bd-4036-8631-c308ccdc07e7', '555', '567576', '7687687', '2018-01-07 00:04:00', '2018-01-12 00:04:00', 'uykh', 76876, 454, 5),
	('27aaad7b-4022-4230-b819-4fc7397ba89e', '奥运会111', '各项比赛', '维护秩序等', '2018-01-01 00:01:00', '2018-01-31 00:01:00', '上海体育场', 500, 20, 6),
	('2a98f15e-c5e8-4b96-b03d-7972df092714', 'a', 'aaaaaa', 'hkdaad', '2018-01-22 00:03:00', '2018-01-24 00:03:00', 'shanghai', 122, 33, 3),
	('2b6a2128-9c4e-4787-9a25-b0aa3d7d78e1', '赛事1', '体育赛事', '志愿者工作', '2018-01-01 00:01:00', '2018-01-03 00:01:00', '上海体育场', 300, 9, 7),
	('463007ef-b76a-4705-bc46-b15674270a5a', 'enh', 'hehe', 'ksjdflaj', '2018-01-31 00:12:00', '2018-01-31 00:12:00', 'kdsjflkajsdlfkj', 1213, 1212, 4),
	('54732d49-5323-474a-9dec-ada001ac6f4e', '555', '567576', '7687687', '2018-01-07 00:04:00', '2018-01-12 00:04:00', 'uykh', 76876, 454, 5),
	('5d741324-b8a0-43ce-8744-a06db16c019a', '7', '7', '7', '2017-01-08 00:03:00', '2018-01-08 00:03:00', '7', 7, 34, 3),
	('8fbc0b56-3d31-402e-8ed5-a4b9e3d2f17c', '赛事3', '体育赛事', '维护秩序', '2018-01-02 00:01:00', '2018-01-05 00:01:00', '上海游泳馆', 300, 2, 7),
	('a57ad695-e479-41c0-885c-cdc224e72e83', '5', '5', '5', '2018-01-15 00:03:00', '2018-01-28 00:02:00', '5', 5, 3, 3),
	('b29e1cf6-84db-496b-9cf4-58f394dd003e', '奥运会222', '12222', 'a\'s\'d\'fa\'s\'d\'f', '2018-01-06 00:04:00', '2018-01-04 00:04:00', '阿斯顿发生', 1212, 2, 6),
	('b35fa737-d467-44ab-9c99-bbedd3fe7f20', '移动专属', '呵呵', '大大', '2018-01-31 00:01:00', '2019-01-30 00:12:00', '呵呵', 222, 2, 4),
	('b7a8a7a0-1e76-4919-8b6b-5e390db18097', '6', '6', '6', '2018-01-28 00:02:00', '2018-01-01 00:03:00', '6', 6, 333, 3),
	('c0dc8dad-72ec-4323-8c8e-cecbbb3027c3', '赛事5', '健身', '介绍规则', '2018-01-01 00:03:00', '2018-01-01 00:03:00', '篮球场', 300, 1, 7),
	('c46394db-d010-4504-845c-75158c332d0e', '3', '3', '3', '2018-01-30 00:03:00', '2018-01-28 00:03:00', '3', 3, 3, 6),
	('cf65b12a-1ef6-4ed4-b1e1-bde1b0bad7f6', 'd', 'ddddd', 'adsfasdf', '2018-01-07 00:03:00', '2018-01-14 00:03:00', 'asdfasdfasdf', 12113200000, 44, 3),
	('ef1402c3-26c3-4dcd-8703-5a719afd4a31', '赛事4', '马拉松', '发放物资', '2018-01-08 00:04:00', '2018-01-08 00:04:00', '上海市', 200, 20, 7),
	('fd0b6c90-b329-42e2-a447-2855863e1e6f', 'haha', 'hahaksjdfklasfd', 'kajsdlf;kajsd;kflj', '2018-01-31 00:12:00', '2018-01-30 00:12:00', 'akksdjfla;kjsdf', 1231, 12, 4);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;

-- 导出  表 sportsvolunteer.game_volunteer 结构
DROP TABLE IF EXISTS `game_volunteer`;
CREATE TABLE IF NOT EXISTS `game_volunteer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gameid` varchar(50) NOT NULL DEFAULT '0',
  `volunteerid` varchar(50) NOT NULL DEFAULT '0',
  `pass` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_game_volunteer_game` (`gameid`),
  KEY `FK_game_volunteer_volunteer` (`volunteerid`),
  CONSTRAINT `FK_game_volunteer_game` FOREIGN KEY (`gameid`) REFERENCES `game` (`id`),
  CONSTRAINT `FK_game_volunteer_volunteer` FOREIGN KEY (`volunteerid`) REFERENCES `volunteer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='赛事与志愿者的关系表';

-- 正在导出表  sportsvolunteer.game_volunteer 的数据：~25 rows (大约)
DELETE FROM `game_volunteer`;
/*!40000 ALTER TABLE `game_volunteer` DISABLE KEYS */;
INSERT INTO `game_volunteer` (`id`, `gameid`, `volunteerid`, `pass`) VALUES
	(2, 'b35fa737-d467-44ab-9c99-bbedd3fe7f20', 'e82a14a2-8a94-4a39-b085-756828478aee', NULL),
	(3, '5d741324-b8a0-43ce-8744-a06db16c019a', 'e82a14a2-8a94-4a39-b085-756828478aee', NULL),
	(4, '5d741324-b8a0-43ce-8744-a06db16c019a', '63e7559b-e537-4984-a5d8-4a104accd1f8', NULL),
	(5, '0da4a71f-8c86-4902-87c2-35cd4d6e9ada', '63e7559b-e537-4984-a5d8-4a104accd1f8', NULL),
	(6, '09b779bc-1c8c-4b06-9ccc-b7d5a19c3474', '63e7559b-e537-4984-a5d8-4a104accd1f8', NULL),
	(7, 'cf65b12a-1ef6-4ed4-b1e1-bde1b0bad7f6', '63e7559b-e537-4984-a5d8-4a104accd1f8', NULL),
	(8, '2a98f15e-c5e8-4b96-b03d-7972df092714', '63e7559b-e537-4984-a5d8-4a104accd1f8', NULL),
	(9, '115eba06-1b1c-4ea4-b1a2-91616d766d78', '63e7559b-e537-4984-a5d8-4a104accd1f8', NULL),
	(10, 'b7a8a7a0-1e76-4919-8b6b-5e390db18097', 'e82a14a2-8a94-4a39-b085-756828478aee', NULL),
	(11, 'b7a8a7a0-1e76-4919-8b6b-5e390db18097', '63e7559b-e537-4984-a5d8-4a104accd1f8', NULL),
	(12, 'b7a8a7a0-1e76-4919-8b6b-5e390db18097', '2d757c11-1839-477a-955a-ef07b92c6b11', NULL),
	(13, '5d741324-b8a0-43ce-8744-a06db16c019a', '2d757c11-1839-477a-955a-ef07b92c6b11', NULL),
	(14, '5d741324-b8a0-43ce-8744-a06db16c019a', '7ef4cd78-09ef-4790-9c36-f43b34badfe5', NULL),
	(15, '0da4a71f-8c86-4902-87c2-35cd4d6e9ada', '7ef4cd78-09ef-4790-9c36-f43b34badfe5', NULL),
	(16, '0da4a71f-8c86-4902-87c2-35cd4d6e9ada', 'e82a14a2-8a94-4a39-b085-756828478aee', NULL),
	(17, 'cf65b12a-1ef6-4ed4-b1e1-bde1b0bad7f6', 'e82a14a2-8a94-4a39-b085-756828478aee', NULL),
	(18, '27aaad7b-4022-4230-b819-4fc7397ba89e', '0e116215-2d4c-490b-bc86-399feb1653a0', NULL),
	(19, '0da4a71f-8c86-4902-87c2-35cd4d6e9ada', '0e116215-2d4c-490b-bc86-399feb1653a0', NULL),
	(20, 'b29e1cf6-84db-496b-9cf4-58f394dd003e', '0e116215-2d4c-490b-bc86-399feb1653a0', NULL),
	(21, '5d741324-b8a0-43ce-8744-a06db16c019a', '0e116215-2d4c-490b-bc86-399feb1653a0', NULL),
	(22, 'cf65b12a-1ef6-4ed4-b1e1-bde1b0bad7f6', '0e116215-2d4c-490b-bc86-399feb1653a0', NULL),
	(23, '09b779bc-1c8c-4b06-9ccc-b7d5a19c3474', '0e116215-2d4c-490b-bc86-399feb1653a0', NULL),
	(24, 'c46394db-d010-4504-845c-75158c332d0e', '0e116215-2d4c-490b-bc86-399feb1653a0', NULL),
	(25, 'b29e1cf6-84db-496b-9cf4-58f394dd003e', 'e82a14a2-8a94-4a39-b085-756828478aee', NULL),
	(26, '5d741324-b8a0-43ce-8744-a06db16c019a', 'df5403b7-b203-4838-b6cb-c3062470377a', NULL),
	(27, '0da4a71f-8c86-4902-87c2-35cd4d6e9ada', '2d757c11-1839-477a-955a-ef07b92c6b11', NULL),
	(28, 'fd0b6c90-b329-42e2-a447-2855863e1e6f', 'e82a14a2-8a94-4a39-b085-756828478aee', NULL),
	(29, '5d741324-b8a0-43ce-8744-a06db16c019a', '71aefb2b-b4c7-4fac-a628-9565eef1bfe3', NULL),
	(30, '1338c66f-06bf-4666-bfa1-cb3c7e12e8e3', '71aefb2b-b4c7-4fac-a628-9565eef1bfe3', NULL);
/*!40000 ALTER TABLE `game_volunteer` ENABLE KEYS */;

-- 导出  表 sportsvolunteer.manager 结构
DROP TABLE IF EXISTS `manager`;
CREATE TABLE IF NOT EXISTS `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL DEFAULT '0',
  `password` varchar(30) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  sportsvolunteer.manager 的数据：~2 rows (大约)
DELETE FROM `manager`;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` (`id`, `username`, `password`) VALUES
	(1, 'root', 'Y6nw6nu5gFB5a2SehUgYRQ=='),
	(2, 'admin', 'ISMvKXpXpadDiUoOSoAfww==');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;

-- 导出  表 sportsvolunteer.volunteer 结构
DROP TABLE IF EXISTS `volunteer`;
CREATE TABLE IF NOT EXISTS `volunteer` (
  `id` varchar(50) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `gender` varchar(4) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `idcardnumber` varchar(20) DEFAULT NULL,
  `phonenumber` varchar(20) DEFAULT NULL,
  `specialskill` varchar(100) DEFAULT NULL,
  `registertime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  sportsvolunteer.volunteer 的数据：~5 rows (大约)
DELETE FROM `volunteer`;
/*!40000 ALTER TABLE `volunteer` DISABLE KEYS */;
INSERT INTO `volunteer` (`id`, `age`, `username`, `password`, `gender`, `address`, `idcardnumber`, `phonenumber`, `specialskill`, `registertime`) VALUES
	('0e116215-2d4c-490b-bc86-399feb1653a0', 0, '张三', '4QrcOUm6Wau+VuBX8g+IPg==', '男', '上海', '411123188889898', '17822224444', '无', '2018-04-01 16:42:06'),
	('2d757c11-1839-477a-955a-ef07b92c6b11', 0, 'sky4', '4QrcOUm6Wau+VuBX8g+IPg==', '男', 'sk;ldjfklasjdf', '1212', '9088', 'kjlskjf', '2018-04-01 16:08:20'),
	('63e7559b-e537-4984-a5d8-4a104accd1f8', 22, 'sky2', '4QrcOUm6Wau+VuBX8g+IPg==', '男', 'ksjdkfjalksdj;flaksjfd', '1312443234234', '1121312131', 'hehe', '2018-04-01 15:54:01'),
	('71aefb2b-b4c7-4fac-a628-9565eef1bfe3', 20, '志愿者1', '4QrcOUm6Wau+VuBX8g+IPg==', '男', '上海市杨浦区', '411123188889898', '14234562222', '无', '2018-04-08 22:16:13'),
	('7ef4cd78-09ef-4790-9c36-f43b34badfe5', 0, 'sky3', '4QrcOUm6Wau+VuBX8g+IPg==', '女', 'skajd;laksjdf;klajsdff;lkafj', '23489748604897459874', '12132323', 'skjd;flkjasdkfj;sd', '2018-04-01 16:00:44'),
	('df5403b7-b203-4838-b6cb-c3062470377a', 121222, 'test', '4QrcOUm6Wau+VuBX8g+IPg==', '男', '12121', '6567', '21212', 'hlkjh', '2018-04-01 17:57:49'),
	('e82a14a2-8a94-4a39-b085-756828478aee', 554, 'sky4444', '4QrcOUm6Wau+VuBX8g+IPg==', '男', 'hehe5544444444', '113131121313', '123123123', 'meiyou123123123', '2018-04-19 21:21:07');
/*!40000 ALTER TABLE `volunteer` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
