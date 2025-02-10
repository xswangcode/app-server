/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : localhost:3306
 Source Schema         : app-server

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 10/02/2025 17:51:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `id`            int(10) UNSIGNED                                       NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '姓名',
    `age`           int(11)                                                NULL DEFAULT NULL COMMENT '年龄',
    `email`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '邮箱',
    `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '明文密码',
    `create_time`   timestamp                                              NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `ts`            datetime                                               NULL DEFAULT NULL COMMENT '创建时间2',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student`
VALUES (1, 'Guo Xiaoming', 645, 'xiaomingguo@gmail.com', '000', '2024-12-17 06:55:05', NULL);
INSERT INTO `student`
VALUES (2, 'Yokoyama Aoi', 709, 'yokoyamaaoi@gmail.com', '000', '2024-12-17 06:55:05', NULL);
INSERT INTO `student`
VALUES (3, 'Clifford Phillips', 43, 'cliffordphillips813@outlook.com', '000', '2024-12-17 06:55:05', NULL);
INSERT INTO `student`
VALUES (4, 'xswang', 22, '123@qq.com', '000', '2024-12-17 06:55:05', NULL);
INSERT INTO `student`
VALUES (5, 'xswang', 22, '123@qq.com', '000', '2024-12-17 06:55:05', NULL);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`
(
    `id`           bigint(20) UNSIGNED                                    NOT NULL AUTO_INCREMENT,
    `client_ip`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  NULL DEFAULT NULL COMMENT '客户端地址',
    `path`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '接口地址',
    `type`         varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  NULL DEFAULT NULL COMMENT '日志类型',
    `spend_time`   bigint(20)                                             NULL DEFAULT NULL COMMENT '耗时',
    `params`       text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin         NULL COMMENT '参数',
    `log_level`    varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  NULL DEFAULT NULL COMMENT '日志等级',
    `response`     text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin         NULL COMMENT '返回信息',
    `timespan`     timestamp                                              NULL DEFAULT NULL COMMENT '创建时间',
    `create_by`    varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin  NULL DEFAULT NULL COMMENT '创建人',
    `create_by_id` bigint(20)                                             NULL DEFAULT NULL COMMENT '创建人id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log`
VALUES (1, '172.20.144.1', NULL, 'EXCEPTION', 1, '[]', 'ERROR',
        '{\"success\":false,\"message\":\"没有权限访问\",\"code\":500,\"timestamp\":1738916093857}',
        '2025-02-07 16:14:54', 'xs', 1);
INSERT INTO `sys_log`
VALUES (2, '172.20.144.1', NULL, 'EXCEPTION', 0, '[]', 'ERROR',
        '{\"success\":false,\"message\":\"EL1004E: Method call: Method getTotal() cannot be found on type com.wxs.code.core.api.VO.RspMsg\",\"code\":500,\"timestamp\":1739176950831}',
        '2025-02-10 16:42:33', 'xs', 1);
INSERT INTO `sys_log`
VALUES (3, '172.20.144.1', NULL, 'EXCEPTION', 0, '[]', 'ERROR',
        '{\"success\":false,\"message\":\"EL1004E: Method call: Method getTotal() cannot be found on type com.wxs.code.core.api.VO.RspMsg\",\"code\":500,\"timestamp\":1739177471155}',
        '2025-02-10 16:51:11', 'xs', 1);
INSERT INTO `sys_log`
VALUES (4, '172.20.144.1', NULL, 'EXCEPTION', 0, '[]', 'ERROR',
        '{\"success\":false,\"message\":\"EL1004E: Method call: Method getTotal() cannot be found on type com.wxs.code.core.api.VO.RspMsg\",\"code\":500,\"timestamp\":1739177481591}',
        '2025-02-10 16:51:22', 'xs', 1);
INSERT INTO `sys_log`
VALUES (5, '172.20.144.1', NULL, 'EXCEPTION', 0, '[]', 'ERROR',
        '{\"success\":false,\"message\":\"没有权限访问\",\"code\":500,\"timestamp\":1739178569894}',
        '2025-02-10 17:09:30', 'xs', 1);
INSERT INTO `sys_log`
VALUES (6, '172.20.144.1', '/system/sysmenu/pagelist', 'EXCEPTION', 1, '[]', 'ERROR',
        '{\"success\":false,\"message\":\"没有权限访问\",\"code\":500,\"timestamp\":1739179261671}',
        '2025-02-10 17:21:02', 'xs', 1);
INSERT INTO `sys_log`
VALUES (7, '172.20.144.1', '/system/sysmenu/pagelist', 'EXCEPTION', 0, '[]', 'ERROR',
        '{\"success\":false,\"message\":\"没有权限访问\",\"code\":500,\"timestamp\":1739179516382}',
        '2025-02-10 17:25:16', 'xs', 1);
INSERT INTO `sys_log`
VALUES (8, '172.20.144.1', '/system/sysmenu/pagelist', 'EXCEPTION', 0, '[]', 'ERROR',
        '{\"success\":false,\"message\":\"没有权限访问\",\"code\":500,\"timestamp\":1739179528993}',
        '2025-02-10 17:25:29', 'xs', 1);
