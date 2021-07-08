/*
Navicat MySQL Data Transfer

Source Server         : experiment
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : campus

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-07-08 13:53:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for absencerecord
-- ----------------------------
DROP TABLE IF EXISTS `absencerecord`;
CREATE TABLE `absencerecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lessonID` varchar(128) NOT NULL,
  `studentID` varchar(128) NOT NULL,
  `type` enum('缺席','请假') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lessonID` (`lessonID`),
  KEY `studentID` (`studentID`),
  CONSTRAINT `absencerecord_ibfk_1` FOREIGN KEY (`lessonID`) REFERENCES `lesson` (`lessonID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `absencerecord_ibfk_2` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of absencerecord
-- ----------------------------

-- ----------------------------
-- Table structure for classrommrecord
-- ----------------------------
DROP TABLE IF EXISTS `classrommrecord`;
CREATE TABLE `classrommrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classroomID` varchar(128) NOT NULL,
  `date` date NOT NULL,
  `section` enum('第一节','第二节','第三节','第四节','第五节','第六节','第七节','第八节','第九节','第十节','第十一节','第十二节') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user` (`user`),
  KEY `classroomID` (`classroomID`),
  CONSTRAINT `classrommrecord_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `classrommrecord_ibfk_2` FOREIGN KEY (`classroomID`) REFERENCES `classroom` (`classroomID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classrommrecord
-- ----------------------------

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classroomID` varchar(128) NOT NULL,
  `capacity` int(10) unsigned zerofill DEFAULT '0000000090',
  PRIMARY KEY (`id`),
  KEY `classroomID` (`classroomID`),
  KEY `classroomID_2` (`classroomID`),
  KEY `classroomID_3` (`classroomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classroom
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseID` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `collegeID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `courseID` (`courseID`),
  KEY `collegeID` (`collegeID`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`collegeID`) REFERENCES `college` (`collegeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for examschedule
-- ----------------------------
DROP TABLE IF EXISTS `examschedule`;
CREATE TABLE `examschedule` (
  `id` int(11) NOT NULL,
  `teachClassID` varchar(128) NOT NULL,
  `classroomID` varchar(128) NOT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL COMMENT '根据time推算section',
  PRIMARY KEY (`id`),
  KEY `teachClassID` (`teachClassID`),
  KEY `classroomID` (`classroomID`),
  CONSTRAINT `examschedule_ibfk_1` FOREIGN KEY (`teachClassID`) REFERENCES `teachclass` (`teachClassID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `examschedule_ibfk_3` FOREIGN KEY (`classroomID`) REFERENCES `classroom` (`classroomID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of examschedule
-- ----------------------------

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lessonID` varchar(128) NOT NULL,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` date NOT NULL,
  `section` enum('第一节','第二节','第三节','第四节','第五节','第六节','第七节','第八节','第九节','第十节','第十一节','第十二节') DEFAULT NULL,
  `teachClassID` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teachClassID` (`teachClassID`),
  KEY `lessonID` (`lessonID`),
  CONSTRAINT `lesson_ibfk_1` FOREIGN KEY (`teachClassID`) REFERENCES `teachclass` (`teachClassID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson
-- ----------------------------

-- ----------------------------
-- Table structure for scorerecord
-- ----------------------------
DROP TABLE IF EXISTS `scorerecord`;
CREATE TABLE `scorerecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` double unsigned zerofill DEFAULT NULL,
  `credit` double unsigned zerofill DEFAULT NULL,
  `collegeID` varchar(128) NOT NULL,
  `courseID` varchar(128) NOT NULL,
  `teachClassID` varchar(128) NOT NULL,
  `studentID` varchar(128) NOT NULL,
  `teacherID` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `collegeID` (`collegeID`),
  KEY `teachClassID` (`teachClassID`),
  KEY `studentID` (`studentID`),
  KEY `teacherID` (`teacherID`),
  KEY `courseID` (`courseID`),
  CONSTRAINT `scorerecord_ibfk_1` FOREIGN KEY (`collegeID`) REFERENCES `college` (`collegeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `scorerecord_ibfk_2` FOREIGN KEY (`teachClassID`) REFERENCES `teachclass` (`teachClassID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `scorerecord_ibfk_3` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `scorerecord_ibfk_4` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`teacherID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `scorerecord_ibfk_5` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scorerecord
-- ----------------------------

-- ----------------------------
-- Table structure for tcsnamelist
-- ----------------------------
DROP TABLE IF EXISTS `tcsnamelist`;
CREATE TABLE `tcsnamelist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teachClassID` varchar(128) NOT NULL,
  `studentID` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teachClassID` (`teachClassID`),
  KEY `studentID` (`studentID`),
  CONSTRAINT `tcsnamelist_ibfk_1` FOREIGN KEY (`teachClassID`) REFERENCES `teachclass` (`teachClassID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tcsnamelist_ibfk_2` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcsnamelist
-- ----------------------------

-- ----------------------------
-- Table structure for teachclass
-- ----------------------------
DROP TABLE IF EXISTS `teachclass`;
CREATE TABLE `teachclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teachClassID` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `teacherID` varchar(128) NOT NULL,
  `courseID` varchar(128) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_teacherID` (`teacherID`),
  KEY `fk_courseID` (`courseID`),
  KEY `teachClassID` (`teachClassID`),
  KEY `teachClassID_2` (`teachClassID`),
  KEY `teachClassID_3` (`teachClassID`),
  CONSTRAINT `fk_courseID` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_teacherID` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`teacherID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachclass
-- ----------------------------
