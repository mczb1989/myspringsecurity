insert into `tb_user` (id, user_name, password) values (1, 'zhangsan', '123');
insert into `tb_user` (id, user_name, password) values (2, 'lisi', '123');
insert into `tb_user` (id, user_name, password) values (3, 'wangwu', '123');

insert into `tb_role` (id, role_name) values (1, '系统管理员');
insert into `tb_role` (id, role_name) values (2, '一般操作员');

insert into `tr_user_role` (id, user_id, role_id) values (1, 1, 1);
insert into `tr_user_role` (id, user_id, role_id) values (2, 1, 2);
insert into `tr_user_role` (id, user_id, role_id) values (3, 2, 2);