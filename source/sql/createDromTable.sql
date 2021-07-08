/*
Navicat MySQL Data Transfer

Source Server         : experiment
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : campus

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-07-08 13:54:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dmtroom
-- ----------------------------
DROP TABLE IF EXISTS `dmtroom`;
CREATE TABLE `dmtroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DMTRoomID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DMTID` varchar(128) NOT NULL COMMENT '宿舍id',
  `balance` double DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`id`),
  UNIQUE KEY `fk_room` (`DMTID`) USING BTREE,
  UNIQUE KEY `roomID` (`DMTRoomID`) USING BTREE,
  CONSTRAINT `fk_room` FOREIGN KEY (`DMTID`) REFERENCES `dormitory` (`dormitoryID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dmtroom
-- ----------------------------

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dormitoryID` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `adminID` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dormitoryID` (`dormitoryID`) USING BTREE,
  UNIQUE KEY `fk_admin` (`adminID`) USING BTREE,
  CONSTRAINT `dormitory_ibfk_1` FOREIGN KEY (`adminID`) REFERENCES `dmtadmin` (`DMTAdminID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormitory
-- ----------------------------

-- ----------------------------
-- Table structure for inoutrecord
-- ----------------------------
DROP TABLE IF EXISTS `inoutrecord`;
CREATE TABLE `inoutrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL,
  `inOutTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_in_username` (`username`),
  CONSTRAINT `fk_in_username` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inoutrecord
-- ----------------------------
