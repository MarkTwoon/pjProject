/*
Navicat MySQL Data Transfer

Source Server         : Teacher
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : buy

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2019-06-05 17:22:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(255) COLLATE utf8_bin NOT NULL,
  `epassword` varchar(255) COLLATE utf8_bin NOT NULL,
  `esex` varchar(255) COLLATE utf8_bin NOT NULL,
  `epost` varchar(255) COLLATE utf8_bin NOT NULL,
  `ephone` varchar(255) COLLATE utf8_bin NOT NULL,
  `achievement` varchar(255) COLLATE utf8_bin NOT NULL,
  `ework` int(11) NOT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '员工2号', '123456', '男', '12', '17771418851', '12', '122');
INSERT INTO `employee` VALUES ('2', '员工1号', '123456', '男', '13', '16598746456', '15', '128');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gkind` varchar(255) COLLATE utf8_bin NOT NULL,
  `gname` varchar(255) COLLATE utf8_bin NOT NULL,
  `price` int(11) NOT NULL,
  `gcount` int(11) NOT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'iphone', 'iphone6s Plus', '2999', '301');
INSERT INTO `goods` VALUES ('2', 'iphone', 'iphone7', '3099', '304');
INSERT INTO `goods` VALUES ('4', 'iphone', 'iphone7 Plus', '4199', '423');
INSERT INTO `goods` VALUES ('6', 'iphone', 'iphone8 Plus', '6299', '560');
INSERT INTO `goods` VALUES ('7', 'iphone', 'iphoneX', '6199', '620');
INSERT INTO `goods` VALUES ('8', 'iphone', 'iphoneXR', '7099', '630');
INSERT INTO `goods` VALUES ('9', 'iphone', 'iphoneXS', '11099', '535');
INSERT INTO `goods` VALUES ('10', 'iphone', 'iphoneXS Max', '11799', '633');
INSERT INTO `goods` VALUES ('11', 'ipad', 'ipad mini4', '3799', '356');
INSERT INTO `goods` VALUES ('12', 'ipad', 'ipad mini5', '5065', '632');
INSERT INTO `goods` VALUES ('13', 'ipad', 'ipad 2018', '4238', '653');
INSERT INTO `goods` VALUES ('14', 'ipad', 'ipad Air 2019', '6039', '874');
INSERT INTO `goods` VALUES ('15', 'ipad', 'ipad Pro 10.5', '5888', '843');
INSERT INTO `goods` VALUES ('16', 'ipad', 'ipad Pro 11.0', '13699', '756');
INSERT INTO `goods` VALUES ('19', 'ipad', 'ipad Pro 12.9', '15299', '861');
INSERT INTO `goods` VALUES ('20', 'Mac', 'Mac mini', '8599', '320');
INSERT INTO `goods` VALUES ('21', 'Mac', 'iMac 21.5', '9799', '435');
INSERT INTO `goods` VALUES ('22', 'Mac', 'iMac 2019', '13832', '652');
INSERT INTO `goods` VALUES ('23', 'Mac', 'iMac Pro', '38999', '352');
INSERT INTO `goods` VALUES ('24', 'Mac', 'MacBook 12', '9899', '652');
INSERT INTO `goods` VALUES ('25', 'Mac', 'MacBook Air 13.3', '9099', '645');
INSERT INTO `goods` VALUES ('26', 'Mac', 'MacBook Pro 13.3', '12588', '534');
INSERT INTO `goods` VALUES ('27', 'Watch', 'Watch 3', '2099', '454');
INSERT INTO `goods` VALUES ('28', 'Watch', 'Watch 4', '3788', '567');
INSERT INTO `goods` VALUES ('29', 'ipod', 'Touch', '2499', '420');
INSERT INTO `goods` VALUES ('30', 'AirPods', 'AirPods 1', '1149', '572');
INSERT INTO `goods` VALUES ('31', 'AirPods', 'AirPods 2', '1799', '845');
INSERT INTO `goods` VALUES ('32', 'HomePod', 'HomePod', '2299', '452');
INSERT INTO `goods` VALUES ('33', 'Lightning', 'EarPods 耳机', '229', '878');
INSERT INTO `goods` VALUES ('34', 'Lightning', 'USB 连接线', '149', '1230');
INSERT INTO `goods` VALUES ('35', 'Lightning', '5W USB 电源适配器', '149', '984');
INSERT INTO `goods` VALUES ('36', 'Lightning', '3.5毫米耳机插孔转换器', '72', '1135');
INSERT INTO `goods` VALUES ('37', 'Mouse', '妙控鼠标 2代', '579', '861');
INSERT INTO `goods` VALUES ('38', 'Mouse', '妙控鼠标 2代', '579', '861');
INSERT INTO `goods` VALUES ('39', 'Lightning', 'USB 连接线', '150', '1230');
INSERT INTO `goods` VALUES ('40', 'ipad', 'ipad mini5', '6000', '632');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(255) COLLATE utf8_bin NOT NULL,
  `mpassword` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'admin', '123456');
INSERT INTO `manager` VALUES ('2', '乔布斯', '123456');
INSERT INTO `manager` VALUES ('3', '库克', '123456');

-- ----------------------------
-- Table structure for members
-- ----------------------------
DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(255) COLLATE utf8_bin NOT NULL,
  `mpassword` varchar(255) COLLATE utf8_bin NOT NULL,
  `msex` varchar(255) COLLATE utf8_bin NOT NULL,
  `mphone` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of members
-- ----------------------------
INSERT INTO `members` VALUES ('1', '雷金雨', '123456', '男', '110');
INSERT INTO `members` VALUES ('2', '肖淼', '123456', '男', '120');
INSERT INTO `members` VALUES ('3', '张磊', '123456', '男', '110');
INSERT INTO `members` VALUES ('4', '许坤杰', '123456', '男', '120');
INSERT INTO `members` VALUES ('5', '老吴头', '123456', '男', '111');
INSERT INTO `members` VALUES ('6', '易老师', '123456', '男', '123456789');
INSERT INTO `members` VALUES ('7', 'VIP01', '123456', '男', '');

-- ----------------------------
-- Table structure for selgoods
-- ----------------------------
DROP TABLE IF EXISTS `selgoods`;
CREATE TABLE `selgoods` (
  `seid` int(11) NOT NULL AUTO_INCREMENT,
  `sekind` varchar(255) COLLATE utf8_bin NOT NULL,
  `sename` varchar(255) COLLATE utf8_bin NOT NULL,
  `secount` int(11) NOT NULL,
  `seprice` int(11) NOT NULL,
  `secountprice` int(11) NOT NULL,
  `setime` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`seid`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of selgoods
-- ----------------------------
INSERT INTO `selgoods` VALUES ('1', 'iphone', 'iphone6s Plus', '2999', '301', '301', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('2', 'iphone', 'iphone7', '3099', '304', '304', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('4', 'iphone', 'iphone7 Plus', '4199', '423', '423', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('5', 'iphone', 'iphone8', '5399', '500', '500', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('6', 'iphone', 'iphone8 Plus', '6299', '560', '560', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('7', 'iphone', 'iphoneX', '6199', '620', '620', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('8', 'iphone', 'iphoneXR', '7099', '630', '630', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('9', 'iphone', 'iphoneXS', '11099', '535', '535', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('10', 'iphone', 'iphoneXS Max', '11799', '633', '633', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('11', 'ipad', 'ipad mini4', '3799', '356', '356', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('12', 'ipad', 'ipad mini5', '5065', '632', '632', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('13', 'ipad', 'ipad 2018', '4238', '653', '653', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('14', 'ipad', 'ipad Air 2019', '6039', '874', '874', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('15', 'ipad', 'ipad Pro 10.5', '5888', '843', '843', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('16', 'ipad', 'ipad Pro 11.0', '13699', '756', '756', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('19', 'ipad', 'ipad Pro 12.9', '15299', '861', '861', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('20', 'Mac', 'Mac mini', '8599', '320', '320', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('21', 'Mac', 'iMac 21.5', '9799', '435', '435', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('22', 'Mac', 'iMac 2019', '13832', '652', '652', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('23', 'Mac', 'iMac Pro', '38999', '352', '352', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('24', 'Mac', 'MacBook 12', '9899', '652', '652', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('25', 'Mac', 'MacBook Air 13.3', '9099', '645', '645', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('26', 'Mac', 'MacBook Pro 13.3', '12588', '534', '534', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('27', 'Watch', 'Watch 3', '2099', '454', '454', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('28', 'Watch', 'Watch 4', '3788', '567', '567', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('29', 'ipod', 'Touch', '2499', '420', '420', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('30', 'AirPods', 'AirPods 1', '1149', '572', '572', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('31', 'AirPods', 'AirPods 2', '1799', '845', '845', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('32', 'HomePod', 'HomePod', '2299', '452', '452', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('33', 'Lightning', 'EarPods 耳机', '229', '878', '878', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('34', 'Lightning', 'USB 连接线', '150', '1230', '1230', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('35', 'Lightning', '5W USB 电源适配器', '149', '984', '984', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('36', 'Lightning', '3.5毫米耳机插孔转换器', '72', '1135', '1135', '2019/04/30 15:36:25');
INSERT INTO `selgoods` VALUES ('81', 'iphone', 'iphone8', '500', '5399', '2699500', '2019-05-05 09:17:27');
