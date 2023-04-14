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

 Date: 14/04/2023 00:24:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_private
-- ----------------------------
DROP TABLE IF EXISTS `app_private`;
CREATE TABLE `app_private` (
  `private_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `public_key` text DEFAULT NULL COMMENT '名称',
  `private_key` varchar(255) DEFAULT NULL,
  `private_type` varchar(255) DEFAULT NULL,
  `valid_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`private_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='参数配置表';

-- ----------------------------
-- Records of app_private
-- ----------------------------
BEGIN;
INSERT INTO `app_private` (`private_id`, `public_key`, `private_key`, `private_type`, `valid_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (104, 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJOzM9NUoF0SN/lCn+5ncLwlhXYlEtmARBrSql8kmZtODTrQXt7BwQk/kgMoI/AzT7TZxAfNYwcIWEPx8cUDYTsf7iENsbYjlGl1VVl/Q+6EsvWjVeCgbG9LX0CXG6nqyJOaw7LLKmRasn83tg88zKx+a8QUPRKckiNsW9fHTk9QIDAQAB', NULL, NULL, NULL, '', '2023-04-05 20:24:35', '', NULL, '2312');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
