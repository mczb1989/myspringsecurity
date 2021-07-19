DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`en_name` varchar(50) DEFAULT NULL,
`cn_name` varchar(50) DEFAULT NULL,
`create_time` DATE DEFAULT NULL,
`create_id` int(11) DEFAULT NULL,
`update_time` date DEFAULT NULL,
`update_id` int(11) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tr_role_permission`;
CREATE TABLE `tr_role_permission` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`role_id` bigint(20) DEFAULT NULL,
`permission_id` bigint(20) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into `tb_permission` (id, en_name, cn_name) values (1, 'system:user:read', '可读');
insert into `tb_permission` (id, en_name, cn_name) values (2, 'system:user:edit', '可修改');

insert into `tr_role_permission` (id, role_id, permission_id) values (1, 1, 1);
insert into `tr_role_permission` (id, role_id, permission_id) values (2, 1, 2);
insert into `tr_role_permission` (id, role_id, permission_id) values (3, 2, 1);