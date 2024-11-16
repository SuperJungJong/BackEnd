create table if not exists do
(
    id   bigint unsigned auto_increment
        primary key,
    code varchar(20) not null comment 'ㅂ법정동 코드',
    name varchar(20) not null comment '한글이름'
);

create table if not exists gu
(
    id   bigint unsigned auto_increment
        primary key,
    code varchar(20) not null comment 'ㅂ법정동 코드',
    name varchar(20) not null comment '한글이름'
);

create table if not exists legal_dong
(
    id   bigint unsigned auto_increment
        primary key,
    code int         not null comment 'ㅂ법정동 코드',
    name varchar(20) not null comment '한글이름'
);

