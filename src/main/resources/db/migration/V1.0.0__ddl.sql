CREATE TABLE `user` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `login_name` varchar(255) NOT NULL COMMENT '登录名',
    `nick_name` varchar(255) NOT NULL COMMENT '昵称',
    `password` varchar(255) NOT NULL COMMENT '密码',
    `create_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_dt` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint(3) unsigned DEFAULT '0' COMMENT '是否删除 0正常 1 已删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin AUTO_INCREMENT=60002 COMMENT='用户表';