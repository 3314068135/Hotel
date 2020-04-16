/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - hotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `hotel`;

/*Table structure for table `master` */

DROP TABLE IF EXISTS `master`;

CREATE TABLE `master` (
  `gid` int(255) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `gname` varchar(255) NOT NULL COMMENT '管理员名称',
  `gpassword` varchar(255) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `master` */

insert  into `master`(`gid`,`gname`,`gpassword`) values (1,'admin','123456');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `number` int(255) NOT NULL COMMENT '订单号',
  `rid` int(255) NOT NULL COMMENT '房间号',
  `uid` int(255) NOT NULL COMMENT '用户id',
  `date` datetime NOT NULL COMMENT '入住时间',
  `uphone` int(255) NOT NULL COMMENT '联系方式',
  `rprice` double(255,2) NOT NULL COMMENT '房间价格'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `orders` */

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `roomid` int(255) NOT NULL COMMENT '房间id',
  `price` double(255,2) NOT NULL COMMENT '房间价格',
  `state` int(255) NOT NULL COMMENT '房间当前状态0=空房,1=已预订',
  `categories` varchar(50) NOT NULL COMMENT '类别',
  `recommend` int(4) NOT NULL COMMENT '是否推荐 是=1 否=0',
  PRIMARY KEY (`roomid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `room` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `realname` varchar(20) NOT NULL COMMENT '真实姓名',
  `phone` varchar(11) NOT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
