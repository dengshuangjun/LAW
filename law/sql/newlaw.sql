drop table message;
drop table connection;
drop table mark;
drop table news;
drop table part;
drop table newsType;
drop table log;
drop table law_user;
drop table role;

commit;


--��ɫ��
create table role(
  role_id  int primary key,--��ɫid
  role_name varchar2(30),--��ɫname
  role_statue  varchar2(30),--״̬
  spare_A  varchar2(50),  --�����ֶ�1
  spare_B  varchar2(100)  --�����ֶ�2
)

create sequence role_id start with 1001;
drop sequence role_id
insert into role values(role_id.nextval,'����Ա','Y',null,null);
insert into role values(role_id.nextval,'�û�','Y',null,null);
insert into role values(role_id.nextval,'��ʦ','Y',null,null);
insert into role values(role_id.nextval,'���ɹ���Ա','Y',null,null);
select * from role
delete from role
--�û���
create table law_user(
  usid    int  primary key,  --�û�id
  usname  varchar2(30),  --�û���
  usex  varchar2(4)    --�û��Ա�
    constraint CK_law_user_usex check( usex in('��','Ů') ),
  upwd  varchar2(30),  --����
  uemail  varchar2(50),  --����
  role_id int       --��ɫID
    constraint FK_role_id references role(role_id),
  picpath   varchar2(100),--ͼ��
  tel  varchar2(20)       --��ϵ��ʽ
    constraint CK_law_user_tel check(length(tel)=11),
  law_user_status varchar2(10),--״̬
  law_user_status_explain  varchar2(100), --״̬˵��
  area varchar2(100),
  register_time date,
  birthday      date,
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--�û�id����
create sequence seq_law_user_id start with 1001;

insert into law_user values(seq_law_user_id.nextval,'admin','��','a','123@qq.com',1001,null,12345678910,'Y',null,'���Ϻ���',sysdate,to_date('2016/08/29','yyyy/MM/dd'),null,null,null)
delete from law_user
select * from law_user

--��־��
create table log(
  log_id  int primary key,--��־����
  usid  int    --�û�id
    constraint FK_usid_id references law_user(usid),
  log_IP    varchar2(50), --��¼��IP
  log_time  date,   --��¼ʱ��
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--��־id����
create sequence seq_log_id start with 1001;

--�������ͱ�
create  table newsType(
  ntid  int primary key,  --��������ID
  ntname  varchar2(50),  --����������
  status  varchar2(10),  --״̬
  usid  int        --�û�ID
    constraint FK_newsType_law_user_id references law_user(usid),
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--������������
create sequence seq_newsType_id start with 1001;

insert into newsType values (seq_newsType_id.Nextval,'����','Y',1001,null,null,null);

--����
select * from part;
create table part(
  partid  int primary key, --ģ��id
  partName varchar2(20),   --ģ����
  status  varchar2(10),     --״̬
  usid  int           --�û���
    constraint FK_part_law_user_id references law_user(usid),
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--���id����
create sequence seq_part_id start with 1001;


insert into part values(1001,'У԰��̬','Y',1001,null,null,null);
insert into part values(1002,'���۽�','Y',1001,null,null,null);
insert into part values(1003,'������Ƶ','Y',1001,null,null,null);
insert into part values(1004,'���ζ���','Y',1001,null,null,null);
insert into part values(1005,'������Ӱ','Y',1001,null,null,null);
insert into part values(1006,'�����黭','Y',1001,null,null,null);
insert into part values(1007,'����С˵','Y',1001,null,null,null);
insert into part values(1008,'��������','Y',1001,null,null,null);
insert into part values(1009,'���ι���','Y',1001,null,null,null);
insert into part values(1010,'���ε��','Y',1001,null,null,null);
insert into part values(1011,'��������','Y',1001,null,null,null);
insert into part values(1012,'���ε���','Y',1001,null,null,null);
insert into part values(1013,'�������','Y',1001,null,null,null);
insert into part values(1014,'����ʱ��','Y',1001,null,null,null);
insert into part values(1015,'�԰��ͷ�','Y',1001,null,null,null);
insert into part values(1016,'����˵��','Y',1001,null,null,null);
insert into part values(1017,'�������','Y',1001,null,null,null);
insert into part values(1018,'����̽��','Y',1001,null,null,null);


--���ű�
create table news(
  nid      int  primary key,     --����ID
  nitid  int             --��������ID
    constraint FK_newsType_id references newsType(ntid),
  partid int           --���Ű��ID
    constraint FK_part_id references part(partid),
  title  varchar2(100),       --���ű���
  ndate  date,           --����
  weight  int,           --Ȩ��
  content  clob,       --��������
  picpath  varchar2(100),       --ͼƬ·��
  vediopath varchar2(100),     --��Ƶ·��
  voicepath varchar2(100),     --��Ƶ·��
  views    int,           --�������
  author    varchar2(30),       --���߻���Դ
  flag    varchar2(2)       --�Ƿ񹫿�
    constraint CK_news_flag check( flag in('Y','N') ),
  news_file varchar2(100),     --����·��
  usid  int             --����Ա
    constraint FK_news_law_user_id references law_user(usid),
  status varchar2(20),   --״̬
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)



--����ID����
create sequence seq_news_id start with 1001;

--�������۱�
create table mark(
  mid  int primary key,    --���۵�ID
  nid  int            --����ID
    constraint FK_news_id references news(nid),
  mcontent varchar2(200),    --��������
  mtime   date,        --����ʱ��
  usid   int        --�����û�
    constraint FK_mark_law_user_id references law_user(usid),
  usid_IP   varchar2(20),    --���۵�IP
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--��������ID����
create sequence seq_mark_id start with 1001;

--�������ӱ�
create table connection(
  conn_id  int primary key, --����id
  conn_name  varchar2(200), --������
  conn_address  varchar2(200),  --���ӵ�ַ
  conn_pic      varchar2(200),--����ͼƬ\
  conn_weight   int,--����Ȩ��
  status        varchar2(100),
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

create table seq_conn_id start with 1001;

--���Ա�
create table message(
  mid  int primary key,--����id
  mip  varchar2(100),--����ip
  memail varchar2(100),--��������
  mcontent clob,  --��������
  mtime    date,  --����ʱ��
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

create table seq_message_id start with 1001;





































--����ģ���
create table law_topic_Part(
  partid    int primary key,  --ģ��ID
  partName  varchar2(20),    --ģ����
  introduce varchar2(200),  --ģ�����
  tie_num    int,        --��ģ���������
  status  varchar2(20),    --״̬
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--ģ��ID����
create sequence seq_law_topic_Part_id start with 1001;

--������
create table law_topic(
  tie_id  int primary key,  --����ID
  title   varchar2(20),    --����
  usid   int        --�û�ID
    constraint FK_law_topic_law_user_id references law_law_user(usid),
  partid    int        --ģ��ID
    constraint FK_law_topic_part_id references law_topic_Part(partid),
  law_userIP    varchar2(20),    --�û�IP
  tdate    date,        --����ʱ��
  weight    int,        --Ȩ��
  tcontent  varchar2(500),  --����
  status    varchar2(20),    --״̬
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)


--����ID������
create sequence seq_law_topic_id start with 1001;

--������
create table law_reply_Topics(
  rid  int  primary key,    --����ID
  tie_id  int          --���ӵ�ID
    constraint FK_law_reply_Topics_topic_id references law_topic(tie_id),
  usid   int        --�����û�id
    constraint FK_law_reply_Topics_law_user_id references law_law_user(usid),
  rcontent  varchar2(500),  --����
  rdate    date,        --����ʱ��
  law_userIP    varchar2(20),    --�û�IP
  status    varchar2(20),    --״̬
  spare_A  varchar2(50),
  spare_B  varchar2(100),
  spare_C  varchar2(200)
)

--����ID������
create sequence seq_law_reply_Topics_id start with 1001;

--���ű�
create table law_group(
  law_group_id   int  primary key,  --����id
  law_group_name   varchar2(50),    --������
  law_group_leader varchar2(20),    --�����쵼��
  law_group_introduce  varchar2(200),  --���Ž���
  law_group_srouce_path  varchar2(200)--������Դ·��
)

--����id����
create sequence seq_law_group_Topics_id start with 1001;

--���λ
create table law_active(
  aid    int  primary key,   --�ID
  aname  varchar2(50),      --���
  introduce varchar2(200),  --�����
  start_time  date,      --���ʼʱ��
  end_time    date,      --�����ʱ��
  picpath    varchar2(100),  --ͼƬ·��
  law_group_id  int      --�ٰ������id
    constraint FK_law_active_group_id references law_group(law_group_id),
  usid   int        --����Ա
    constraint FK_law_active_usid_id references law_law_user(usid)
)

--�ID����
create sequence seq_law_active_id start with 1001;

--�ɹ���±�
create table law_topic_rule(
  ruleid  int primary key,    --�ɹ�id
  content  varchar2(500),      --�ɹ�����
  time  date,          --����ʱ��
  status  varchar2(20),      --״̬
  usid   int          --����Ա
    constraint FK_law_topic_rule_law_user_id references law_law_user(usid)
)


--�ɹ�id����
create sequence seq_law_topic_rule_id start with 1001;
