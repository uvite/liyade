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

 Date: 20/05/2023 11:12:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_licenses
-- ----------------------------
DROP TABLE IF EXISTS `app_licenses`;
CREATE TABLE `app_licenses` (
  `device_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品名称',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '供应商',
  `device_status` varchar(255) DEFAULT NULL COMMENT '设备状态',
  `device_code` char(100) DEFAULT 'N' COMMENT '编号',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `device_in_stock_by` varchar(255) DEFAULT NULL COMMENT '入库人',
  `device_in_stock_time` datetime DEFAULT NULL COMMENT '入库时间',
  `device_out_stock_by` varchar(255) DEFAULT NULL COMMENT '出库人',
  `device_out_stock_time` datetime DEFAULT NULL COMMENT '出库时间',
  `stock_status` char(1) DEFAULT NULL COMMENT '状态（0入库 1出库）',
  `delete_by` varchar(64) DEFAULT NULL COMMENT '删除者',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `is_deleted` tinyint(4) DEFAULT 0 COMMENT '逻辑删除标识位\n',
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='参数配置表';

SET FOREIGN_KEY_CHECKS = 1;
