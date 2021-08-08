create table car_type
(
    car_type_id bigint not null
        primary key,
    car_type varchar(255) null
);

create table car_type_seq
(
    next_val bigint
);

insert into car_type_seq values (1);