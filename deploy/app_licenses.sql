/*
 Navicat Premium Data Transfer

 Source Server         : liyade
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : liyade

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 17/06/2023 13:54:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_licenses
-- ----------------------------
DROP TABLE IF EXISTS `app_licenses`;
CREATE TABLE `app_licenses` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `license_id` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'license Id',
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `file_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '下载文件名称',
  `limit_start` datetime DEFAULT NULL COMMENT '更新时间',
  `limit_end` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  `project_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '项目名称',
  `project_address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '地址',
  `project_username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系人姓名',
  `project_mobile` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系人电话',
  `project_sn` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '项目编号',
  `md5` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '重复提交校验',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='授权管理';

SET FOREIGN_KEY_CHECKS = 1;
