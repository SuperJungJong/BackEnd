use apt;
create table gu_count(
                         id bigint not null auto_increment primary key,
                         si_name varchar(20) not null,
                         gu_name varchar(20) not null,
                         count int not null
);

INSERT INTO gu_count (
    si_name,
    gu_name,
    count
)
SELECT si, gu, count(gu)
FROM apt_trade
group by si, gu;