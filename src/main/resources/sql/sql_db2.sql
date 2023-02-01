/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50739
 Source Host           : localhost:3306
 Source Schema         : sql_db2

 Target Server Type    : MySQL
 Target Server Version : 50739
 File Encoding         : 65001

 Date: 01/02/2023 17:15:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `USER_ID` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--用户账号',
  `USER_PASSWORD` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '123456' COMMENT '--用户账号',
  `USER_TYPE` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '2' COMMENT '--用户类型 0：管理员，1：工作人员，2：访客',
  `USER_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '--用户状态 0：正常，1：冻结',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '--用户登录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('11', '123456', '1', '0');
INSERT INTO `admin` VALUES ('123L', 'dddd', '1', '0');
INSERT INTO `admin` VALUES ('a13518838560', '123456', '0', '0');
INSERT INTO `admin` VALUES ('a18289493367', '123456', '0', '1');
INSERT INTO `admin` VALUES ('a962104789', '67813831', '0', '0');
INSERT INTO `admin` VALUES ('admin', 'admin', '0', '0');
INSERT INTO `admin` VALUES ('testadmin', 'testadmin', '0', '0');
INSERT INTO `admin` VALUES ('testuser', 'testuser', '2', '0');
INSERT INTO `admin` VALUES ('testwork', 'testwork', '1', '0');
INSERT INTO `admin` VALUES ('u13518838560', '123456', '2', '2');
INSERT INTO `admin` VALUES ('u18289493367', '123456', '2', '1');
INSERT INTO `admin` VALUES ('u962104789', '67813831', '2', '0');
INSERT INTO `admin` VALUES ('w13518838560', '123456', '1', '1');
INSERT INTO `admin` VALUES ('w18289493367', '123456', '1', '1');
INSERT INTO `admin` VALUES ('w962104789', '67813831', '1', '0');

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author`  (
  `AUTHOR_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--作者编号',
  `AUTHOR_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--作者名称',
  `AUTHOR_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--作者信息状态 0：正常，1：失效',
  PRIMARY KEY (`AUTHOR_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '--作者信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1300000000', '罗贯中', '0');
