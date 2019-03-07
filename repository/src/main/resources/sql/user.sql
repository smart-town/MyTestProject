/*
Navicat MySQL Data Transfer

Source Server         : mysqlGreen
Source Server Version : 60005
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 60005
File Encoding         : 65001

Date: 2019-03-07 14:53:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `status` int(2) DEFAULT '0' COMMENT '用户状态，正常等',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'luhha', 'password', '0');
