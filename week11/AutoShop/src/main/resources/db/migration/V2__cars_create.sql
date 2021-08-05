create table if not exists cars
(
    car_id      bigint       not null
    primary key,
    car_name    varchar(255) null,
    color       varchar(255) null,
    car_type_id bigint       null,
    price_id    bigint       null
    );