/*
 Navicat Premium Data Transfer

 Source Server         : vm2-app-server
 Source Server Type    : MySQL
 Source Server Version : 50743 (5.7.43-log)
 Source Host           : 172.24.130.73:3306
 Source Schema         : app-server

 Target Server Type    : MySQL
 Target Server Version : 50743 (5.7.43-log)
 File Encoding         : 65001

 Date: 11/04/2024 17:52:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `id`            bigint(20) UNSIGNED                                           NOT NULL AUTO_INCREMENT,
    `name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '展示的名',
    `title`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `icon`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `order_idx`     int(11)                                                       NULL DEFAULT NULL COMMENT '排序字段',
    `component_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '子组件地址',
    `parent_id`     bigint(20)                                                    NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`           bigint(20) UNSIGNED                                           NOT NULL AUTO_INCREMENT,
    `role_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
    `role_code`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色编码',
    `create_time`  datetime                                                      NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`  datetime                                                      NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `create_by_id` bigint(20)                                                    NULL DEFAULT NULL,
    `update_by_id` bigint(20)                                                    NULL DEFAULT NULL,
    `create_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `update_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role`
VALUES (1, '管理员', 'admin', '2024-04-11 17:27:27', '2024-04-11 17:27:45', 0, 0, '', '');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`           bigint(20) UNSIGNED                                           NOT NULL AUTO_INCREMENT,
    `name`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `age`          int(11)                                                       NULL DEFAULT NULL,
    `email`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `password`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '加密后的密码',
    `create_time`  datetime                                                      NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`  datetime                                                      NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `create_by_id` bigint(20)                                                    NULL DEFAULT NULL,
    `update_by_id` bigint(20)                                                    NULL DEFAULT NULL,
    `create_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `update_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1021
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user`
VALUES (1, 'xs', 18, 'wxs_code@126.com', 'xs', '2024-04-11 17:02:39', '2024-04-11 17:09:11', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for task_config
-- ----------------------------
DROP TABLE IF EXISTS `task_config`;
CREATE TABLE `task_config`
(
    `id`                int(11)                                                       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `code`              varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '任务编码',
    `name`              varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '任务名称',
    `job`               varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'job类名',
    `group`             varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '组名',
    `description`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务描述，len<=255',
    `cronText`          varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '定时表达式',
    `params`            text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         NULL COMMENT '参数，值类型为json',
    `status`            int(11)                                                       NULL DEFAULT 0 COMMENT '任务状态，0:禁用，1：启用',
    `isDoNow`           int(11)                                                       NULL DEFAULT 0 COMMENT '是否立即执行',
    `isAllowConcurrent` int(11)                                                       NULL DEFAULT 0 COMMENT '是否允许并发执行，1:允许，0：不允许',
    `isWorking`         int(11)                                                       NULL DEFAULT 0 COMMENT '是否正在执行',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `code` (`code`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_config
-- ----------------------------
INSERT INTO `task_config`
VALUES (2, 'testCode-01', '测试name1', 'com.wxs.task.service.job.JobTest', NULL, NULL, '0/2 * * * * ?', NULL, 1, 0, 0,
        0);
INSERT INTO `task_config`
VALUES (3, 'testCode-02', '测试name2', 'com.wxs.task.service.job.JobTest', NULL, NULL, '0/5 * * * * ?', NULL, 1, 0, 0,
        0);

SET FOREIGN_KEY_CHECKS = 1;
