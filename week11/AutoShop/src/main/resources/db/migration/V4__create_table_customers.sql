create table customers
(
    customer_id bigint not null
        primary key,
    customer_address varchar(255) null,
    customer_name varchar(255) null,
    customer_email varchar(255) null,
    phone_number varchar(255) null
);

create table customers_seq
(
    next_val bigint
);

insert into customers_seq values (1);