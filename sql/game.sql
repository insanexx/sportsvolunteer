use sportsvolunteer;
CREATE TABLE IF NOT EXISTS `game` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL COMMENT '比赛介绍',
  `jobdescription` varchar(200) NOT NULL COMMENT '工作介绍',
  `begintime` timestamp NULL DEFAULT NULL,
  `endtime` timestamp NULL DEFAULT NULL,
  `address` varchar(100) NOT NULL,
  `salary` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='比赛';
