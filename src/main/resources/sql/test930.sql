/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.62 : Database - securitydemo
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

/*Table structure for table `sys_pemission` */

DROP TABLE IF EXISTS `sys_pemission`;

CREATE TABLE `sys_pemission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `css` varchar(30) DEFAULT NULL,
  `href` varchar(1000) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `pemission` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_pemission` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `descirption` varchar(100) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`descirption`,`createtime`,`updatetime`) values (1,'ADMIN',NULL,NULL,NULL),(2,'USER',NULL,NULL,NULL),(3,'TEACHER',NULL,NULL,NULL),(4,'test',NULL,NULL,NULL);

/*Table structure for table `sys_role_pemission` */

DROP TABLE IF EXISTS `sys_role_pemission`;

CREATE TABLE `sys_role_pemission` (
  `roleid` int(11) DEFAULT NULL,
  `pemissionid` int(11) DEFAULT NULL,
  KEY `FK_sys_role_pemisssion` (`pemissionid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `sys_role_pemission_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FK_sys_role_pemisssion` FOREIGN KEY (`pemissionid`) REFERENCES `sys_pemission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_pemission` */

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  KEY `FK_sys_user_role` (`userid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FK_sys_user_role` FOREIGN KEY (`userid`) REFERENCES `sys_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

/*Table structure for table `sys_users` */

DROP TABLE IF EXISTS `sys_users`;

CREATE TABLE `sys_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(55) DEFAULT NULL,
  `password` varchar(55) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `sys_users` */

insert  into `sys_users`(`id`,`username`,`password`,`phone`,`dept`,`email`,`headimage`,`gangweimingcheng`,`status`,`createtime`,`updatetime`,`birthday`,`sex`) values (1,'zhangsan','123456','123456789','zhuzha','456@qq.com',NULL,'guanliyuan',1,NULL,NULL,'2019-01-12',NULL),(2,'lisi','123','112',NULL,'456@qq.com',NULL,NULL,1,NULL,NULL,'2019-07-15',NULL),(3,'wangwu','345',NULL,NULL,'456@qq.com',NULL,NULL,0,NULL,NULL,'2019-09-06',NULL),(4,'zhaoliu','543',NULL,NULL,'456@qq.com',NULL,NULL,1,NULL,NULL,NULL,NULL),(5,'liuqi','555',NULL,NULL,'456@qq.com',NULL,NULL,0,NULL,NULL,NULL,NULL),(6,'wangba','666',NULL,NULL,'456@qq.com',NULL,NULL,1,NULL,NULL,NULL,NULL),(7,'wangjiu','777',NULL,NULL,'456@qq.com',NULL,NULL,1,NULL,NULL,NULL,NULL),(8,'wangshi','222',NULL,NULL,'456@qq.com',NULL,NULL,0,NULL,NULL,NULL,NULL),(9,'wangshiyi','888',NULL,NULL,'456@qq.com',NULL,NULL,0,NULL,NULL,NULL,NULL),(10,'wangshier','555',NULL,NULL,'456@qq.com',NULL,NULL,1,NULL,NULL,NULL,NULL),(11,'wangshisan','111',NULL,NULL,'456@qq.com',NULL,NULL,1,NULL,NULL,NULL,NULL),(12,'wangshisi','333',NULL,NULL,'456@qq.com',NULL,NULL,0,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
