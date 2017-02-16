CREATE TABLE `records` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `typ` tinyint(1) unsigned NOT NULL,
  `delay_to` bigint(20) unsigned DEFAULT NULL,
  `req_typ` varchar(10) NOT NULL DEFAULT '',
  `req_url` varchar(1024) NOT NULL DEFAULT '',
  `req_content` text,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;