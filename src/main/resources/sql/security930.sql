/*
SQLyog Enterprise - MySQL GUI
MySQL - 5.5.62 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `sys_users` (
	`id` double ,
	`username` varchar (165),
	`password` varchar (165),
	`phone` varchar (165),
	`dept` varchar (165),
	`email` varchar (165),
	`headimage` varchar (450),
	`gangweimingcheng` varchar (165)
); 
insert into `sys_users` (`id`, `username`, `password`, `phone`, `dept`, `email`, `headimage`, `gangweimingcheng`) values('1','zhangsan','123456','123456789','zhuzha','456@qq.com',NULL,'guanliyuan');
