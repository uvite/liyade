/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 110002 (11.0.2-MariaDB)
 Source Host           : 127.0.0.1:3306
 Source Schema         : liyade

 Target Server Type    : MySQL
 Target Server Version : 110002 (11.0.2-MariaDB)
 File Encoding         : 65001

 Date: 14/06/2023 14:12:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_licenses
-- ----------------------------
DROP TABLE IF EXISTS `app_licenses`;
CREATE TABLE `app_licenses` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `license_id` varchar(255) DEFAULT NULL COMMENT 'license Id',
  `file_name` varchar(255) DEFAULT NULL COMMENT '下载文件名称',
  `limit_start` datetime DEFAULT NULL COMMENT '更新时间',
  `limit_end` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `project_address` varchar(255) DEFAULT NULL COMMENT '地址',
  `project_username` varchar(255) DEFAULT NULL COMMENT '联系人姓名',
  `project_mobile` varchar(255) DEFAULT NULL COMMENT '联系人电话',
  `project_sn` varchar(255) DEFAULT NULL COMMENT '项目编号',
  `md5` varchar(255) DEFAULT NULL COMMENT '重复提交校验',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='授权管理';

SET FOREIGN_KEY_CHECKS = 1;
