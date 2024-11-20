use apt;

create table apt_trade
(

    no          bigint not null auto_increment
    primary key,
    sgg         varchar(100) comment '시군구',
    si         varchar(20) comment '시',
    gu         varchar(20) comment '구',
    dong         varchar(20) comment '동',
    jibun       varchar(20) comment '번지',
    apt_nm      varchar(30) comment '단지명',
    exdu_use_ar double comment '전용면적',
    deal_y     varchar(10) comment '계약년',
    deal_m     varchar(10) comment '계약월',
    deal_d      varchar(10) comment '계약일',
    deal_amount varchar(30) comment '거래금액',
    apt_dong    varchar(10) comment '동',
    floor       varchar(10) comment '층',
    buy         varchar(10) comment '매수자',
    seller      varchar(10) comment '매도자',
    build_year  varchar(10) comment '건축년도',
    road_nm     varchar(40) comment '도로명',
    special_day varchar(10) comment '해제사유발생일',
    type        varchar(10) comment '거래유형',
    middle_addr varchar(30) comment '중개사소재지',
    key apt_nm_idx(apt_nm),
    key gu_idx(gu),
    key dong_idx(dong)
);
create index dong_idx on apt_trade(dong);
-- INSERT INTO apt_trade (
--    sgg,
--    si,
--    gu,
--    dong,
--    jibun,
--    apt_nm,
--    exdu_use_ar,
--    deal_y,
--    deal_m,
--    deal_d,
--     deal_amount,
--     apt_dong,
--     floor,
--     buy, seller,
--    build_year,
--    road_nm,
--    special_day,
--    type,
--    middle_addr)
-- SELECT concat(sido_name, ' ', gugun_name, ' ', dong_name), sido_name, gugun_name, dong_name, i.jibun, i.apt_nm,
--         d.exclu_use_ar, d.deal_year, d.deal_month, d.deal_day, d.deal_amount,
--         '-', d.floor, '-', '-', i.build_year, concat(i.road_nm, ' ', i.road_nm_bonbun, '-', i.road_nm_bubun), '-',
--         '-', '-'
-- FROM houseinfos i
-- JOIN housedeals d
-- join dongcodes  dc
-- ON i.apt_seq = d.apt_seq
-- and concat(i.sgg_cd, umd_cd) = dc.dong_code;