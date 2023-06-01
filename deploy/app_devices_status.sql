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

 Date: 01/06/2023 17:30:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_devices_status
-- ----------------------------
DROP TABLE IF EXISTS `app_devices_status`;
CREATE TABLE `app_devices_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `device_id` varchar(255) DEFAULT NULL COMMENT '设备id',
  `used` char(1) DEFAULT NULL COMMENT '是否使用（0未使用 1使用）',
  `enabled` char(1) DEFAULT '0' COMMENT '状态（0未审核 1审核）',
  `license_id` bigint(20) DEFAULT NULL COMMENT 'license id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='授权管理';

SET FOREIGN_KEY_CHECKS = 1;
