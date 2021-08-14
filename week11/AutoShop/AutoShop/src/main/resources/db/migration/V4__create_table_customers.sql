create table customers
(
    customer_id      bigint not null
        constraint customers_pkey
            primary key,
    customer_address varchar(255),
    customer_name    varchar(255),
    customer_email   varchar(255),
    phone_number     varchar(255)
);

create sequence customers_seq START 1;

