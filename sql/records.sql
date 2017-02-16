CREATE TABLE `records` (
  `id` varchar(14) NOT NULL DEFAULT '',
  `typ` tinyint(1) unsigned NOT NULL COMMENT '0 正常 1 定时',
  `delay_to` bigint(20) unsigned DEFAULT NULL COMMENT 'millseconds',
  `req_typ` varchar(10) NOT NULL DEFAULT '',
  `req_url` varchar(1024) NOT NULL DEFAULT '',
  `req_content` text,
  `is_idem` tinyint(1) DEFAULT '0' COMMENT '0 幂等 1 不幂等',
  `status` tinyint(1) DEFAULT NULL COMMENT '0 正在执行 1 失败',
  PRIMARY KEY (`id`),
  KEY `status` (`status`),
  KEY `is_dempotent` (`is_idem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;