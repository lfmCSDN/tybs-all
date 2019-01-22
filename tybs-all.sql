/*
Navicat MySQL Data Transfer

Source Server         : 119.3.5.43
Source Server Version : 50636
Source Host           : 119.3.5.43:3306
Source Database       : tybs-all

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-12-04 22:02:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for card_base_info
-- ----------------------------
DROP TABLE IF EXISTS `card_base_info`;
CREATE TABLE `card_base_info` (
  `card_Base_Info_Id` varchar(64) NOT NULL,
  `user_Base_Info_Id` varchar(64) DEFAULT NULL,
  `card_Id` varchar(64) DEFAULT NULL,
  `trans_Pwd` varchar(64) DEFAULT NULL,
  `stat` char(2) DEFAULT NULL COMMENT '状态：Y-正常,L-挂失，D-删除，F-冻结',
  `oveage` decimal(19,2) DEFAULT NULL,
  `open_Date` varchar(64) DEFAULT NULL,
  `card_Type` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`card_Base_Info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行卡信息表';

-- ----------------------------
-- Table structure for trans_list_info
-- ----------------------------
DROP TABLE IF EXISTS `trans_list_info`;
CREATE TABLE `trans_list_info` (
  `trans_List_Info_Id` varchar(64) NOT NULL,
  `card_base_info_id` varchar(64) DEFAULT NULL,
  `serial_Number` varchar(64) DEFAULT NULL,
  `trans_Type` varchar(64) DEFAULT NULL COMMENT '类型：存款、取款、转账',
  `trans_Amount` decimal(19,2) DEFAULT NULL,
  `trans_Time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`trans_List_Info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易明细表';

-- ----------------------------
-- Table structure for user_admin_info
-- ----------------------------
DROP TABLE IF EXISTS `user_admin_info`;
CREATE TABLE `user_admin_info` (
  `Id` int(11) NOT NULL,
  `admin_Name` varchar(64) DEFAULT NULL,
  `admin_Pwd` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_base_info
-- ----------------------------
DROP TABLE IF EXISTS `user_base_info`;
CREATE TABLE `user_base_info` (
  `user_Base_Info_Id` varchar(64) NOT NULL,
  `user_Name` varchar(64) DEFAULT NULL,
  `user_Card_Id` varchar(64) DEFAULT NULL,
  `user_Tel` varchar(64) DEFAULT NULL,
  `user_Email` varchar(64) DEFAULT NULL,
  `user_Sex` char(1) DEFAULT NULL,
  `user_Address` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`user_Base_Info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Table structure for user_oper_info
-- ----------------------------
DROP TABLE IF EXISTS `user_oper_info`;
CREATE TABLE `user_oper_info` (
  `user_Oper_Info_Id` varchar(64) NOT NULL,
  `oper_Name` varchar(64) DEFAULT NULL,
  `login_Pwd` varchar(64) DEFAULT NULL,
  `oper_Sex` char(3) DEFAULT NULL,
  `oper_Statu` varchar(64) DEFAULT NULL COMMENT '状态：Y能登录，N不能登录',
  `oper_Mobil_Phone` char(11) DEFAULT NULL COMMENT '11位手机号码',
  `oper_Email` varchar(64) DEFAULT NULL,
  `oper_Card_Id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`user_Oper_Info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作员信息表';

-- ----------------------------
-- Table structure for zipkin_annotations
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_annotations`;
CREATE TABLE `zipkin_annotations` (
  `trace_id_high` bigint(20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.trace_id',
  `span_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.id',
  `a_key` varchar(255) NOT NULL COMMENT 'BinaryAnnotation.key or Annotation.value if type == -1',
  `a_value` blob COMMENT 'BinaryAnnotation.value(), which must be smaller than 64KB',
  `a_type` int(11) NOT NULL COMMENT 'BinaryAnnotation.type() or -1 if Annotation',
  `a_timestamp` bigint(20) DEFAULT NULL COMMENT 'Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp',
  `endpoint_ipv4` int(11) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_ipv6` binary(16) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null, or no IPv6 address',
  `endpoint_port` smallint(6) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_service_name` varchar(255) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) USING BTREE COMMENT 'Ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`span_id`) USING BTREE COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) USING BTREE COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name` (`endpoint_service_name`) USING BTREE COMMENT 'for getTraces and getServiceNames',
  KEY `a_type` (`a_type`) USING BTREE COMMENT 'for getTraces',
  KEY `a_key` (`a_key`) USING BTREE COMMENT 'for getTraces',
  KEY `trace_id` (`trace_id`,`span_id`,`a_key`) USING BTREE COMMENT 'for dependencies job'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zipkin_dependencies
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_dependencies`;
CREATE TABLE `zipkin_dependencies` (
  `day` date NOT NULL,
  `parent` varchar(255) NOT NULL,
  `child` varchar(255) NOT NULL,
  `call_count` bigint(20) DEFAULT NULL,
  `error_count` bigint(20) DEFAULT NULL,
  UNIQUE KEY `day` (`day`,`parent`,`child`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zipkin_spans
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_spans`;
CREATE TABLE `zipkin_spans` (
  `trace_id_high` bigint(20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `debug` bit(1) DEFAULT NULL,
  `start_ts` bigint(20) DEFAULT NULL COMMENT 'Span.timestamp(): epoch micros used for endTs query and to implement TTL',
  `duration` bigint(20) DEFAULT NULL COMMENT 'Span.duration(): micros used for minDuration and maxDuration query',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`id`) USING BTREE COMMENT 'ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`id`) USING BTREE COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) USING BTREE COMMENT 'for getTracesByIds',
  KEY `name` (`name`) USING BTREE COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts` (`start_ts`) USING BTREE COMMENT 'for getTraces ordering and range'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
