/*
SQLyog Ultimate v8.32 
MySQL - 5.5.49 : Database - securitydemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`securitydemo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `securitydemo`;

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `css` varchar(30) DEFAULT NULL,
  `href` varchar(1000) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `permission` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

insert  into `sys_permission`(`id`,`parentid`,`name`,`css`,`href`,`type`,`permission`,`sort`) values (1,0,'用户管理','&#xe696;',NULL,1,NULL,1),(2,1,'用户查询','&#xe6b8;','/api/getPage?pageName=user/user-list',1,NULL,2),(3,2,'查询',NULL,NULL,2,'sys:user:query',100),(4,2,'新增',NULL,NULL,2,'sys:user:add',100),(5,2,'删除',NULL,NULL,2,'sys:user:del',100),(6,1,'修改密码','&#xe74e;','/api/getPage?pageName=user/user-change-password',1,'sys:user:password',4),(7,0,'系统设置','&#xe75f;',NULL,1,NULL,5),(8,7,'菜单','&#xe749;','/api/getPage?pageName=permission/permission-list',1,NULL,6),(9,8,'查询',NULL,NULL,2,'sys:menu:query',100),(10,8,'新增',NULL,NULL,2,'sys:menu:add',100),(11,8,'删除',NULL,NULL,2,'sys:menu:del',100),(12,7,'角色','&#xe753;','/api/getPage?pageName=role/role-list',1,NULL,7),(13,12,'查询',NULL,NULL,2,'sys:role:query',100),(14,12,'新增',NULL,NULL,2,'sys:role:add',100),(15,12,'删除',NULL,NULL,2,'sys:role:del',100),(16,0,'文件管理','&#xe735;','/api/getPage?pageName',1,NULL,8),(17,16,'查询',NULL,NULL,2,'sys:file:query',100),(18,16,'删除',NULL,NULL,2,'sys:file:del',100),(19,0,'数据源管理','&#xe722;','druid/index.html',1,NULL,9),(21,0,'接口swagger','&#xe723;','swagger-ui.html',1,NULL,10),(22,0,'代码生成','&#xe715;','/api/getPage?pageName',1,'generate:edit',11),(23,0,'日志查询','&#xe70c;','/api/getPage?pageName',1,'sys:log:query',13),(24,8,'修改',NULL,NULL,2,'sys:menu:edit',100),(25,12,'修改',NULL,NULL,2,'sys:role:edit',100),(26,2,'修改',NULL,NULL,2,'sys:user:edit',100);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `descirption` varchar(100) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`descirption`,`createtime`,`updatetime`) values (1,'ADMIN','管理员','2019-10-10 00:00:00','2019-10-11 00:00:00'),(2,'USER','用户','2019-10-10 00:00:00','2019-10-11 00:00:00'),(3,'TEACHER','教师','2019-10-10 00:00:00','2019-10-11 00:00:00'),(4,'test','测试','2019-10-10 00:00:00','2019-10-11 00:00:00'),(5,'student','学生','2019-10-10 00:00:00','2019-10-10 00:00:00'),(6,'student1','1111','2019-10-10 00:00:00','2019-10-10 00:00:00'),(7,'student2','222','2019-10-10 00:00:00','2019-10-10 00:00:00'),(8,'student3','3333','2019-10-10 00:00:00','2019-10-10 00:00:00'),(9,'student5','55555','2019-10-06 07:31:04','2019-10-06 07:31:04'),(11,'赵安然','仙女','2019-10-07 02:38:09','2019-10-07 02:38:09'),(12,'teacher_holder','一个仙女掌管者','2019-10-11 12:55:24','2019-10-11 12:55:24');

/*Table structure for table `sys_role_permission` */

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `roleid` int(11) DEFAULT NULL,
  `permissionid` int(11) DEFAULT NULL,
  KEY `FK_sys_role_pemisssion` (`permissionid`),
  KEY `roleid` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_permission` */

insert  into `sys_role_permission`(`roleid`,`permissionid`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,21),(1,22),(1,23),(1,25),(8,1),(8,2),(8,3),(8,4),(8,5),(8,26),(8,6),(11,1),(11,2),(11,3),(11,4),(11,5),(11,26),(11,6),(11,7),(11,8),(11,9),(11,10),(11,11),(11,24),(11,12),(11,13),(11,14),(11,15),(11,25),(2,7),(3,7),(3,16),(3,17),(3,18),(12,1),(12,2),(12,3),(12,4),(12,5),(12,26),(12,6),(12,7),(12,8),(12,9),(12,10),(12,11),(12,24),(12,12),(12,13),(12,14),(12,15),(12,25),(12,16),(12,17),(12,18),(12,19),(12,21),(12,22),(12,23);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  KEY `FK_sys_user_role` (`userid`),
  KEY `roleid` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`userid`,`roleid`) values (17,2),(19,4),(20,1),(1,1),(22,12);

/*Table structure for table `sys_users` */

DROP TABLE IF EXISTS `sys_users`;

CREATE TABLE `sys_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(55) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(55) DEFAULT NULL,
  `dept` varchar(55) DEFAULT NULL,
  `email` varchar(55) DEFAULT NULL,
  `headimage` varchar(150) DEFAULT NULL,
  `gangweimingcheng` varchar(55) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `sys_users` */

