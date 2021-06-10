DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`user_name` varchar(50) DEFAULT NULL,
`password` varchar(100) DEFAULT NULL,
`mobile` int(11) DEFAULT NULL,
`sex` int(2) DEFAULT NULL,
`email` varchar(50) DEFAULT NULL,
`status` int(2) DEFAULT NULL,
`create_time` DATE DEFAULT NULL,
`create_id` int(11) DEFAULT NULL,
`update_time` date DEFAULT NULL,
`update_id` int(11) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`role_name` varchar(50) DEFAULT NULL,
`status` int(2) DEFAULT NULL,
`create_time` DATE DEFAULT NULL,
`create_id` int(11) DEFAULT NULL,
`update_time` date DEFAULT NULL,
`update_id` int(11) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tr_user_role`;
CREATE TABLE `tr_user_role` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`user_id` bigint(20) DEFAULT NULL,
`role_id` bigint(20) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;