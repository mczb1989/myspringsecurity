create database myspringsecurity CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
create user securityuser IDENTIFIED by 'securitypass';
grant all privileges on myspringsecurity.* to securityuser@localhost identified by 'securitypass';
flush privileges;