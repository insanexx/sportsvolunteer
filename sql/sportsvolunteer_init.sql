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

-- 数据导出被取消选择。
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

-- 数据导出被取消选择。
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

-- 数据导出被取消选择。
-- 导出  表 sportsvolunteer.manager 结构
DROP TABLE IF EXISTS `manager`;
CREATE TABLE IF NOT EXISTS `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL DEFAULT '0',
  `password` varchar(30) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
use sportsvolunteer;
INSERT INTO `manager` (`id`, `username`, `password`) VALUES(1, 'root', 'Y6nw6nu5gFB5a2SehUgYRQ==');

-- 数据导出被取消选择。
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

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
