CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `created_date` timestamp NOT NULL DEFAULT now() COMMENT '创建时间',
  `updated_date` timestamp NOT NULL DEFAULT now() COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
insert  into `sys_user`(`id`,`username`,`password`,`phone`,`email`) values
(1,'admin','$2a$10$9ZhDOBp.sRKat4l14ygu/.LscxrMUcDAfeVOEPiYwbcRkoB09gCmi','15888888888','theboyaply@mail.com');

CREATE TABLE `sys_permission` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`parent_id` bigint(20) DEFAULT NULL COMMENT '父权限',
	`name` varchar(64) NOT NULL COMMENT '权限名称',
	`enname` varchar(64) NOT NULL COMMENT '权限英文名称',
	`url` varchar(255) NOT NULL COMMENT '授权路径',
	`description` varchar(200) DEFAULT NULL COMMENT '备注',
	`created_date` timestamp NOT NULL DEFAULT now() COMMENT '创建时间',
  `updated_date` timestamp NOT NULL DEFAULT now() COMMENT '最后更新时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB AUTO_INCREMENT = 7 DEFAULT CHARSET = utf8 COMMENT = '权限表';
insert  into `sys_permission`(`id`,`parent_id`,`name`,`enname`,`url`,`description`,`created_date`,`updated_date`) values
(1,0,'系统管理','System','/',NULL,'2019-04-04 23:22:54','2019-04-04 23:22:56'),
(2,1,'用户管理','SystemUser','/users/',NULL,'2019-04-04 23:25:31','2019-04-04 23:25:33'),
(3,2,'查看用户','SystemUserView','/users/view/**',NULL,'2019-04-04 15:30:30','2019-04-04 15:30:43'),
(4,2,'新增用户','SystemUserInsert','/users/insert/**',NULL,'2019-04-04 15:30:31','2019-04-04 15:30:44'),
(5,2,'编辑用户','SystemUserUpdate','/users/update/**',NULL,'2019-04-04 15:30:32','2019-04-04 15:30:45'),
(6,2,'删除用户','SystemUserDelete','/users/delete/**',NULL,'2019-04-04 15:30:48','2019-04-04 15:30:45');

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父角色',
  `name` varchar(64) NOT NULL COMMENT '角色名称',
  `enname` varchar(64) NOT NULL COMMENT '角色英文名称',
  `description` varchar(200) DEFAULT NULL COMMENT '备注',
  `created_date` timestamp NOT NULL DEFAULT now() COMMENT '创建时间',
  `updated_date` timestamp NOT NULL DEFAULT now() COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色表';
insert  into `sys_role`(`id`,`parent_id`,`name`,`enname`,`description`,`created_date`,`updated_date`) values
(1,0,'超级管理员','admin',NULL,'2019-04-04 23:22:03','2019-04-04 23:22:05');

CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色 ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限 ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色权限表';
insert  into `sys_role_permission`(`id`,`role_id`,`permission_id`) values
(1,1,1),
(2,1,2),
(3,1,3),
(4,1,4),
(5,1,5),
(6,1,6);

CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户 ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色 ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户角色表';
insert  into `sys_user_role`(`id`,`user_id`,`role_id`) values
(1,1,1);
