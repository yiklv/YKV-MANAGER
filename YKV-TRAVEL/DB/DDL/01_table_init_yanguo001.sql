drop table if exists `trv_wx_info`;
create table `trv_wx_info`(
`appId` varchar(20)not null comment 'APPID',
`appSecret` varchar(34) not null comment '小程序的'

)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '小程序相关的信息存储表';

-- create table user
drop table if exists `trv_syc_city`;
create table `trv_syc_city`(
	`id_key` varchar(36) not null,
	`city_id` varchar(18) not null,
	`city_name` varchar(128) not null,
	`date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	 PRIMARY KEY (`id_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='景区城市表';

drop table if exists `trv_syc_area`;
create table `trv_syc_area`(
	`id_key` varchar(36) not null,
	`area_id` varchar(18) not null,
	`area_name` varchar(128) not null,
	`city_id` varchar(18) not null,
	`date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	 PRIMARY KEY (`id_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市对应的区表';

drop table if exists `trv_spot_info`;
create table `trv_spot_info`(
	`id_key` varchar(36) not null,
	`spot_id` varchar(18) not null comment '景区id',
	`spot_name` varchar(128) not null comment '景区名称',
	`image_url` varchar(128) not null comment '景区缩略图',
	`city_id` varchar(18) not null comment '城市id',
	`area_id` varchar(18) not null comment '地区id',
	`spot_price` DECIMAL(10,2) not null comment '景点现价',
	`spot_old_price` DECIMAL(10,2) not null comment '景点原价',
	`spot_level` varchar(16) comment '景区级别  3A景区，4A景区，5A景区',
	`spot_address` varchar(500) not null comment '景区地址',
	`date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	 PRIMARY KEY (`id_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='景点表';
create unique INDEX `trv_spot_info_sid` on `trv_spot_info`(`spot_id`);

drop table if exists `trv_spot_info_desc`;
create table `trv_spot_info_desc`(
	`id_key` varchar(36) not null,
	`spot_id` varchar(18) not null comment '景区id',
	`spot_intr_desc` TEXT comment '景点介绍',
	`spot_note_desc` TEXT comment '景点须知',
	`date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	 PRIMARY KEY (`id_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='景点介绍表';
create unique INDEX `trv_spot_info_desc_sid` on `trv_spot_info_desc`(`spot_id`);

drop table if exists `trv_spot_img`;
create table `trv_spot_img`(
	`id_key` varchar(36) not null,
	`spot_id` varchar(18) not null,
	`image_url` varchar(128) not null comment '景区图路径',
	`date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	 PRIMARY KEY (`id_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='景点对应的轮播图表';
create INDEX `trv_spot_img_sid` on  `trv_spot_img`(`spot_id`);

drop table if exists `trv_spot_opentime`;
create table `trv_spot_opentime`(
	`id_key` varchar(36) not null,
	`spot_id` varchar(18) not null,
	`open_time_desc` varchar(128) not null comment '景区图路径',
	`date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	 PRIMARY KEY (`id_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='景点对应的开放时间表';
create INDEX `trv_spot_opentime_sid` on `trv_spot_opentime`(`spot_id`);

drop table if exists `trv_spot_tkt_type`;
create table `trv_spot_tkt_type`(
	`id_key` varchar(36) not null,
	`spot_id` varchar(18) not null,
	`tkt_type` varchar(128) not null comment '景区图路径',
	`date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	 PRIMARY KEY (`id_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='景点和票务类型对应表';
create unique INDEX `trv_spot_tkt_type_uk` on `trv_spot_tkt_type`(`spot_id`, `tkt_type`);
create INDEX `trv_spot_tkt_type_sid` on  `trv_spot_tkt_type`(`spot_id`);

drop table if exists `trv_syc_tkttype`;
create table `trv_syc_tkttype`(
	`id_key` varchar(36) not null,
	`type_id` varchar(18) not null comment '票务类型',
	`type_name` varchar(128) not null comment '票务类型名称',
	`type_image` varchar(200) not null comment '类型对应图片名称',
	`date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	 PRIMARY KEY (`id_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门票类型表';

drop table if exists `trv_tkt_info`;
create table `trv_tkt_info`(
	`id_key` varchar(36) not null,
	`tkt_id` varchar(18) not null comment '票务id',
	`tkt_name` varchar(200) not null comment '票务名称',
	`tkt_price` decimal(18, 2) not null comment '票价',
	`tkt_old_price` decimal(18, 2) not null comment '票原价',
	`spot_id` varchar(128) not null comment '景点id',
	`tkt_type` varchar(18) not null comment '票务类型',
	`date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	 PRIMARY KEY (`id_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门票表';
create INDEX `trv_tkt_info_sid` on `trv_tkt_info`(`tkt_id`);

drop table if exists `trv_tkt_info_desc`;
create table `trv_tkt_info_desc`(
	`id_key` varchar(36) not null,
	`tkt_id` varchar(18) not null comment '票务id',
	`tkt_note_desc` TEXT not null comment '购票须知',
	`date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	 PRIMARY KEY (`id_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门票购票须知表';
create INDEX `trv_tkt_info_desc_sid` on `trv_tkt_info_desc`(`tkt_id`);

drop table if exists `trv_spot_keyword`;
create table `trv_spot_keyword`(
  `id_key` varchar(36) not null,
  `word_id` varchar(18) not null comment 'spotid',
  `word_name` varchar(100) not null comment '关键词名称',
  `word_status` varchar(2) not null comment '关键词是否有效  N失效 , Y有效',
  `word_level` int comment '关键词的优先级',
  `date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	PRIMARY KEY (`id_key`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='景点关键词表';


drop table if exists `trv_spot_order`;
create table `trv_spot_order`(
  `id_key` varchar(36) not null,
  `order_id` varchar(16) not null comment '订单id',
  `order_info` varchar(100) comment '订单详情',
  `user_id` varchar(16) not null comment '订单用户',
  `spot_id` varchar(18) not null comment '景点id',
  `tkt_id` varchar(18) not null comment '票务id',
  `trv_time` varchar(10) not null comment '游玩日期',
  `order_price` decimal(18, 2) not null comment '单价',
  `tkt_num` tinyint not null comment '购票数量',
  `date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	PRIMARY KEY (`id_key`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单信息';

drop table if exists `trv_spot_book_info`;
create table `trv_spot_book_info`(
  `id_key` varchar(36) not null,
  `user_id` varchar(32) not null comment '订单用户',
  `real_name` varchar(64) not null comment '姓名',
  `mobilePhone` varchar(12) comment '手机号',
  `id_no` varchar(20) not null comment '身份证',
  `date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	PRIMARY KEY (`id_key`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='取票人信息';



drop table if exists `trv_syc_user`;
create table `trv_syc_user`(
  `id_key` varchar(36) not null,
  `user_id` varchar(32) not null comment '用户id',
  `nick_name` varchar(16) not null comment '微信用户名',
  `avatar_url` varchar(300 ) not null comment '头像的url',
  `gender` varchar(2) not null comment '性别 1 男',
  `city` varchar(32) not null comment '城市',
  `country` varchar(32) not null comment '国家',
  `province` varchar(32) not null comment '省份',
  `signature` varchar(64) not null comment '签名',
  `date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	PRIMARY KEY (`id_key`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小程序用户信息';
create unique INDEX `trv_syc_user_sid` on `trv_syc_user`(`user_id`);


drop table if exists `trv_admin_user`;
create table `trv_syc_user`(
  `id_key` varchar(36) not null,
  `user_id` varchar(32) not null comment '用户id',
  `password` varchar(300 ) not null comment '密码',
  `gender` varchar(2) not null comment '性别 1 男',
  `mobilePhone` varchar(32) not null comment '手机号',
  `date_created` timestamp  default CURRENT_TIMESTAMP,
	`created_by` varchar(64) default 'SYSTEM',
	`date_updated` timestamp  default CURRENT_TIMESTAMP,
	`updated_by` varchar(64) default 'SYSTEM',
	PRIMARY KEY (`id_key`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门票管理用户表';
create unique INDEX `trv_syc_user_sid` on `trv_syc_user`(`user_id`);