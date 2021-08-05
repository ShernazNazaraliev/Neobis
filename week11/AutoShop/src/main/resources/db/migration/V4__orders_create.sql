create table if not exists orders
(
    order_id bigint not null
            primary key,
    car_id bigint null,
    customer_id bigint null
);

create table if not exists order_seq
(
    next_val bigint null
);

