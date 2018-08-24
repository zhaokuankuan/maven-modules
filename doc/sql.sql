  CREATE TABLE `order_table` (
   `id` varchar(20) NOT NULL  COMMENT '主键',
   `user_id` int(11) NOT NULL COMMENT '用户ID',
   `username` varchar(255) NOT NULL COMMENT '用户名',
   `addtime` datetime NOT NULL COMMENT '创建时间',
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB CHARSET=utf8 COMMENT='订单信息'
