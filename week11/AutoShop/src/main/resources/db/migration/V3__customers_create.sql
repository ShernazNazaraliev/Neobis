create table customers
(
    customer_id bigint not null
    primary key,
    adress varchar(255) null,
    customers_name varchar(255) null,
    email varchar(255) null,
    phone_number varchar(255) null
    );



create table customers_seq
(
    next_val bigint null
);

insert into customers_seq values ( 1 );