insert  into `sys_users`(`id`,`username`,`password`,`phone`,`dept`,`email`,`headimage`,`gangweimingcheng`,`status`,`createtime`,`updatetime`,`birthday`,`sex`) values (1,'admin','$2a$10$e8uEJMBhbICkvVAndA.h1ufFIumA9tLYcYmEnkOhtXB3JVxrWmNe.','123456789','zhuzha','456@qq.com',NULL,'guanliyuan',1,NULL,NULL,'2019-01-12',NULL),(5,'liuqi','555',NULL,NULL,'456@qq.com',NULL,NULL,0,NULL,NULL,NULL,NULL),(6,'wangba','666',NULL,NULL,'456@qq.com',NULL,NULL,1,NULL,NULL,NULL,NULL),(7,'wangjiu','777',NULL,NULL,'456@qq.com',NULL,NULL,1,NULL,NULL,NULL,NULL),(8,'wangshi','222',NULL,NULL,'456@qq.com',NULL,NULL,0,NULL,NULL,NULL,NULL),(9,'wangshiyi','888',NULL,NULL,'456@qq.com',NULL,NULL,0,NULL,NULL,NULL,NULL),(10,'wangshier','555',NULL,NULL,'456@qq.com',NULL,NULL,1,NULL,NULL,NULL,NULL),(11,'wangshisan','111',NULL,NULL,'456@qq.com',NULL,NULL,1,NULL,NULL,NULL,NULL),(16,'4567','e10adc3949ba59abbe56e057f20f883e','13455555555',NULL,'56@qq.com',NULL,NULL,1,'2019-10-02 03:41:03','2019-10-02 03:41:03','2019-10-06',NULL),(17,'345','e10adc3949ba59abbe56e057f20f883e','13422222222',NULL,'22@qq.com',NULL,NULL,1,'2019-10-02 03:46:29','2019-10-02 03:46:29','2019-10-07',NULL),(19,'users123','e10adc3949ba59abbe56e057f20f883e','13455555556',NULL,'345@qq.com',NULL,NULL,1,'2019-10-03 11:58:08','2019-10-03 11:58:08','2019-10-01',NULL),(20,'测试123','e10adc3949ba59abbe56e057f20f883e','13455556666',NULL,'67@qq.com',NULL,NULL,1,'2019-10-08 09:57:50','2019-10-08 09:57:50','2019-10-07',NULL),(22,'Amy','$2a$10$qhTuplHaDC/.PI.9/yUwo.Tt/nmq.fCqEhEd2ZWMwTHMJocnI4A8a','14874520935',NULL,'788@qq.com',NULL,NULL,1,'2019-10-11 12:52:56','2019-10-11 12:52:56','2009-07-26',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
