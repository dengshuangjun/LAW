delete from  message;
delete from connection;
delete from mark;
delete from news;
delete from part;
delete from newsType;
delete from log;
delete from law_user;
delete from role;

commit;


--角色表
create table role(
  role_id  int primary key,--角色id
  role_name varchar2(30),--角色name
  role_statue  varchar2(30),--状态
  spare_A  varchar2(50),  --保留字段1
  spare_B  varchar2(100)  --保留字段2
)

create sequence role_id start with 1001;
drop sequence role_id
insert into role values(role_id.nextval,'管理员','Y',null,null);
insert into role values(role_id.nextval,'用户','Y',null,null);
insert into role values(role_id.nextval,'律师','Y',null,null);
insert into role values(role_id.nextval,'贴吧管理员','Y',null,null);
select * from role
delete from role
--用户表
create table law_user(
  usid    int  primary key,  --用户id
  usname  varchar2(30),  --用户名
  usex  varchar2(4)    --用户性别
    constraint CK_law_user_usex check( usex in('男','女') ),
  upwd  varchar2(40),  --密码
  uemail  varchar2(50),  --邮箱
  role_id int       --角色ID
    constraint FK_role_id references role(role_id),
  picpath   varchar2(100),--图像
  tel  varchar2(20)       --联系方式
    constraint CK_law_user_tel check(length(tel)=11),
  law_user_status varchar2(10),--状态
  law_user_status_explain  varchar2(100), --状态说明
  area varchar2(100),
  register_time date,
  birthday      date,
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

alter table law_user modify upwd varchar2(40)

--用户id序列
create sequence seq_law_user_id start with 1001;
drop sequence seq_law_user_id
insert into law_user values(seq_law_user_id.nextval,'admin','男','6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2','123@qq.com',1001,null,12345678910,'Y',null,'湖南衡阳',sysdate,to_date('2016/08/29','yyyy/MM/dd'),null,null,null)
delete from law_user
select * from law_user

--日志表
create table log(
  log_id  int primary key,--日志序列
  usid  int    --用户id
    constraint FK_usid_id references law_user(usid),
  log_IP    varchar2(50), --登录的IP
  log_time  date,   --登录时间
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--日志id序列
create sequence seq_log_id start with 1001;

--新闻类型表
create  table newsType(
  ntid  int primary key,  --新闻类型ID
  ntname  varchar2(50),  --新闻类型名
  status  varchar2(10),  --状态
  usid  int        --用户ID
    constraint FK_newsType_law_user_id references law_user(usid),
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--新闻类型序列
create sequence seq_newsType_id start with 1001;

insert into newsType values (seq_newsType_id.Nextval,'民事','Y',1001,null,null,null);

--版块表
select * from part;
create table part(
  partid  int primary key, --模块id
  partName varchar2(20),   --模块名
  status  varchar2(10),     --状态
  usid  int           --用户名
    constraint FK_part_law_user_id references law_user(usid),
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--版块id序列
create sequence seq_part_id start with 1001;

insert into part values(1001,'校园动态','Y',1001,null,null,null);
insert into part values(1002,'社会聚焦','Y',1001,null,null,null);
insert into part values(1003,'法治视频','Y',1001,null,null,null);
insert into part values(1004,'法治动漫','Y',1001,null,null,null);
insert into part values(1005,'法治摄影','Y',1001,null,null,null);
insert into part values(1006,'法治书画','Y',1001,null,null,null);
insert into part values(1007,'法治小说','Y',1001,null,null,null);
insert into part values(1008,'法治名人','Y',1001,null,null,null);
insert into part values(1009,'法治故事','Y',1001,null,null,null);
insert into part values(1010,'法治典故','Y',1001,null,null,null);
insert into part values(1011,'法治名言','Y',1001,null,null,null);
insert into part values(1012,'法治灯谜','Y',1001,null,null,null);
insert into part values(1013,'法治楹联','Y',1001,null,null,null);
insert into part values(1014,'法治时评','Y',1001,null,null,null);
insert into part values(1015,'以案释法','Y',1001,null,null,null);
insert into part values(1016,'名人说法','Y',1001,null,null,null);
insert into part values(1017,'法规检索','Y',1001,null,null,null);
insert into part values(1018,'法理探索','Y',1001,null,null,null);


--新闻表
create table news(
  nid      int  primary key,     --新闻ID
  nitid  int             --新闻类型ID
    constraint FK_newsType_id references newsType(ntid),
  partid int           --新闻版块ID
    constraint FK_part_id references part(partid),
  title  varchar2(100),       --新闻标题
  ndate  date,           --日期
  weight  int,           --权重
  content  clob,       --新闻内容
  picpath  varchar2(100),       --图片路径
  vediopath varchar2(100),     --视频路径
  voicepath varchar2(100),     --音频路径
  views    int,           --浏览次数
  author    varchar2(30),       --作者或来源
  flag    varchar2(2)       --是否公开
    constraint CK_news_flag check( flag in('Y','N') ),
  news_file varchar2(100),     --附件路径
  usid  int             --操作员
    constraint FK_news_law_user_id references law_user(usid),
  status varchar2(20),   --状态
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)



--新闻ID序列
create sequence seq_news_id start with 1001;

--新闻评论表
create table mark(
  mid  int primary key,    --评论的ID
  nid  int            --新闻ID
    constraint FK_news_id references news(nid),
  mcontent varchar2(200),    --评论内容
  mtime   date,        --评论时间
  usid   int        --评论用户
    constraint FK_mark_law_user_id references law_user(usid),
  usid_IP   varchar2(20),    --评论的IP
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--新闻评论ID序列
create sequence seq_mark_id start with 1001;

--友情链接表
create table connection(
  conn_id  int primary key, --链接id
  conn_name  varchar2(200), --链接名
  conn_address  varchar2(200),  --链接地址
  conn_pic      varchar2(200),--链接图片\
  conn_weight   int,--链接权重
  status        varchar2(100),
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

create sequence seq_conn_id start with 1001;

--留言表
create table message(
  mid  int primary key,--留言id
  mip  varchar2(100),--留言ip
  memail varchar2(100),--留言邮箱
  mcontent clob,  --留言内容
  mtime    date,  --留言时间
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

create sequence seq_message_id start with 1001;
commit;




































--贴吧模块表
create table law_topic_Part(
  partid    int primary key,  --模块ID
  partName  varchar2(20),    --模块名
  introduce varchar2(200),  --模块介绍
  tie_num    int,        --该模块的帖子数
  status  varchar2(20),    --状态
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--模块ID序列
create sequence seq_law_topic_Part_id start with 1001;

--发帖表
create table law_topic(
  tie_id  int primary key,  --帖子ID
  title   varchar2(20),    --标题
  usid   int        --用户ID
    constraint FK_law_topic_law_user_id references law_law_user(usid),
  partid    int        --模块ID
    constraint FK_law_topic_part_id references law_topic_Part(partid),
  law_userIP    varchar2(20),    --用户IP
  tdate    date,        --发表时间
  weight    int,        --权重
  tcontent  varchar2(500),  --内容
  status    varchar2(20),    --状态
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)


--帖子ID的序列
create sequence seq_law_topic_id start with 1001;

--回帖表
create table law_reply_Topics(
  rid  int  primary key,    --回帖ID
  tie_id  int          --帖子的ID
    constraint FK_law_reply_Topics_topic_id references law_topic(tie_id),
  usid   int        --跟帖用户id
    constraint FK_law_reply_Topics_law_user_id references law_law_user(usid),
  rcontent  varchar2(500),  --内容
  rdate    date,        --跟帖时间
  law_userIP    varchar2(20),    --用户IP
  status    varchar2(20),    --状态
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--回帖ID的序列
create sequence seq_law_reply_Topics_id start with 1001;

--社团表
create table law_group(
  law_group_id   int  primary key,  --社团id
  law_group_name   varchar2(50),    --社团名
  law_group_leader varchar2(20),    --社团领导人
  law_group_introduce  varchar2(200),  --社团介绍
  law_group_srouce_path  varchar2(200)--社团资源路径
)

--社团id序列
create sequence seq_law_group_Topics_id start with 1001;

--法治活动
create table law_active(
  aid    int  primary key,   --活动ID
  aname  varchar2(50),      --活动名
  introduce varchar2(200),  --活动介绍
  start_time  date,      --活动开始时间
  end_time    date,      --活动结束时间
  picpath    varchar2(100),  --图片路径
  law_group_id  int      --举办的社团id
    constraint FK_law_active_group_id references law_group(law_group_id),
  usid   int        --操作员
    constraint FK_law_active_usid_id references law_law_user(usid)
)

--活动ID序列
create sequence seq_law_active_id start with 1001;

--吧规吧章表
create table law_topic_rule(
  ruleid  int primary key,    --吧规id
  content  varchar2(500),      --吧规内容
  time  date,          --发布时间
  status  varchar2(20),      --状态
  usid   int          --操作员
    constraint FK_law_topic_rule_law_user_id references law_law_user(usid)
)


--吧规id序列
create sequence seq_law_topic_rule_id start with 1001;
