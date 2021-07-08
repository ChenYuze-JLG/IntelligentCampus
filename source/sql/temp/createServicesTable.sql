/*
Navicat MySQL Data Transfer

Source Server         : experiment
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : campus

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-07-08 13:54:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `activityID` varchar(128) NOT NULL,
  `organizer` varchar(128) NOT NULL,
  `description` text NOT NULL,
  `pushlishTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `resgisStartTime` datetime DEFAULT NULL,
  `resgisEndTime` datetime DEFAULT NULL,
  `activStartTime` datetime NOT NULL,
  `activEndTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_organizer` (`organizer`),
  KEY `activityID` (`activityID`),
  CONSTRAINT `fk_organizer` FOREIGN KEY (`organizer`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for activityrecord
-- ----------------------------
DROP TABLE IF EXISTS `activityrecord`;
CREATE TABLE `activityrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activityID` varchar(128) NOT NULL,
  `resigTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_actiID` (`activityID`),
  KEY `fk_acti_user` (`user`),
  CONSTRAINT `fk_actiID` FOREIGN KEY (`activityID`) REFERENCES `activity` (`activityID`),
  CONSTRAINT `fk_acti_user` FOREIGN KEY (`user`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activityrecord
-- ----------------------------

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardID` varchar(128) NOT NULL,
  `balance` double unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_card` (`cardID`),
  CONSTRAINT `fk_card` FOREIGN KEY (`cardID`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------

-- ----------------------------
-- Table structure for lostandfound
-- ----------------------------
DROP TABLE IF EXISTS `lostandfound`;
CREATE TABLE `lostandfound` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` text NOT NULL,
  `description` longtext,
  `img` varchar(128) DEFAULT NULL,
  `publisher` varchar(128) NOT NULL,
  `publishTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `type` enum('成功','失败') NOT NULL COMMENT '是否成功找到',
  `pubishType` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发布类型：找失主、找物品',
  PRIMARY KEY (`id`),
  KEY `fk_user` (`publisher`),
  CONSTRAINT `fk_user` FOREIGN KEY (`publisher`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lostandfound
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(128) NOT NULL,
  `publisher` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publishTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `views` int(10) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_news_user` (`publisher`),
  CONSTRAINT `fk_news_user` FOREIGN KEY (`publisher`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for transrecord
-- ----------------------------
DROP TABLE IF EXISTS `transrecord`;
CREATE TABLE `transrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易记录id',
  `money` double unsigned zerofill NOT NULL,
  `type` enum('电费','水费','燃气费','校园卡支出','校园卡充值') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `payTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pay_user` (`username`),
  CONSTRAINT `fk_pay_user` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transrecord
-- ----------------------------
