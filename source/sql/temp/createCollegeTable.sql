/*
Navicat MySQL Data Transfer

Source Server         : experiment
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : campus

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-07-08 13:53:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for acsnamelist
-- ----------------------------
DROP TABLE IF EXISTS `acsnamelist`;
CREATE TABLE `acsnamelist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminclassid` varchar(128) NOT NULL,
  `studentid` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `adminclassid` (`adminclassid`),
  KEY `studentid` (`studentid`),
  CONSTRAINT `acsnamelist_ibfk_1` FOREIGN KEY (`adminclassid`) REFERENCES `adminclass` (`adminClassid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `acsnamelist_ibfk_2` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of acsnamelist
-- ----------------------------

-- ----------------------------
-- Table structure for adminclass
-- ----------------------------
DROP TABLE IF EXISTS `adminclass`;
CREATE TABLE `adminclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminClassid` varchar(128) NOT NULL,
  `majorid` varchar(128) NOT NULL,
  `classnumber` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `majorid` (`majorid`),
  KEY `adminClassid` (`adminClassid`),
  CONSTRAINT `adminclass_ibfk_1` FOREIGN KEY (`majorid`) REFERENCES `major` (`majorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminclass
-- ----------------------------

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `collegeName` varchar(128) NOT NULL,
  `collegeID` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `collegeID` (`collegeID`) USING BTREE,
  KEY `collegeID_2` (`collegeID`),
  KEY `collegeID_3` (`collegeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `majorid` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `collegeID` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `collegeID` (`collegeID`),
  KEY `majorid` (`majorid`),
  CONSTRAINT `major_ibfk_1` FOREIGN KEY (`collegeID`) REFERENCES `college` (`collegeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