INSERT INTO `sys_log`
VALUES (9, '172.20.144.1', '/system/sysmenu/pagelist', 'EXCEPTION', 0, '[]', 'ERROR',
        '{\"success\":false,\"message\":\"没有权限访问\",\"code\":500,\"timestamp\":1739179543599}',
        '2025-02-10 17:29:03', 'xs', 1);
INSERT INTO `sys_log`
VALUES (10, '172.20.144.1', 'http://172.20.144.1:28080/system/sysmenu/pagelist?a=1', 'EXCEPTION', 1, '[]', 'ERROR',
        '{\"success\":false,\"message\":\"没有权限访问\",\"code\":500,\"timestamp\":1739179800416}',
        '2025-02-10 17:30:04', 'xs', 1);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `id`            bigint(20) UNSIGNED                                           NOT NULL AUTO_INCREMENT,
    `name`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '展示的名',
    `path`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '前端的href',
    `title`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `redirect`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '重定向URL',
    `icon`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `order_idx`     int(11)                                                       NULL DEFAULT NULL COMMENT '排序字段',
    `component_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '子组件地址',
    `common`        tinyint(1)                                                    NULL DEFAULT 0 COMMENT '是否无token可用',
    `visible`       tinyint(1)                                                    NULL DEFAULT 1 COMMENT '是否可见',
    `parent_id`     bigint(20)                                                    NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 37
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu`
VALUES (1, '数据面板', '/dashboard', 'dashboard', NULL, 'Apple', 111, 'dashboard/dashboard', 0, 1, NULL);
INSERT INTO `sys_menu`
VALUES (2, '首页', '/home', 'Home', NULL, 'Iphone', 11, 'HomeView', 1, 1, NULL);
INSERT INTO `sys_menu`
VALUES (3, '用户管理', '/user', 'User', NULL, 'ChatDotRound', 12, '', 0, 1, NULL);
INSERT INTO `sys_menu`
VALUES (4, '用户管理-1', '/user/user1', 'User1', NULL, 'MessageBox', 33, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (5, '用户管理-2', '/user/user2', 'User2', NULL, 'MessageBox', 44, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (6, '登录', '/login', 'Login', NULL, 'Apple', 2, 'common/LoginView', 1, 0, NULL);
INSERT INTO `sys_menu`
VALUES (7, '默认', '/', 'default', '/login', 'Apple', 1, 'common/LoginView', 1, 0, NULL);
INSERT INTO `sys_menu`
VALUES (8, '404', '/404', '404', NULL, 'Apple', 9999, 'common/404', 1, 1, NULL);
INSERT INTO `sys_menu`
VALUES (9, '用户管理-3', '/user/user3', 'User3', NULL, 'MessageBox', 48, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (10, '用户管理-4', '/user/user4', 'User4', NULL, 'MessageBox', 49, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (11, '用户管理-5', '/user/user5', 'User5', NULL, 'MessageBox', 50, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (12, '用户管理-6', '/user/user6', 'User6', NULL, 'MessageBox', 51, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (13, '用户管理-7', '/user/user7', 'User7', NULL, 'MessageBox', 52, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (14, '用户管理-8', '/user/user8', 'User8', NULL, 'MessageBox', 53, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (15, '用户管理-9', '/user/user9', 'User9', NULL, 'MessageBox', 54, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (16, '用户管理-10', '/user/user10', 'User10', NULL, 'MessageBox', 55, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (17, '用户管理-11', '/user/user11', 'User11', NULL, 'MessageBox', 56, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (18, '用户管理-12', '/user/user12', 'User12', NULL, 'MessageBox', 57, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (19, '用户管理-13', '/user/user13', 'User13', NULL, 'MessageBox', 58, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (20, '用户管理-14', '/user/user14', 'User14', NULL, 'MessageBox', 59, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (21, '用户管理-15', '/user/user15', 'User15', NULL, 'MessageBox', 60, 'common/404', 0, 1, 3);
INSERT INTO `sys_menu`
VALUES (22, '用户管理-16', '/user/user16', 'User16', NULL, 'MessageBox', 61, 'common/404', 0, 1, 10);
INSERT INTO `sys_menu`
VALUES (23, '用户管理-17', '/user/user17', 'User17', NULL, 'MessageBox', 62, 'common/404', 0, 1, 10);
INSERT INTO `sys_menu`
VALUES (24, '用户管理-18', '/user/user18', 'User18', NULL, 'MessageBox', 63, 'common/404', 0, 1, 10);
INSERT INTO `sys_menu`
VALUES (25, '用户管理-19', '/user/user19', 'User19', NULL, 'MessageBox', 64, 'common/404', 0, 1, 23);
INSERT INTO `sys_menu`
VALUES (26, '用户管理-20', '/user/user20', 'User20', NULL, 'MessageBox', 65, 'common/404', 0, 1, 25);
INSERT INTO `sys_menu`
VALUES (27, '用户管理-21', '/user/user21', 'User21', NULL, 'MessageBox', 66, 'common/404', 0, 1, 25);
INSERT INTO `sys_menu`
VALUES (28, '用户管理-22', '/user/user22', 'User22', NULL, 'MessageBox', 67, 'common/404', 0, 1, 25);
INSERT INTO `sys_menu`
VALUES (29, '用户管理-23', '/user/user23', 'User23', NULL, 'MessageBox', 68, 'common/404', 0, 1, 25);
INSERT INTO `sys_menu`
VALUES (30, '用户管理-24', '/user/user24', 'User24', NULL, 'MessageBox', 69, 'common/404', 0, 1, 25);
INSERT INTO `sys_menu`
VALUES (31, '用户管理-25', '/user/user25', 'User25', NULL, 'MessageBox', 70, 'common/404', 0, 1, 25);
INSERT INTO `sys_menu`
VALUES (32, '用户管理-26', '/user/user26', 'User26', NULL, 'MessageBox', 71, 'common/404', 0, 1, 25);
INSERT INTO `sys_menu`
VALUES (33, '用户管理-27', '/user/user27', 'User27', NULL, 'MessageBox', 72, 'common/404', 0, 1, 25);
INSERT INTO `sys_menu`
VALUES (34, 'AAAAA', '/AAAAA', 'AAAAA', NULL, 'Apple', 99, 'common/404', 0, 1, NULL);
INSERT INTO `sys_menu`
VALUES (36, 'test-tabs', '/ttab', 'testtabs', NULL, NULL, 1, 'common/test/tabs', 1, 0, NULL);

-- ----------------------------
-- Table structure for sys_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissions`;
CREATE TABLE `sys_permissions`
(
    `id`           bigint(20) UNSIGNED                                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `code`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT '权限编码',
    `name`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT '权限名称',
    `create_time`  timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_by_id` bigint(20)                                                    NULL     DEFAULT NULL COMMENT '创建人id',
    `update_by_id` bigint(20)                                                    NULL     DEFAULT NULL COMMENT '更新人id',
    `create_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT '创建人',
    `update_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT '更新人',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_permissions
-- ----------------------------
INSERT INTO `sys_permissions`
VALUES (1, 'system:sys_menu:list', '系统日志查询', '2025-02-07 11:23:23', '2025-02-10 17:09:07', 1, 1, 'admin',
        'admin');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`           bigint(20) UNSIGNED                                           NOT NULL AUTO_INCREMENT,
    `role_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
    `role_code`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色编码',
    `create_time`  timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`  timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `create_by_id` bigint(20)                                                    NULL DEFAULT NULL,
    `update_by_id` bigint(20)                                                    NULL DEFAULT NULL,
    `create_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `update_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role`
VALUES (1, '管理员', 'admin', '2024-04-11 17:27:27', '2024-04-11 17:27:45', 0, 0, '', '');

-- ----------------------------
-- Table structure for sys_role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permissions`;
CREATE TABLE `sys_role_permissions`
(
    `id`             bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `role_id`        bigint(20) UNSIGNED NOT NULL COMMENT '角色id',
    `permissions_id` bigint(20) UNSIGNED NOT NULL COMMENT '权限id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_permissions
-- ----------------------------
INSERT INTO `sys_role_permissions`
VALUES (1, 1, 1);

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
    `create_time`  timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`  timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `create_by_id` bigint(20)                                                    NULL DEFAULT NULL,
    `update_by_id` bigint(20)                                                    NULL DEFAULT NULL,
    `create_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `update_by`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user`
VALUES (1, 'xs', 18, 'wxs_code@126.com', 'xs', '2024-04-11 17:02:39', '2024-04-11 17:09:11', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `id`      bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
    `role_id` bigint(20) UNSIGNED NOT NULL COMMENT '角色id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role`
VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for task_config
-- ----------------------------
DROP TABLE IF EXISTS `task_config`;
CREATE TABLE `task_config`
(
    `id`                  int(11)                                                       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `code`                varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '任务编码',
    `name`                varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '任务名称',
    `job`                 varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'job类名',
    `group_name`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL     DEFAULT NULL COMMENT '组名',
    `description`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT '任务描述',
    `cron_Text`           varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL     DEFAULT NULL COMMENT '定时表达式',
    `params`              text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci         NULL COMMENT '参数，值类型为json',
    `status`              tinyint(11)                                                   NOT NULL DEFAULT 0 COMMENT '任务状态',
    `is_do_now`           tinyint(11)                                                   NOT NULL DEFAULT 0 COMMENT '是否立即执行',
    `is_allow_concurrent` tinyint(11)                                                   NOT NULL DEFAULT 0 COMMENT '是否允许并发执行',
    `is_working`          tinyint(11)                                                   NOT NULL DEFAULT 0 COMMENT '是否正在执行',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 14
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of task_config
-- ----------------------------
INSERT INTO `task_config`
VALUES (2, 'test', '测试name1', 'com.wxs.code.schedule.test.TestJob', NULL, NULL, '0/2 * * * * ?', '{\"a\":123}', 0, 0,
        0, 0);
INSERT INTO `task_config`
VALUES (13, 'test', 'code', 'com.wxs.code.schedule.test.TestJob2', 'AAAAA', '测试', '0/5 * * * * ?', '{\"a\":456}', 0,
        0, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
