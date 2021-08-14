create table car_type
(
    car_type_id bigint not null
        constraint car_type_pkey
            primary key,
    car_type    varchar(255)
);

create sequence car_type_seq START 8;
