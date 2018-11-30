#插入用户信息表
INSERT INTO user_info(uid,username,`password`,`name`,id_card_num) VALUES (null,'admin','928bfd2577490322a6e19b793691467e','超哥','133333333333333333');
INSERT INTO user_info(uid,username,`password`,`name`,id_card_num) VALUES (null,'test','085de60f32b004402326e5ee425a6167','孙悟空','155555555555555555');
#插入用户角色表
INSERT INTO `sys_role` (`id`,`available`,`description`,`role`) VALUES (null,0,'管理员','admin');
INSERT INTO `sys_role` (`id`,`available`,`description`,`role`) VALUES (null,0,'VIP会员','vip');
INSERT INTO `sys_role` (`id`,`available`,`description`,`role`) VALUES (null,1,'测试','test');
#插入用户_角色关联表
INSERT INTO `sys_user_role` (`role_id`,`uid`) VALUES (1,1);
INSERT INTO `sys_user_role` (`role_id`,`uid`) VALUES (2,2);
#插入权限表
INSERT INTO `sys_permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (null,0,'用户管理',0,'0/','userInfo:view','menu','userInfo/view');
INSERT INTO `sys_permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (null,0,'用户添加',1,'0/1','userInfo:add','button','userInfo/add');
INSERT INTO `sys_permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (null,0,'用户删除',1,'0/1','userInfo:del','button','userInfo/del');
INSERT INTO `sys_permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (null,0,'清除缓存权限',0,'0/1','userInfo:clearCache','button','userInfo/clearCache');
#插入角色_权限表
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (1,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (2,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (3,2);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (1,4);