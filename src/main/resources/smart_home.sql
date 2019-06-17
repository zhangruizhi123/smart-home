/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : smart_home

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-06-17 21:46:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_attribute
-- ----------------------------
DROP TABLE IF EXISTS `app_attribute`;
CREATE TABLE `app_attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL COMMENT '属性名',
  `field` varchar(40) DEFAULT NULL COMMENT '字段名',
  `type` int(11) DEFAULT '0' COMMENT '类型 0:未知，1：binary,2:bool,3:char,4:short,5:int,6:double,7:string',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='属性管理';

-- ----------------------------
-- Records of app_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for app_device
-- ----------------------------
DROP TABLE IF EXISTS `app_device`;
CREATE TABLE `app_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `product_id` int(11) DEFAULT NULL COMMENT '产品id',
  `device_secret` varchar(40) DEFAULT NULL COMMENT '设备授权标识',
  `name` varchar(200) DEFAULT NULL COMMENT '设备名称',
  `mac` varchar(60) DEFAULT NULL COMMENT '设备的mac地址(唯一)',
  `state` int(11) DEFAULT NULL COMMENT '设备状态 0未激活，1已激活，2离线，3上线',
  `modify_time` datetime DEFAULT NULL COMMENT '最后一次上线时间',
  `c_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='设备表';

-- ----------------------------
-- Records of app_device
-- ----------------------------
INSERT INTO `app_device` VALUES ('3', null, '1', null, null, '111', '2222', null, null, null);
INSERT INTO `app_device` VALUES ('4', null, null, null, 'BWpz9VfWx5', null, null, null, null, '2019-06-17 21:45:12');

-- ----------------------------
-- Table structure for app_device_recode
-- ----------------------------
DROP TABLE IF EXISTS `app_device_recode`;
CREATE TABLE `app_device_recode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mac` varchar(40) DEFAULT NULL COMMENT '设备mac地址',
  `attrib_name` varchar(40) DEFAULT NULL COMMENT '属性名',
  `attrib_value` varchar(255) DEFAULT '' COMMENT '属性值',
  `type` int(11) DEFAULT NULL COMMENT '类型 0:未知，1：binary,2:bool,3:char,4:short,5:int,6:double,7:string',
  `product_key` varchar(40) DEFAULT NULL COMMENT '产品key',
  `device_secret` varchar(40) DEFAULT NULL COMMENT '设备秘钥',
  `c_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备记状态录表';

-- ----------------------------
-- Records of app_device_recode
-- ----------------------------

-- ----------------------------
-- Table structure for app_product
-- ----------------------------
DROP TABLE IF EXISTS `app_product`;
CREATE TABLE `app_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `user_id` int(11) DEFAULT NULL COMMENT '创建用户id',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `product_key` varchar(40) DEFAULT NULL COMMENT '产品key',
  `attribute` varchar(255) DEFAULT NULL COMMENT '属性(json字符串,从属性表中选择)',
  `type` int(11) DEFAULT '1' COMMENT '入网方式，1:zigbee网关，2:wifi，3:蜂窝网络',
  `state` int(11) DEFAULT '0' COMMENT '产品状态，0：未发布，1已发布',
  `c_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='产品表';

-- ----------------------------
-- Records of app_product
-- ----------------------------
INSERT INTO `app_product` VALUES ('1', '客厅灯泡', '12', '2', 'da4834b1d01a4c44b0687090b44a6d9e', '{\"name\":\"light\"}', '1', '0', '2019-06-17 20:07:31');
INSERT INTO `app_product` VALUES ('2', '烟雾报警器', '12', '2', 'bd85df98ca434b22a66f4580a4d869a3', '{\"name\":\"smart\"}', '1', '0', '2019-06-17 20:07:34');

-- ----------------------------
-- Table structure for app_project
-- ----------------------------
DROP TABLE IF EXISTS `app_project`;
CREATE TABLE `app_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(40) DEFAULT NULL COMMENT '项目名称',
  `project_key` varchar(40) DEFAULT NULL COMMENT '项目key',
  `user_id` int(11) DEFAULT NULL COMMENT '创建用户id',
  `c_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='项目管理';

