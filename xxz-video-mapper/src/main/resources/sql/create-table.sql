-- 用户表
CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`name` varchar(50) NOT NULL	COMMENT '用户姓名',
	`password` varchar(50) NOT NULL	COMMENT '用户密码',
	`age` int(6) DEFAULT 0 COMMENT '用户年龄',
	`avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
	`fans_counts` BIGINT(20) DEFAULT 0 COMMENT '用户粉丝数',
	`follows_counts` BIGINT(20) DEFAULT 0 COMMENT '我关注的用户数',
	`receive_like_counts` BIGINT(20) DEFAULT 0 COMMENT '获赞数量',
	`wxid` varchar(50) DEFAULT NULL COMMENT '微信号',
	`points` BIGINT(20) DEFAULT 0 COMMENT '用户积分',
	`description` varchar(255) DEFAULT NULL COMMENT '用户个人介绍',
	`status` TINYINT(1) DEFAULT 1 COMMENT '用户状态，1：正常用户，2：vip用户，3：拉黑用户',
  `create_time` datetime NOT NULL COMMENT '创建时间，即关注时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `del` tinyint(1) DEFAULT 0 COMMENT '删除标志，1：已删除；0：正常',
  PRIMARY KEY (`id`),
  KEY `idx_del` (`del`)
) COMMENT "用户表" ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 视频表
CREATE TABLE `videos` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(10) NOT NULL COMMENT '发布者用户id',
	`audio_id` int(10) DEFAULT NULL COMMENT '音频id，默认为null',
	`video_desc` varchar(128) DEFAULT NULL COMMENT 'video描述',
	`video_path` varchar(255) NOT NULL COMMENT 'video地址',
	`video_seconds` FLOAT(6) NOT NULL COMMENT 'video时长',
	`video_width` INT(6) DEFAULT NULL COMMENT 'video宽度',
	`video_height` INT(6) DEFAULT NULL COMMENT 'video高度',
	`cover_path` varchar(255) NOT NULL COMMENT 'video封面地址',
  `like_counts` BIGINT(20) NOT NULL COMMENT '点赞数',
	`status` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '视频状态，(默认)1：正常，2：禁播，3：审核中',
  `create_time` datetime NOT NULL COMMENT '创建时间，即关注时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `del` tinyint(1) DEFAULT 0 COMMENT '删除标志，1：已删除；0：正常',
  PRIMARY KEY (`id`),
  KEY `idx_del` (`del`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 用户粉丝表
CREATE TABLE `users_fans` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(10) NOT NULL COMMENT '用户id',
  `fan_id` int(10) NOT NULL COMMENT '粉丝id',
  `create_time` datetime NOT NULL COMMENT '创建时间，即关注时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `del` tinyint(1) DEFAULT 0 COMMENT '删除标志，1：已删除；0：正常',
  PRIMARY KEY (`id`),
  KEY `idx_del` (`del`)
) COMMENT "用户粉丝表" ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 用户点赞表
CREATE TABLE `users_like_videos` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(10) NOT NULL COMMENT '用户id',
  `video_id` int(10) NOT NULL COMMENT '视频id',
  `create_time` datetime NOT NULL COMMENT '创建时间，即点赞时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `del` tinyint(1) DEFAULT 0 COMMENT '删除标志，1：已删除；0：正常',
  PRIMARY KEY (`id`),
  KEY `idx_del` (`del`)
) COMMENT "用户点赞表" ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 用户举报表
CREATE TABLE `users_report` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(10) NOT NULL COMMENT '(举报者)用户id',
  `video_id` int(10) NOT NULL COMMENT '视频id',
	`report_type` int(6) NOT	NULL COMMENT '举报类型,详见枚举',
	`report_desc` varchar(255) NOT NULL COMMENT '举报内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `del` tinyint(1) DEFAULT 0 COMMENT '删除标志，1：已删除；0：正常',
  PRIMARY KEY (`id`),
  KEY `idx_del` (`del`)
) COMMENT "用户举报表" ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- bgm表
CREATE TABLE `bgm` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(10) NOT NULL COMMENT '上传者用户id',
  `name` varchar(64) NOT NULL COMMENT '背景音乐名称',
	`path`  varchar(255) NOT NULL COMMENT '音频地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `del` tinyint(1) DEFAULT 0 COMMENT '删除标志，1：已删除；0：正常',
  PRIMARY KEY (`id`),
  KEY `idx_del` (`del`)
) COMMENT "背景音乐" ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 搜索记录表
CREATE TABLE `search_records` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` int(10) NOT NULL COMMENT '内容',
	`counts` int(10) NOT NULL COMMENT '搜索次数',
  `del` tinyint(1) DEFAULT 0 COMMENT '删除标志，1：已删除；0：正常',
  PRIMARY KEY (`id`),
  KEY `idx_del` (`del`)
) COMMENT "搜索记录表" ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 评论表
CREATE TABLE `comments` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `video_id` int(10) NOT NULL COMMENT '视频id',
	`user_id` int(10) NOT NULL COMMENT '用户id',
	`comment` varchar(500) NOT NULL COMMENT '评论内容',
	`create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `del` tinyint(1) DEFAULT 0 COMMENT '删除标志，1：已删除；0：正常',
  PRIMARY KEY (`id`),
  KEY `idx_del` (`del`)
) COMMENT "评论表" ENGINE=InnoDB DEFAULT CHARSET=utf8;