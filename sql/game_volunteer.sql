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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='赛事与志愿者的关系表';