-- ----------------------------
-- Records of app_project
-- ----------------------------
INSERT INTO `app_project` VALUES ('2', '智能家居管理系统', '5f9990cc6f4d4c10ba6209352f047d0a', '12', '2019-06-17 20:04:42', '2019-06-17 20:04:42', '智能家居管理系统');
INSERT INTO `app_project` VALUES ('3', '测试项目', '8721369546c34a549ed747eeacc42589', '12', '2019-06-17 20:36:33', '2019-06-17 20:36:33', '测试项目');

-- ----------------------------
-- Table structure for sys_icon
-- ----------------------------
DROP TABLE IF EXISTS `sys_icon`;
CREATE TABLE `sys_icon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=265 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_icon
-- ----------------------------
INSERT INTO `sys_icon` VALUES ('2', 'glyphicon glyphicon-asterisk', '2019-06-11 21:10:44');
INSERT INTO `sys_icon` VALUES ('3', 'glyphicon glyphicon-plus', '2019-06-11 21:10:44');
INSERT INTO `sys_icon` VALUES ('4', 'glyphicon glyphicon-euro', '2019-06-11 21:10:44');
INSERT INTO `sys_icon` VALUES ('5', 'glyphicon glyphicon-eur', '2019-06-11 21:10:44');
INSERT INTO `sys_icon` VALUES ('6', 'glyphicon glyphicon-minus', '2019-06-11 21:10:44');
INSERT INTO `sys_icon` VALUES ('7', 'glyphicon glyphicon-cloud', '2019-06-11 21:10:44');
INSERT INTO `sys_icon` VALUES ('8', 'glyphicon glyphicon-envelope', '2019-06-11 21:10:44');
INSERT INTO `sys_icon` VALUES ('9', 'glyphicon glyphicon-pencil', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('10', 'glyphicon glyphicon-glass', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('11', 'glyphicon glyphicon-music', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('12', 'glyphicon glyphicon-search', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('13', 'glyphicon glyphicon-heart', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('14', 'glyphicon glyphicon-star', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('15', 'glyphicon glyphicon-star-empty', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('16', 'glyphicon glyphicon-user', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('17', 'glyphicon glyphicon-film', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('18', 'glyphicon glyphicon-th-large', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('19', 'glyphicon glyphicon-th', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('20', 'glyphicon glyphicon-th-list', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('21', 'glyphicon glyphicon-ok', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('22', 'glyphicon glyphicon-remove', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('23', 'glyphicon glyphicon-zoom-in', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('24', 'glyphicon glyphicon-zoom-out', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('25', 'glyphicon glyphicon-off', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('26', 'glyphicon glyphicon-signal', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('27', 'glyphicon glyphicon-cog', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('28', 'glyphicon glyphicon-trash', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('29', 'glyphicon glyphicon-home', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('30', 'glyphicon glyphicon-file', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('31', 'glyphicon glyphicon-time', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('32', 'glyphicon glyphicon-road', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('33', 'glyphicon glyphicon-download-alt', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('34', 'glyphicon glyphicon-download', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('35', 'glyphicon glyphicon-upload', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('36', 'glyphicon glyphicon-inbox', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('37', 'glyphicon glyphicon-play-circle', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('38', 'glyphicon glyphicon-repeat', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('39', 'glyphicon glyphicon-refresh', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('40', 'glyphicon glyphicon-list-alt', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('41', 'glyphicon glyphicon-lock', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('42', 'glyphicon glyphicon-flag', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('43', 'glyphicon glyphicon-headphones', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('44', 'glyphicon glyphicon-volume-off', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('45', 'glyphicon glyphicon-volume-down', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('46', 'glyphicon glyphicon-volume-up', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('47', 'glyphicon glyphicon-qrcode', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('48', 'glyphicon glyphicon-barcode', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('49', 'glyphicon glyphicon-tag', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('50', 'glyphicon glyphicon-tags', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('51', 'glyphicon glyphicon-book', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('52', 'glyphicon glyphicon-bookmark', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('53', 'glyphicon glyphicon-print', '2019-06-11 21:10:45');
INSERT INTO `sys_icon` VALUES ('54', 'glyphicon glyphicon-camera', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('55', 'glyphicon glyphicon-font', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('56', 'glyphicon glyphicon-bold', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('57', 'glyphicon glyphicon-italic', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('58', 'glyphicon glyphicon-text-height', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('59', 'glyphicon glyphicon-text-width', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('60', 'glyphicon glyphicon-align-left', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('61', 'glyphicon glyphicon-align-center', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('62', 'glyphicon glyphicon-align-right', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('63', 'glyphicon glyphicon-align-justify', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('64', 'glyphicon glyphicon-list', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('65', 'glyphicon glyphicon-indent-left', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('66', 'glyphicon glyphicon-indent-right', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('67', 'glyphicon glyphicon-facetime-video', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('68', 'glyphicon glyphicon-picture', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('69', 'glyphicon glyphicon-map-marker', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('70', 'glyphicon glyphicon-adjust', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('71', 'glyphicon glyphicon-tint', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('72', 'glyphicon glyphicon-edit', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('73', 'glyphicon glyphicon-share', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('74', 'glyphicon glyphicon-check', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('75', 'glyphicon glyphicon-move', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('76', 'glyphicon glyphicon-step-backward', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('77', 'glyphicon glyphicon-fast-backward', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('78', 'glyphicon glyphicon-backward', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('79', 'glyphicon glyphicon-play', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('80', 'glyphicon glyphicon-pause', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('81', 'glyphicon glyphicon-stop', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('82', 'glyphicon glyphicon-forward', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('83', 'glyphicon glyphicon-fast-forward', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('84', 'glyphicon glyphicon-step-forward', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('85', 'glyphicon glyphicon-eject', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('86', 'glyphicon glyphicon-chevron-left', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('87', 'glyphicon glyphicon-chevron-right', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('88', 'glyphicon glyphicon-plus-sign', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('89', 'glyphicon glyphicon-minus-sign', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('90', 'glyphicon glyphicon-remove-sign', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('91', 'glyphicon glyphicon-ok-sign', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('92', 'glyphicon glyphicon-question-sign', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('93', 'glyphicon glyphicon-info-sign', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('94', 'glyphicon glyphicon-screenshot', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('95', 'glyphicon glyphicon-remove-circle', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('96', 'glyphicon glyphicon-ok-circle', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('97', 'glyphicon glyphicon-ban-circle', '2019-06-11 21:10:46');
INSERT INTO `sys_icon` VALUES ('98', 'glyphicon glyphicon-arrow-left', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('99', 'glyphicon glyphicon-arrow-right', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('100', 'glyphicon glyphicon-arrow-up', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('101', 'glyphicon glyphicon-arrow-down', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('102', 'glyphicon glyphicon-share-alt', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('103', 'glyphicon glyphicon-resize-full', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('104', 'glyphicon glyphicon-resize-small', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('105', 'glyphicon glyphicon-exclamation-sign', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('106', 'glyphicon glyphicon-gift', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('107', 'glyphicon glyphicon-leaf', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('108', 'glyphicon glyphicon-fire', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('109', 'glyphicon glyphicon-eye-open', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('110', 'glyphicon glyphicon-eye-close', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('111', 'glyphicon glyphicon-warning-sign', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('112', 'glyphicon glyphicon-plane', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('113', 'glyphicon glyphicon-calendar', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('114', 'glyphicon glyphicon-random', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('115', 'glyphicon glyphicon-comment', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('116', 'glyphicon glyphicon-magnet', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('117', 'glyphicon glyphicon-chevron-up', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('118', 'glyphicon glyphicon-chevron-down', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('119', 'glyphicon glyphicon-retweet', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('120', 'glyphicon glyphicon-shopping-cart', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('121', 'glyphicon glyphicon-folder-close', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('122', 'glyphicon glyphicon-folder-open', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('123', 'glyphicon glyphicon-resize-vertical', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('124', 'glyphicon glyphicon-resize-horizontal', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('125', 'glyphicon glyphicon-hdd', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('126', 'glyphicon glyphicon-bullhorn', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('127', 'glyphicon glyphicon-bell', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('128', 'glyphicon glyphicon-certificate', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('129', 'glyphicon glyphicon-thumbs-up', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('130', 'glyphicon glyphicon-thumbs-down', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('131', 'glyphicon glyphicon-hand-right', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('132', 'glyphicon glyphicon-hand-left', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('133', 'glyphicon glyphicon-hand-up', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('134', 'glyphicon glyphicon-hand-down', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('135', 'glyphicon glyphicon-circle-arrow-right', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('136', 'glyphicon glyphicon-circle-arrow-left', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('137', 'glyphicon glyphicon-circle-arrow-up', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('138', 'glyphicon glyphicon-circle-arrow-down', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('139', 'glyphicon glyphicon-globe', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('140', 'glyphicon glyphicon-wrench', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('141', 'glyphicon glyphicon-tasks', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('142', 'glyphicon glyphicon-filter', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('143', 'glyphicon glyphicon-briefcase', '2019-06-11 21:10:47');
INSERT INTO `sys_icon` VALUES ('144', 'glyphicon glyphicon-fullscreen', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('145', 'glyphicon glyphicon-dashboard', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('146', 'glyphicon glyphicon-paperclip', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('147', 'glyphicon glyphicon-heart-empty', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('148', 'glyphicon glyphicon-link', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('149', 'glyphicon glyphicon-phone', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('150', 'glyphicon glyphicon-pushpin', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('151', 'glyphicon glyphicon-usd', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('152', 'glyphicon glyphicon-gbp', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('153', 'glyphicon glyphicon-sort', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('154', 'glyphicon glyphicon-sort-by-alphabet', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('155', 'glyphicon glyphicon-sort-by-alphabet-alt', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('156', 'glyphicon glyphicon-sort-by-order', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('157', 'glyphicon glyphicon-sort-by-order-alt', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('158', 'glyphicon glyphicon-sort-by-attributes', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('159', 'glyphicon glyphicon-sort-by-attributes-alt', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('160', 'glyphicon glyphicon-unchecked', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('161', 'glyphicon glyphicon-expand', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('162', 'glyphicon glyphicon-collapse-down', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('163', 'glyphicon glyphicon-collapse-up', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('164', 'glyphicon glyphicon-log-in', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('165', 'glyphicon glyphicon-flash', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('166', 'glyphicon glyphicon-log-out', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('167', 'glyphicon glyphicon-new-window', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('168', 'glyphicon glyphicon-record', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('169', 'glyphicon glyphicon-save', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('170', 'glyphicon glyphicon-open', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('171', 'glyphicon glyphicon-saved', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('172', 'glyphicon glyphicon-import', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('173', 'glyphicon glyphicon-export', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('174', 'glyphicon glyphicon-send', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('175', 'glyphicon glyphicon-floppy-disk', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('176', 'glyphicon glyphicon-floppy-saved', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('177', 'glyphicon glyphicon-floppy-remove', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('178', 'glyphicon glyphicon-floppy-save', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('179', 'glyphicon glyphicon-floppy-open', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('180', 'glyphicon glyphicon-credit-card', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('181', 'glyphicon glyphicon-transfer', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('182', 'glyphicon glyphicon-cutlery', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('183', 'glyphicon glyphicon-header', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('184', 'glyphicon glyphicon-compressed', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('185', 'glyphicon glyphicon-earphone', '2019-06-11 21:10:48');
INSERT INTO `sys_icon` VALUES ('186', 'glyphicon glyphicon-phone-alt', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('187', 'glyphicon glyphicon-tower', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('188', 'glyphicon glyphicon-stats', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('189', 'glyphicon glyphicon-sd-video', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('190', 'glyphicon glyphicon-hd-video', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('191', 'glyphicon glyphicon-subtitles', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('192', 'glyphicon glyphicon-sound-stereo', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('193', 'glyphicon glyphicon-sound-dolby', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('194', 'glyphicon glyphicon-sound-5-1', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('195', 'glyphicon glyphicon-sound-6-1', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('196', 'glyphicon glyphicon-sound-7-1', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('197', 'glyphicon glyphicon-copyright-mark', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('198', 'glyphicon glyphicon-registration-mark', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('199', 'glyphicon glyphicon-cloud-download', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('200', 'glyphicon glyphicon-cloud-upload', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('201', 'glyphicon glyphicon-tree-conifer', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('202', 'glyphicon glyphicon-tree-deciduous', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('203', 'glyphicon glyphicon-cd', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('204', 'glyphicon glyphicon-save-file', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('205', 'glyphicon glyphicon-open-file', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('206', 'glyphicon glyphicon-level-up', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('207', 'glyphicon glyphicon-copy', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('208', 'glyphicon glyphicon-paste', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('209', 'glyphicon glyphicon-alert', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('210', 'glyphicon glyphicon-equalizer', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('211', 'glyphicon glyphicon-king', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('212', 'glyphicon glyphicon-queen', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('213', 'glyphicon glyphicon-pawn', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('214', 'glyphicon glyphicon-bishop', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('215', 'glyphicon glyphicon-knight', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('216', 'glyphicon glyphicon-baby-formula', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('217', 'glyphicon glyphicon-tent', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('218', 'glyphicon glyphicon-blackboard', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('219', 'glyphicon glyphicon-bed', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('220', 'glyphicon glyphicon-apple', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('221', 'glyphicon glyphicon-erase', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('222', 'glyphicon glyphicon-hourglass', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('223', 'glyphicon glyphicon-lamp', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('224', 'glyphicon glyphicon-duplicate', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('225', 'glyphicon glyphicon-piggy-bank', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('226', 'glyphicon glyphicon-scissors', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('227', 'glyphicon glyphicon-bitcoin', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('228', 'glyphicon glyphicon-btc', '2019-06-11 21:10:49');
INSERT INTO `sys_icon` VALUES ('229', 'glyphicon glyphicon-xbt', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('230', 'glyphicon glyphicon-yen', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('231', 'glyphicon glyphicon-jpy', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('232', 'glyphicon glyphicon-ruble', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('233', 'glyphicon glyphicon-rub', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('234', 'glyphicon glyphicon-scale', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('235', 'glyphicon glyphicon-ice-lolly', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('236', 'glyphicon glyphicon-ice-lolly-tasted', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('237', 'glyphicon glyphicon-education', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('238', 'glyphicon glyphicon-option-horizontal', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('239', 'glyphicon glyphicon-option-vertical', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('240', 'glyphicon glyphicon-menu-hamburger', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('241', 'glyphicon glyphicon-modal-window', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('242', 'glyphicon glyphicon-oil', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('243', 'glyphicon glyphicon-grain', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('244', 'glyphicon glyphicon-sunglasses', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('245', 'glyphicon glyphicon-text-size', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('246', 'glyphicon glyphicon-text-color', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('247', 'glyphicon glyphicon-text-background', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('248', 'glyphicon glyphicon-object-align-top', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('249', 'glyphicon glyphicon-object-align-bottom', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('250', 'glyphicon glyphicon-object-align-horizontal', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('251', 'glyphicon glyphicon-object-align-left', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('252', 'glyphicon glyphicon-object-align-vertical', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('253', 'glyphicon glyphicon-object-align-right', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('254', 'glyphicon glyphicon-triangle-right', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('255', 'glyphicon glyphicon-triangle-left', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('256', 'glyphicon glyphicon-triangle-bottom', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('257', 'glyphicon glyphicon-triangle-top', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('258', 'glyphicon glyphicon-console', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('259', 'glyphicon glyphicon-superscript', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('260', 'glyphicon glyphicon-subscript', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('261', 'glyphicon glyphicon-menu-left', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('262', 'glyphicon glyphicon-menu-right', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('263', 'glyphicon glyphicon-menu-down', '2019-06-11 21:10:50');
INSERT INTO `sys_icon` VALUES ('264', 'glyphicon glyphicon-menu-up', '2019-06-11 21:10:50');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL COMMENT '名字',
  `url` varchar(255) DEFAULT NULL COMMENT '连接',
  `number` int(11) DEFAULT '0' COMMENT '排序，越小越靠前',
  `pid` int(11) DEFAULT '0' COMMENT '父菜单id',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `c_time` datetime DEFAULT NULL COMMENT '创建时间',
  `c_user` int(11) DEFAULT '0' COMMENT '创建人',
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COMMENT='菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '/view/index.htmls', '0', '0', 'fa fa-sign-in', '2019-06-08 09:29:21', '0', '2019-06-08 21:14:01');
INSERT INTO `sys_menu` VALUES ('2', '用户管理', '/view/sys.sys_user.htmls', '0', '1', 'fa fa-calendar', '2019-06-08 09:31:17', '0', '2019-06-08 22:03:52');
INSERT INTO `sys_menu` VALUES ('3', '角色管理', '/view/sys.sys_role.htmls', '0', '1', 'fa fa-group', null, null, '2019-06-15 11:18:51');
INSERT INTO `sys_menu` VALUES ('5', '功能管理', '', '0', '0', 'glyphicon glyphicon-cog', null, null, '2019-06-16 20:46:28');
INSERT INTO `sys_menu` VALUES ('45', '项目管理', '/view/user.app_project.htmls', '1', '5', 'glyphicon glyphicon-list-alt', null, '0', null);
INSERT INTO `sys_menu` VALUES ('8', '图标管理', '/view/sys.sys_icon.htmls', '0', '1', 'glyphicon glyphicon-star', null, null, '2019-06-15 11:14:03');
INSERT INTO `sys_menu` VALUES ('47', '设备管理', '/view/user.app_device.htmls', '3', '5', 'glyphicon glyphicon-dashboard', null, '0', null);
INSERT INTO `sys_menu` VALUES ('46', '产品管理', '/view/user.app_product.htmls', '2', '5', 'glyphicon glyphicon-align-justify', null, '0', null);
INSERT INTO `sys_menu` VALUES ('43', '菜单管理', '/view/sys.sys_menu.htmls', '1', '1', 'glyphicon glyphicon-th-large', null, '0', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名字',
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `c_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('4', '平台管理员', '2019-06-14 09:37:52', '2019-06-14 09:37:50');
INSERT INTO `sys_role` VALUES ('-1', '系统管理员', '2019-06-15 21:10:37', '2019-06-14 09:37:54');
INSERT INTO `sys_role` VALUES ('5', '普通用户', '2019-06-15 21:10:41', '2019-06-15 21:10:43');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('12', '5', '47', '2019-06-17 20:13:38');
INSERT INTO `sys_role_menu` VALUES ('11', '5', '46', '2019-06-16 20:51:38');
INSERT INTO `sys_role_menu` VALUES ('10', '5', '45', '2019-06-16 20:51:33');
INSERT INTO `sys_role_menu` VALUES ('9', '5', '5', '2019-06-16 20:51:30');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `nick` varchar(40) DEFAULT NULL COMMENT '昵称',
  `name` varchar(40) NOT NULL COMMENT '登录名称',
  `password` varchar(36) NOT NULL COMMENT '密码',
  `photo_path` varchar(255) DEFAULT NULL COMMENT '头像',
  `modity_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `ip` varchar(20) DEFAULT NULL COMMENT '最后一次登录ip',
  `c_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile` (`mobile`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '-1', 'admin', 'admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'http://localhost:8080/Base/admin-lte/dist/img/user2-160x160.jpg', '2019-06-17 20:10:47', '127.0.0.1', '2019-06-09 08:53:17');
INSERT INTO `sys_user` VALUES ('12', '5', 'smadmin', 'smadmin', 'smadmin', 'e10adc3949ba59abbe56e057f20f883e', null, '2019-06-17 21:44:29', '127.0.0.1', null);
