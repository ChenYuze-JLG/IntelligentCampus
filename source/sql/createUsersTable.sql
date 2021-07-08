/*
Navicat MySQL Data Transfer

Source Server         : experiment
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : campus

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-07-08 13:54:50
*/

SET FOREIGN_KEY_CHECKS=0;

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
  UNIQUE KEY `DMTAdminID` (`DMTAdminID`) USING BTREE,
  CONSTRAINT `dmtadmin_ibfk_1` FOREIGN KEY (`DMTAdminID`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dmtadmin
-- ----------------------------

-- ----------------------------
-- Table structure for eduadmin
-- ----------------------------
DROP TABLE IF EXISTS `eduadmin`;
CREATE TABLE `eduadmin` (
  `id` int(11) NOT NULL,
  `username` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`) USING BTREE,
  CONSTRAINT `eduadmin_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eduadmin
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `studentID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(128) NOT NULL,
  `gender` enum('男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `age` int(11) NOT NULL,
  `roomID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ui_ID` (`studentID`) USING BTREE,
  KEY `fk_stu_room` (`roomID`),
  KEY `studentID` (`studentID`),
  CONSTRAINT `fk_stu_id` FOREIGN KEY (`studentID`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_stu_room` FOREIGN KEY (`roomID`) REFERENCES `dmtroom` (`DMTRoomID`) ON DELETE CASCADE ON UPDATE CASCADE
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
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nickname` varchar(128) DEFAULT NULL,
  `role` enum('辅导员','教师','学生','教务管理员','舍区管理员') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '学生',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `userkey` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
