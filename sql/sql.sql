# 如果原来的数据库存在就删除
drop database if exists book;
# 创建数据库
create database book;

# 创建用户表 t_user
create table t_user(
	`id` int primary key auto_increment,
	`username` varchar(20) not null unique,
	`password` varchar(32) not null,
	`email` varchar(50) 
);

# 创建图书表
create table t_book(
	`id` int(11) primary key auto_increment, 	## 主键
	`name` varchar(50) not null,				## 书名 
	`author` varchar(50) not null,				## 作者
	`price` decimal(11,2) not null,				## 价格
	`sales` int(11) not null,					## 销量
	`stock` int(11) not null,					## 库存
	`img_path` varchar(200) not null			## 书的图片路径
);

# 创建订单表
create table t_order(
	`order_id` varchar(50) primary key,  	    ## 订单号
	`create_time` datetime not null,	        ## 订单时间
	`total_money` decimal(11,2) not null,	    ## 总金额
	`status` int not null default 0, 	        ## 物流状态 0-未发货 1-等待用户签收 2-用户已签收
	`user_id` int not null,			            ## 用户编号
	foreign key (`user_id`) references t_user(`id`)
);


## 创建订单项
create table t_order_item(
	`id` int primary key auto_increment, 
	`name` varchar(30) not null,		        ## 商品名
	`price` decimal(11,2),			            ## 商品单价
	`total_money` decimal(11,2),		        ## 商品总金额
	`count` int not null,			            ## 商品数量
	`order_id` varchar(50) not null,	        ## 订单号
	foreign key (`order_id`) references t_order(`order_id`)
);

