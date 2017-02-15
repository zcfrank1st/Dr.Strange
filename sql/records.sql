CREATE TABLE `records` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `execute_time` datetime NOT NULL,
  `typ` tinyint(1) unsigned NOT NULL,
  `delay_time` bigint(20) unsigned DEFAULT NULL,
  `req_typ` varchar(10) NOT NULL DEFAULT '',
  `req_url` varchar(1024) NOT NULL DEFAULT '',
  `req_content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;