INSERT INTO `author` VALUES ('1300000001', '施耐庵', '0');
INSERT INTO `author` VALUES ('1300000002', '吴承恩', '0');
INSERT INTO `author` VALUES ('1300000003', '曹雪芹', '0');
INSERT INTO `author` VALUES ('1300000004', '马丁·海德格尔', '0');
INSERT INTO `author` VALUES ('1300000005', '柏拉图', '0');
INSERT INTO `author` VALUES ('1300000006', '兰小欢', '0');
INSERT INTO `author` VALUES ('1300000007', '彼得·海斯勒', '0');
INSERT INTO `author` VALUES ('1300000008', '亚当·斯密', '0');
INSERT INTO `author` VALUES ('1300000009', '刘素兰', '0');
INSERT INTO `author` VALUES ('1300000010', '鲁迅', '0');
INSERT INTO `author` VALUES ('1300000011', '巴金', '0');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `BOOK_ID` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--图书编号',
  `BOOK_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--图书名称',
  `BOOK_TYPE_ID` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--图书类型编号',
  `AUTHOR_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--作者编号',
  `PRESS_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--出版社编号',
  `BORROWED_NUMBER` int(11) NOT NULL COMMENT '--借出次数',
  `REMAINING_NUMBER` int(11) NOT NULL COMMENT '--剩余数量',
  `BOOK_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--图书状态 0：正常，1：借出，2：丢失',
  PRIMARY KEY (`BOOK_ID`) USING BTREE,
  INDEX `BOOK_TYPE_ID`(`BOOK_TYPE_ID`) USING BTREE,
  INDEX `AUTHOR_ID`(`AUTHOR_ID`) USING BTREE,
  INDEX `PRESS_ID`(`PRESS_ID`) USING BTREE,
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`BOOK_TYPE_ID`) REFERENCES `book_type` (`BOOK_TYPE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`AUTHOR_ID`) REFERENCES `author` (`AUTHOR_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_ibfk_3` FOREIGN KEY (`PRESS_ID`) REFERENCES `press` (`PRESS_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '--图书信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('9787020070520', '三国演义', 'I', '1300000000', '9111010140', 1, 9, '0');
INSERT INTO `book` VALUES ('9787020070521', '水浒传', 'I', '1300000001', '9111010140', 2, 8, '0');
INSERT INTO `book` VALUES ('9787020070522', '西游记', 'I', '1300000002', '9111010140', 5, 5, '0');
INSERT INTO `book` VALUES ('9787020070523', '红楼梦', 'I', '1300000003', '9111010140', 3, 7, '0');
INSERT INTO `book` VALUES ('9787020070524', '存在与时间', 'B', '1300000004', '9111010141', 5, 2, '0');
INSERT INTO `book` VALUES ('9787020070525', '理想国', 'B', '1300000005', '9111010141', 3, 4, '0');
INSERT INTO `book` VALUES ('9787020070526', '置身事内', 'C', '1300000006', '9111010142', 3, 2, '0');
INSERT INTO `book` VALUES ('9787020070527', '江城', 'C', '1300000007', '9111010143', 2, 4, '0');
INSERT INTO `book` VALUES ('9787020070528', '国富论', 'F', '1300000008', '9111010144', 3, 2, '0');
INSERT INTO `book` VALUES ('9787020070529', '药剂学(中职药剂)', 'R', '1300000009', '9111010145', 2, 4, '0');
INSERT INTO `book` VALUES ('9787020070530', '狂人日记', 'I', '1300000010', '9111010140', 2, 4, '0');
INSERT INTO `book` VALUES ('9787020070531', '骆驼祥子', 'I', '1300000011', '9111010140', 9, 1, '0');

-- ----------------------------
-- Table structure for book_type
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type`  (
  `BOOK_TYPE_ID` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--图书类型编号',
  `BOOK_TYPE_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--图书类型名称',
  `BOOK_TYPE_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--图书类型信息状态 0：正常，1：失效',
  PRIMARY KEY (`BOOK_TYPE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '--图书类型信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_type
-- ----------------------------
INSERT INTO `book_type` VALUES ('B', '哲学', '0');
INSERT INTO `book_type` VALUES ('C', '社会科学', '0');
INSERT INTO `book_type` VALUES ('D', '政治法律', '0');
INSERT INTO `book_type` VALUES ('E', '军事', '0');
INSERT INTO `book_type` VALUES ('F', '经济', '0');
INSERT INTO `book_type` VALUES ('I', '文学', '0');
INSERT INTO `book_type` VALUES ('J', '艺术', '0');
INSERT INTO `book_type` VALUES ('K', '历史地理', '0');
INSERT INTO `book_type` VALUES ('N', '自然科学', '0');
INSERT INTO `book_type` VALUES ('O', '数理科学', '0');
INSERT INTO `book_type` VALUES ('Q', '生物科学', '0');
INSERT INTO `book_type` VALUES ('R', '药学', '0');

-- ----------------------------
-- Table structure for borrowed
-- ----------------------------
DROP TABLE IF EXISTS `borrowed`;
CREATE TABLE `borrowed`  (
  `BORROWED_ID` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--借阅编号',
  `USER_ID` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--借阅用户编号',
  `BOOK_ID` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--借阅图书编号',
  `BORROWED_NUMBER` int(11) NOT NULL COMMENT '--借阅数量',
  `BORROWED_START_DATE` date NOT NULL COMMENT '--借阅开始时间',
  `BORROWED_END_DATE` date NOT NULL COMMENT '--借阅结束时间',
  `BORROW_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--借阅状态 0：正常，1：逾期 2，借阅结束',
  PRIMARY KEY (`BORROWED_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '--借阅信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrowed
-- ----------------------------
INSERT INTO `borrowed` VALUES ('202209171200', 'testuser', '9787020070520', 2, '2022-08-01', '2022-08-07', '2');
INSERT INTO `borrowed` VALUES ('202209171201', 'u962104789', '9787020070530', 1, '2022-09-17', '2022-10-01', '0');
INSERT INTO `borrowed` VALUES ('202209171202', 'u962104789', '9787020070530', 1, '2022-09-10', '2022-09-17', '2');
INSERT INTO `borrowed` VALUES ('202209171203', 'u962104789', '9787020070528', 1, '2022-09-03', '2022-09-10', '2');
INSERT INTO `borrowed` VALUES ('202209171204', 'u18289493367', '9787020070523', 2, '2022-09-03', '2022-09-10', '1');
INSERT INTO `borrowed` VALUES ('202209171205', 'testuser', '9787020070529', 3, '2022-09-17', '2022-10-01', '0');
INSERT INTO `borrowed` VALUES ('202209171206', 'testuser', '9787020070527', 4, '2022-09-10', '2022-09-17', '2');
INSERT INTO `borrowed` VALUES ('202209171207', 'u962104789', '9787020070522', 2, '2022-08-01', '2022-08-07', '2');
INSERT INTO `borrowed` VALUES ('202209171208', 'u962104789', '9787020070526', 1, '2022-01-01', '2022-01-07', '2');
INSERT INTO `borrowed` VALUES ('202209171209', 'testuser', '9787020070525', 3, '2022-09-03', '2022-09-10', '2');

-- ----------------------------
-- Table structure for press
-- ----------------------------
DROP TABLE IF EXISTS `press`;
CREATE TABLE `press`  (
  `PRESS_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--出版社编号',
  `PRESS_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--出版社名称',
  `PRESS_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--出版社信息状态 0：正常，1：失效',
  PRIMARY KEY (`PRESS_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '--出版社信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of press
-- ----------------------------
INSERT INTO `press` VALUES ('9111010140', '人民文学出版社', '0');
INSERT INTO `press` VALUES ('9111010141', '商务印书馆', '0');
INSERT INTO `press` VALUES ('9111010142', '上海人民出版社', '0');
INSERT INTO `press` VALUES ('9111010143', '上海译文出版社', '0');
INSERT INTO `press` VALUES ('9111010144', '中信出版社', '0');
INSERT INTO `press` VALUES ('9111010145', '科学出版社', '0');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `STUDENT_ID` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '--学号',
  `STUDENT_NAME` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '--姓名',
  `STUDENT_GENDER` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '--用户性别 0：男，1：女',
  `STUDENT_PHONE` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '--用户手机号',
  `STUDENT_CLASS` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '--专业',
  `STUDENT_DATE` datetime NULL DEFAULT NULL COMMENT '--入学年份',
  PRIMARY KEY (`STUDENT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '--用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '里斯', '1', '128021489', '计算机科学与技术', NULL);
INSERT INTO `student` VALUES ('2', '里斯', '1', '128021489', '计算机科学与技术', NULL);
INSERT INTO `student` VALUES ('a13518838560', 'HHJJ', '0', '18298946737', '计算机', '2022-12-13 20:52:38');
INSERT INTO `student` VALUES ('a18289493367', 'JJWW', '0', '18298946734', '计算机', '2022-12-13 20:52:38');
INSERT INTO `student` VALUES ('a962104789', '测试管理员', '0', '18298946731', '计算机', '2022-12-13 20:52:38');
INSERT INTO `student` VALUES ('admin', '管理员', '0', '18298946730', '计算机', '2022-12-13 20:52:38');
INSERT INTO `student` VALUES ('testadmin', '测试管理员', '1', '18298946711', '计算机', '2022-12-13 20:52:38');
INSERT INTO `student` VALUES ('testuser', '测试用户', '1', '18298946733', '计算机', '2022-12-13 20:52:38');
INSERT INTO `student` VALUES ('testwork', '测试员工', '1', '18298946722', '计算机', '2022-12-13 20:52:38');
INSERT INTO `student` VALUES ('u13518838560', 'hhjj', '1', '18298946739', '计算机', '2022-12-13 20:52:38');
INSERT INTO `student` VALUES ('u18289493367', 'jjww', '1', '18298946736', '计算机', '2022-12-13 20:52:38');
INSERT INTO `student` VALUES ('u962104789', '测试用户', '0', '18298946733', '计算机', '2022-12-13 20:52:38');
INSERT INTO `student` VALUES ('w13518838560', '哼哼唧唧', '1', '18298946738', '计算机', '2022-12-13 20:52:38');
INSERT INTO `student` VALUES ('w18289493367', '唧唧歪歪', '0', '18298946735', '计算机', '2022-12-13 20:52:38');
INSERT INTO `student` VALUES ('w962104789', '测试员工', '1', '18298946732', '计算机', '2022-12-13 20:52:38');

SET FOREIGN_KEY_CHECKS = 1;
