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

 Date: 13/04/2023 21:27:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_product
-- ----------------------------
DROP TABLE IF EXISTS `app_product`;
CREATE TABLE `app_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `product_name` varchar(100) DEFAULT '' COMMENT '名称',
  `product_type` varchar(100) DEFAULT '' COMMENT '类型',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商',
  `product_code` char(100) DEFAULT 'N' COMMENT '产品编号',
  `product_price` decimal(10,2) DEFAULT NULL COMMENT '参考价格',
  `product_create_time` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='参数配置表';

-- ----------------------------
-- Records of app_product
-- ----------------------------
BEGIN;
INSERT INTO `app_product` (`product_id`, `product_name`, `product_type`, `supplier_id`, `product_code`, `product_price`, `product_create_time`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (104, '手持扫描I型', '1', 102, '10001', 123.00, NULL, '', '2023-04-13 17:59:00', '', '2023-04-13 19:47:02', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
