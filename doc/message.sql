# 消息表

create table message
(
    id bigint not null,
    sender_id bigint null,
    receiver_id bigint null,
    content varchar(2000) null,
    time datetime default CURRENT_TIMESTAMP null,
    constraint message_pk
        primary key (id)
)engine = innodb
 default charset = utf8mb4
    comment '消息表';

