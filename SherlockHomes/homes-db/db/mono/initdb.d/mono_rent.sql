-- auto-generated definition
create table mono_rent
(
    no               bigint auto_increment
        primary key,
    build_year       int          null,
    contract_term    varchar(255) null,
    contract_type    varchar(255) null,
    deal_day         int          null,
    deal_month       int          null,
    deal_year        int          null,
    deposit          varchar(255) null,
    dong             varchar(255) null,
    gu               varchar(255) null,
    house_type       varchar(255) null,
    monthly_rent     int          null,
    pre_deposit      varchar(255) null,
    pre_monthly_rent varchar(255) null,
    sgg              varchar(255) null,
    sgg_cd           varchar(255) null,
    si               varchar(255) null,
    total_floor_ar   double       null,
    umd_nm           varchar(255) null,
    userrright       varchar(255) null
);

