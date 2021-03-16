-- 日志表
CREATE TABLE `sys_log` (
  `log_id` varchar(255) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `os` varchar(255) NOT NULL,
  `browser` varchar(255) NOT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `url` varchar(255)  NOT NULL,
  `header` varchar(255) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

