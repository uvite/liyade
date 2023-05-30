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

 Date: 30/05/2023 17:46:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_ciphertexts
-- ----------------------------
DROP TABLE IF EXISTS `app_ciphertexts`;
CREATE TABLE `app_ciphertexts` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `device_id` varchar(255) NOT NULL COMMENT '设备id',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0未烧写 1烧写）',
  `product_type` char(100) DEFAULT NULL COMMENT '产品类型',
  `provider` char(100) DEFAULT NULL COMMENT '供应商',
  `ciphertext` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密文内容' CHECK (json_valid(`ciphertext`)),
  `ciphertext_path` varchar(255) DEFAULT NULL COMMENT '密文路径',
  `md5` char(100) DEFAULT NULL COMMENT '密文md5',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='密文管理';

SET FOREIGN_KEY_CHECKS = 1;
