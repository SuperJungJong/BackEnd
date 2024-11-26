-- auto-generated definition
create table mono_trade
(
    no                  bigint auto_increment
        primary key,
    build_year          varchar(255) null,
    buyer_gbn           varchar(255) null,
    cdeal_day           varchar(255) null,
    cdeal_type          varchar(255) null,
    deal_amount         varchar(255) null,
    deal_day            int          null,
    deal_month          int          null,
    deal_year           int          null,
    dealing_gbn         varchar(255) null,
    dong                varchar(255) null,
    estate_agent_sgg_nm varchar(255) null,
    gu                  varchar(255) null,
    house_type          varchar(255) null,
    jibun               varchar(255) null,
    plottage_ar         double       null,
    sgg                 varchar(255) null,
    sgg_cd              int          null,
    si                  varchar(255) null,
    sler_gbn            varchar(255) null,
    total_floor_ar      double       null,
    umd_nm              varchar(255) null
);

