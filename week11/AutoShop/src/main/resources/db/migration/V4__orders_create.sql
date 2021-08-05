create table orders
(
    order_id bigint not null
            primary key,
    car_id bigint null,
    customer_id bigint null
);

create table orders_seq
(
    next_val bigint null
);

insert into orders_seq values ( 1 );

