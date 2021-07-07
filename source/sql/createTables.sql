/*
Navicat MySQL Data Transfer

Source Server         : experiment
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : campus

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-07-07 21:13:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(11) NOT NULL,
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
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `collegeName` varchar(128) NOT NULL,
  `collegeID` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `collegeID` (`collegeID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------

-- ----------------------------
-- Table structure for counsellor
-- ----------------------------
DROP TABLE IF EXISTS `counsellor`;
CREATE TABLE `counsellor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `counsellorID` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `gender` enum('男','女') NOT NULL,
  `age` int(11) NOT NULL,
  `collegeID` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fk_college` (`collegeID`) USING BTREE,
  CONSTRAINT `fk_college` FOREIGN KEY (`collegeID`) REFERENCES `college` (`collegeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of counsellor
-- ----------------------------

-- ----------------------------
-- Table structure for dmtadmin
-- ----------------------------
DROP TABLE IF EXISTS `dmtadmin`;
CREATE TABLE `dmtadmin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DMTAdminID` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` enum('男','女') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `DMTAdminID` (`DMTAdminID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dmtadmin
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
  KEY `fk_admin` (`adminID`),
  CONSTRAINT `fk_admin` FOREIGN KEY (`adminID`) REFERENCES `dmtadmin` (`DMTAdminID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormitory
-- ----------------------------

-- ----------------------------
-- Table structure for inoutrecord
-- ----------------------------
DROP TABLE IF EXISTS `inoutrecord`;
CREATE TABLE `inoutrecord` (
  `id` int(11) NOT NULL,
  `username` varchar(128) NOT NULL,
  `inOutTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_in_username` (`username`),
  CONSTRAINT `fk_in_username` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inoutrecord
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomID` varchar(128) NOT NULL,
  `DMTID` varchar(128) NOT NULL COMMENT '宿舍id',
  `balance` double DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`id`),
  UNIQUE KEY `fk_room` (`DMTID`) USING BTREE,
  UNIQUE KEY `roomID` (`roomID`) USING BTREE,
  CONSTRAINT `fk_room` FOREIGN KEY (`DMTID`) REFERENCES `dormitory` (`dormitoryID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `ID` int(32) NOT NULL,
  `studentID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(128) NOT NULL,
  `gender` enum('男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int(11) NOT NULL,
  `roomID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  UNIQUE KEY `ui_ID` (`studentID`) USING BTREE,
  KEY `fk_stu_room` (`roomID`),
  CONSTRAINT `fk_stu_id` FOREIGN KEY (`studentID`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_stu_room` FOREIGN KEY (`roomID`) REFERENCES `room` (`roomID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(128) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` enum('男','女') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ui_tea_id` (`teacherID`) USING BTREE,
  CONSTRAINT `fk_tea_id` FOREIGN KEY (`teacherID`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
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

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(32) NOT NULL,
  `username` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nickname` varchar(128) DEFAULT NULL,
  `role` enum('辅导员','教师','学生','舍区管理员') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '学生',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `userkey` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
