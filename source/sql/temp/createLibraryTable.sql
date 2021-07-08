/*
Navicat MySQL Data Transfer

Source Server         : experiment
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : campus

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-07-08 13:54:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookID` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `author` varchar(128) NOT NULL,
  `publishTime` date DEFAULT NULL,
  `type` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bookID` (`bookID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------

-- ----------------------------
-- Table structure for borrowrecord
-- ----------------------------
DROP TABLE IF EXISTS `borrowrecord`;
CREATE TABLE `borrowrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookID` varchar(128) NOT NULL,
  `borrowTime` date DEFAULT NULL,
  `renewCount` int(11) DEFAULT NULL,
  `borrowUser` varchar(128) NOT NULL,
  `returnTime` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_book_id` (`bookID`),
  KEY `fk_username` (`borrowUser`),
  CONSTRAINT `fk_book_id` FOREIGN KEY (`bookID`) REFERENCES `books` (`bookID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_username` FOREIGN KEY (`borrowUser`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowrecord
-- ----------------------------
