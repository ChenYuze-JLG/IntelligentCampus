/*
Navicat MySQL Data Transfer

Source Server         : experiment
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : campus

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-07-08 14:10:39
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
