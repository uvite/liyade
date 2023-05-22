/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 101102 (10.11.2-MariaDB)
 Source Host           : 127.0.0.1:3306
 Source Schema         : liyade

 Target Server Type    : MySQL
 Target Server Version : 101102 (10.11.2-MariaDB)
 File Encoding         : 65001

 Date: 22/05/2023 14:12:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_private
-- ----------------------------
DROP TABLE IF EXISTS `app_private`;
CREATE TABLE `app_private` (
  `private_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `supplier_id` bigint(20) NOT NULL COMMENT '供应商',
  `public_key` text DEFAULT NULL COMMENT '公钥',
  `private_key` text DEFAULT NULL,
  `private_type` varchar(255) DEFAULT NULL COMMENT '加密类型',
  `valid_date` datetime DEFAULT NULL COMMENT '有效期',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`private_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='秘钥';

SET FOREIGN_KEY_CHECKS = 1;
