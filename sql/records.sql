CREATE TABLE `records` (
  `id` varchar(14) NOT NULL DEFAULT '',
  `typ` tinyint(1) unsigned NOT NULL,
  `delay_to` bigint(20) unsigned DEFAULT NULL,
  `req_typ` varchar(10) NOT NULL DEFAULT '',
  `req_url` varchar(1024) NOT NULL DEFAULT '',
  `req_content` text,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;