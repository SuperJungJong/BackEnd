create database if not exists user;
use user;

create table if not exists user
(
    id            bigint unsigned auto_increment
        primary key,
    nickname      varchar(10)                        not null comment '닉네임',
    method        varchar(10)                        not null comment '가입 방법 (naver, kakao 등)',
    ci            varchar(50)                        not null comment '유저 ci',
    image         mediumblob                         null comment '프로필 사진',
    role          int      default 0                 not null comment 'role',
    registered_at datetime default CURRENT_TIMESTAMP not null comment '가입일',
    modified_at   datetime                           null comment '수정일',
    unique (ci)

);

create table if not exists refresh_token
(
    id            bigint unsigned auto_increment
        primary key,
    user_id       bigint                             not null comment 'user id',
    ci            varchar(50)                        not null comment 'ci',
    refresh_token varchar(255)                       not null comment '리프레쉬 토큰',
    created_at    datetime default CURRENT_TIMESTAMP not null comment '생성일',
    modified_at   datetime                           null comment '수정일',
    unique (ci, user_id)
);
