DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `role_permission`;
DROP TABLE IF EXISTS `permission`;

CREATE TABLE `user` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`usercode` varchar(255) NOT NULL,
`username` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL,
`salt` varchar(255) NOT NULL,
`del` int(2) NOT NULL default 0,
PRIMARY KEY (`id`) 
);
CREATE TABLE `role` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`role_code` varchar(255) NOT NULL,
`role_name` varchar(255) NOT NULL,
PRIMARY KEY (`id`) 
);
CREATE TABLE `user_role` (
`user_id` bigint(11) NOT NULL,
`role_id` bigint(11) NOT NULL
);
CREATE TABLE `role_permission` (
`role_id` bigint(11) NOT NULL,
`permission_id` bigint(11) NOT NULL
);
CREATE TABLE `permission` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) NOT NULL,
`code` varchar(255) NOT NULL,
`type` int(10) NOT NULL,
`url` varchar(255) NOT NULL,
`sort` int(10) NOT NULL,
`description` varchar(255) NULL,
`pid` bigint(11) NOT NULL,
PRIMARY KEY (`id`) 
);

INSERT INTO user (id, usercode,username, password,salt,del) VALUES (1,'user','user','$2a$10$Nt9a.K.zflcnwTLDFmFWle5ppVC3TIrKJJBzRH1V3iBKQ/rduRmq6','user',0);
INSERT INTO user (id, usercode,username, password,salt,del) VALUES (2,'admin','admin','$2a$10$Nt9a.K.zflcnwTLDFmFWle5ppVC3TIrKJJBzRH1V3iBKQ/rduRmq6','admin',0);
INSERT INTO user (id, usercode,username, password,salt,del) VALUES (3,'anchao','anchao','$2a$10$Nt9a.K.zflcnwTLDFmFWle5ppVC3TIrKJJBzRH1V3iBKQ/rduRmq6','anchao',0);

INSERT INTO role (id, role_code,role_name) VALUES (1,'USER','普通用户');
INSERT INTO role (id, role_code,role_name) VALUES (2,'ADMIN','管理员');

INSERT INTO permission (id, name, code, type,url,sort,description,pid) VALUES (1,'查看税','taxQuery',0,'/tax/query.html',0,'暂无描述',0);
INSERT INTO permission (id, name, code, type,url,sort,description,pid) VALUES (2,'添加税','taxAdd',0,'/tax/add.html',1,'暂无描述',0);


INSERT INTO user_role (user_id, role_id) VALUES (1, 1),(2, 2),(3, 2);
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 1),(2, 1),(2, 2);
