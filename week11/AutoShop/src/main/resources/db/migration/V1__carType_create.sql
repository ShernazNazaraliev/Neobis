create table if not exists car_type
(
    car_type_id bigint       not null
    primary key,
    car_type    varchar(255) null
    );



create table if not exists car_type_seq
(
    next_val bigint not null
);

