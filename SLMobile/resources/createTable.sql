
-- 网页版聊天
drop table CT_userinfo,CT_userdynamic,CT_friend_group,CT_friends_group_mem,CT_room,CT_room_type,CT_room_member,CT_room_Msg,CT_1V1_Msg
if exists(select * from sysobjects where id = object_id(N'CT_userinfo')) drop table CT_userinfo 

create table CT_userinfo(
uid varchar(20) primary key,
uname varchar(20) not null,
nickName varchar(25) null,
head image null,
photo varchar(20) null,
sex char null,
age int null,
lastLogin datetime null,
dr smallint not null default 0
)

create table CT_userdynamic(
id varchar(32) primary key,
uid varchar(20),
type int null default 1,
time datetime not null,
txt nvarchar(500) not null,
voice image null,
dr smallint not null default 0
)

create table CT_friend_group(
id int primary key identity(1,1),
uid varchar(20) not null,
sequence int null,
name nvarchar(50) not null,
time datetime null,
dr smallint not null default 0
)

create table CT_friends_group_mem(
id varchar(32) primary key,
groupID int not null,
uid varchar(20) not null
)
create table CT_room(
id int primary key identity(1,1),
time datetime not null,
name nvarchar(50) not null,
type int null default 1,
photo varchar(50) null,
pwd varchar(10) null,
createUser varchar(20) not null,
createUname varchar(20) null,
dr smallint not null default 0
)
create table CT_room_type(
id int primary key identity(1,1),
name varchar(20) not null,
dr smallint not null default 0
)

create table CT_room_member(
id int primary key identity(1,1),
roomID int not null,
uid varchar(20) not null,
dr smallint not null default 0
)

create table CT_room_Msg(
id varchar(32) primary key,
time datetime not null,
sendUser varchar(20) not null,
txt nvarchar(200) null,
voice image null,
state smallint not null default 0
)
-- 状态state：0未读；1已读
create table CT_1V1_Msg(
id varchar(32) primary key,
time datetime not null,
sendUser varchar(20) not null,
receiveUser varchar(20) not null,
txt nvarchar(200) null,
voice image null,
state smallint not null default 0
)





