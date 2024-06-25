/*
 Navicat Premium Data Transfer

 Source Server         : app-server
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : 192.168.0.132:3306
 Source Schema         : app-server

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 25/06/2024 18:03:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`
(
    `id`           bigint(20) UNSIGNED                                   NOT NULL AUTO_INCREMENT,
    `client_ip`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '客户端地址',
    `type`         varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '日志类型',
    `spend_time`   bigint(20)                                            NULL DEFAULT NULL COMMENT '耗时',
    `log_level`    varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '日志等级',
    `response`     text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin        NULL COMMENT '返回信息',
    `timespan`     timestamp                                             NULL DEFAULT NULL COMMENT '创建时间',
    `create_by`    varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
    `create_by_id` bigint(20)                                            NULL DEFAULT NULL COMMENT '创建人id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log`
VALUES (1, '192.168.0.44', 'SELECT', 6, 'DEFAULT',
        '{\"success\":true,\"message\":\"\",\"code\":200,\"result\":[{\"id\":7,\"path\":\"/\",\"name\":\"默认\",\"title\":\"default\",\"redirect\":\"/login\",\"icon\":\"Apple\",\"orderIdx\":1,\"componentUrl\":\"common/LoginView\",\"common\":true,\"visible\":false},{\"id\":36,\"path\":\"/ttab\",\"name\":\"test-tabs\",\"title\":\"testtabs\",\"orderIdx\":1,\"componentUrl\":\"common/test/tabs\",\"common\":true,\"visible\":false},{\"id\":6,\"path\":\"/login\",\"name\":\"登录\",\"title\":\"Login\",\"icon\":\"Apple\",\"orderIdx\":2,\"componentUrl\":\"common/LoginView\",\"common\":true,\"visible\":false},{\"id\":2,\"path\":\"/home\",\"name\":\"首页\",\"title\":\"Home\",\"icon\":\"Iphone\",\"orderIdx\":11,\"componentUrl\":\"HomeView\",\"common\":true,\"visible\":true},{\"id\":3,\"path\":\"/user\",\"name\":\"用户管理\",\"title\":\"User\",\"icon\":\"ChatDotRound\",\"orderIdx\":12,\"componentUrl\":\"\",\"common\":false,\"visible\":true,\"children\":[{\"id\":4,\"path\":\"/user/user1\",\"name\":\"用户管理-1\",\"title\":\"User1\",\"icon\":\"MessageBox\",\"orderIdx\":33,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":5,\"path\":\"/user/user2\",\"name\":\"用户管理-2\",\"title\":\"User2\",\"icon\":\"MessageBox\",\"orderIdx\":44,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":9,\"path\":\"/user/user3\",\"name\":\"用户管理-3\",\"title\":\"User3\",\"icon\":\"MessageBox\",\"orderIdx\":48,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":10,\"path\":\"/user/user4\",\"name\":\"用户管理-4\",\"title\":\"User4\",\"icon\":\"MessageBox\",\"orderIdx\":49,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true,\"children\":[{\"id\":22,\"path\":\"/user/user16\",\"name\":\"用户管理-16\",\"title\":\"User16\",\"icon\":\"MessageBox\",\"orderIdx\":61,\"componentUrl\":\"common/404\",\"parentId\":10,\"common\":false,\"visible\":true},{\"id\":23,\"path\":\"/user/user17\",\"name\":\"用户管理-17\",\"title\":\"User17\",\"icon\":\"MessageBox\",\"orderIdx\":62,\"componentUrl\":\"common/404\",\"parentId\":10,\"common\":false,\"visible\":true,\"children\":[{\"id\":25,\"path\":\"/user/user19\",\"name\":\"用户管理-19\",\"title\":\"User19\",\"icon\":\"MessageBox\",\"orderIdx\":64,\"componentUrl\":\"common/404\",\"parentId\":23,\"common\":false,\"visible\":true,\"children\":[{\"id\":26,\"path\":\"/user/user20\",\"name\":\"用户管理-20\",\"title\":\"User20\",\"icon\":\"MessageBox\",\"orderIdx\":65,\"componentUrl\":\"common/404\",\"parentId\":25,\"common\":false,\"visible\":true},{\"id\":27,\"path\":\"/user/user21\",\"name\":\"用户管理-21\",\"title\":\"User21\",\"icon\":\"MessageBox\",\"orderIdx\":66,\"componentUrl\":\"common/404\",\"parentId\":25,\"common\":false,\"visible\":true},{\"id\":28,\"path\":\"/user/user22\",\"name\":\"用户管理-22\",\"title\":\"User22\",\"icon\":\"MessageBox\",\"orderIdx\":67,\"componentUrl\":\"common/404\",\"parentId\":25,\"common\":false,\"visible\":true},{\"id\":29,\"path\":\"/user/user23\",\"name\":\"用户管理-23\",\"title\":\"User23\",\"icon\":\"MessageBox\",\"orderIdx\":68,\"componentUrl\":\"common/404\",\"parentId\":25,\"common\":false,\"visible\":true},{\"id\":30,\"path\":\"/user/user24\",\"name\":\"用户管理-24\",\"title\":\"User24\",\"icon\":\"MessageBox\",\"orderIdx\":69,\"componentUrl\":\"common/404\",\"parentId\":25,\"common\":false,\"visible\":true},{\"id\":31,\"path\":\"/user/user25\",\"name\":\"用户管理-25\",\"title\":\"User25\",\"icon\":\"MessageBox\",\"orderIdx\":70,\"componentUrl\":\"common/404\",\"parentId\":25,\"common\":false,\"visible\":true},{\"id\":32,\"path\":\"/user/user26\",\"name\":\"用户管理-26\",\"title\":\"User26\",\"icon\":\"MessageBox\",\"orderIdx\":71,\"componentUrl\":\"common/404\",\"parentId\":25,\"common\":false,\"visible\":true},{\"id\":33,\"path\":\"/user/user27\",\"name\":\"用户管理-27\",\"title\":\"User27\",\"icon\":\"MessageBox\",\"orderIdx\":72,\"componentUrl\":\"common/404\",\"parentId\":25,\"common\":false,\"visible\":true}]}]},{\"id\":24,\"path\":\"/user/user18\",\"name\":\"用户管理-18\",\"title\":\"User18\",\"icon\":\"MessageBox\",\"orderIdx\":63,\"componentUrl\":\"common/404\",\"parentId\":10,\"common\":false,\"visible\":true}]},{\"id\":11,\"path\":\"/user/user5\",\"name\":\"用户管理-5\",\"title\":\"User5\",\"icon\":\"MessageBox\",\"orderIdx\":50,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":12,\"path\":\"/user/user6\",\"name\":\"用户管理-6\",\"title\":\"User6\",\"icon\":\"MessageBox\",\"orderIdx\":51,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":13,\"path\":\"/user/user7\",\"name\":\"用户管理-7\",\"title\":\"User7\",\"icon\":\"MessageBox\",\"orderIdx\":52,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":14,\"path\":\"/user/user8\",\"name\":\"用户管理-8\",\"title\":\"User8\",\"icon\":\"MessageBox\",\"orderIdx\":53,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":15,\"path\":\"/user/user9\",\"name\":\"用户管理-9\",\"title\":\"User9\",\"icon\":\"MessageBox\",\"orderIdx\":54,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":16,\"path\":\"/user/user10\",\"name\":\"用户管理-10\",\"title\":\"User10\",\"icon\":\"MessageBox\",\"orderIdx\":55,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":17,\"path\":\"/user/user11\",\"name\":\"用户管理-11\",\"title\":\"User11\",\"icon\":\"MessageBox\",\"orderIdx\":56,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":18,\"path\":\"/user/user12\",\"name\":\"用户管理-12\",\"title\":\"User12\",\"icon\":\"MessageBox\",\"orderIdx\":57,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":19,\"path\":\"/user/user13\",\"name\":\"用户管理-13\",\"title\":\"User13\",\"icon\":\"MessageBox\",\"orderIdx\":58,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":20,\"path\":\"/user/user14\",\"name\":\"用户管理-14\",\"title\":\"User14\",\"icon\":\"MessageBox\",\"orderIdx\":59,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true},{\"id\":21,\"path\":\"/user/user15\",\"name\":\"用户管理-15\",\"title\":\"User15\",\"icon\":\"MessageBox\",\"orderIdx\":60,\"componentUrl\":\"common/404\",\"parentId\":3,\"common\":false,\"visible\":true}]},{\"id\":34,\"path\":\"/AAAAA\",\"name\":\"AAAAA\",\"title\":\"AAAAA\",\"icon\":\"Apple\",\"orderIdx\":99,\"componentUrl\":\"common/404\",\"common\":false,\"visible\":true},{\"id\":1,\"path\":\"/dashboard\",\"name\":\"数据面板\",\"title\":\"dashboard\",\"icon\":\"Apple\",\"orderIdx\":111,\"componentUrl\":\"dashboard/dashboard\",\"common\":false,\"visible\":true},{\"id\":8,\"path\":\"/404\",\"name\":\"404\",\"title\":\"404\",\"icon\":\"Apple\",\"orderIdx\":9999,\"componentUrl\":\"common/404\",\"common\":true,\"visible\":true}],\"timestamp\":1719281149988}',
        '2024-06-25 10:05:50', 'xs', 1);

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
  ROW_FORMAT = DYNAMIC;

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
  ROW_FORMAT = DYNAMIC;

/*
 *  @description: app-server.sql
 *
 *  @author: xswang
 *  @email: wxs_code@126.com
 *  @version: 1.0
 *  @last update: 2024/6/25 下午6:03
 *  @date: 2024-6-25 18:3
 *
 */

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
