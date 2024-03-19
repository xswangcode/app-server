/*
 Navicat Premium Data Transfer

 Source Server         : 172.25.28.23
 Source Server Type    : MySQL
 Source Server Version : 50744 (5.7.44)
 Source Host           : 172.25.28.23:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50744 (5.7.44)
 File Encoding         : 65001

 Date: 15/03/2024 17:51:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sysUser
-- ----------------------------
DROP TABLE IF EXISTS `sysUser`;
CREATE TABLE `sysUser`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         `age` int(11) NULL DEFAULT NULL,
                         `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
                         `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         `create_by_id` int(11) NULL DEFAULT NULL,
                         `update_by_id` int(11) NULL DEFAULT NULL,
                         `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1011 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         `age` int(11) NULL DEFAULT NULL,
                         `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
                         `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         `create_by_id` int(11) NULL DEFAULT NULL,
                         `update_by_id` int(11) NULL DEFAULT NULL,
                         `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysUser
-- ----------------------------
INSERT INTO `sysUser` VALUES (1, 'Rebecca Hunter', 57, 'hurebe@gmail.com', '2012-07-11 07:35:22', '2024-02-27 04:50:31', 325, 695, '徐睿', '徐睿');
INSERT INTO `sysUser` VALUES (2, 'Lu Ziyi', 7, 'lu1@icloud.com', '2022-05-26 08:56:43', '2007-03-02 07:39:06', 770, 976, '邱睿', '邱睿');
INSERT INTO `sysUser` VALUES (3, 'Lee Ka Fai', 45, 'lee2@icloud.com', '2011-01-18 11:06:45', '2023-12-14 19:30:43', 840, 437, '何睿', '何睿');
INSERT INTO `sysUser` VALUES (4, 'Yin Tak Wah', 9, 'yintakwah803@mail.com', '2016-05-21 08:45:54', '2014-07-07 01:10:31', 778, 264, '郑睿', '郑睿');
INSERT INTO `sysUser` VALUES (5, 'Peggy Herrera', 45, 'peggy1227@icloud.com', '2006-06-01 18:06:03', '2019-01-05 06:10:02', 29, 184, '陆子异', '陆子异');
INSERT INTO `sysUser` VALUES (6, 'Hung Ching Wan', 65, 'chingwan5@yahoo.com', '2010-02-01 07:00:43', '2014-02-09 15:31:30', 96, 117, '武致远', '武致远');
INSERT INTO `sysUser` VALUES (7, 'Sherry Cooper', 95, 'sherrcoope@outlook.com', '2017-02-16 01:59:52', '2022-05-01 19:26:55', 471, 282, '莫子异', '莫子异');
INSERT INTO `sysUser` VALUES (8, 'Philip Boyd', 28, 'boydp@outlook.com', '2001-11-26 19:10:46', '2012-07-02 02:14:10', 760, 54, '崔晓明', '崔晓明');
INSERT INTO `sysUser` VALUES (9, 'Catherine Wright', 71, 'wrc1206@gmail.com', '2021-06-06 04:08:51', '2005-10-28 00:32:45', 572, 173, '郑子异', '郑子异');
INSERT INTO `sysUser` VALUES (10, 'Pang Wing Fat', 22, 'wingfatpang@icloud.com', '2004-02-03 09:13:26', '2016-11-24 15:59:51', 639, 320, '罗詩涵', '罗詩涵');


-- ----------------------------
-- Function structure for aaa
-- ----------------------------
# DROP FUNCTION IF EXISTS `aaa`;
# delimiter ;;
# CREATE FUNCTION `aaa`(name VARCHAR(15))
#     RETURNS varchar(25) CHARSET utf8mb4 COLLATE utf8mb4_bin
# BEGIN
#     #Routine body goes here...
#
#     RETURN  concat('HELLO  ' , name);
# END
# ;;
# delimiter ;

SET FOREIGN_KEY_CHECKS = 1;