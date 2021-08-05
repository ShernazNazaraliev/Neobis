create table if not exists customers
(
    customer_id bigint not null
    primary key,
    adress varchar(255) null,
    customers_name varchar(255) null,
    email varchar(255) null,
    phone_number varchar(255) null
    );



create table if not exists customer_seq
(
    next_val bigint null
);