create table cars
(
    car_id      bigint       not null
    primary key,
    car_name    varchar(255) null,
    color       varchar(255) null,
    car_type_id bigint       null,
    price_id    bigint       null
);

create table cars_seq
(
    next_val bigint null
);

insert into cars_seq values ( 1 );
