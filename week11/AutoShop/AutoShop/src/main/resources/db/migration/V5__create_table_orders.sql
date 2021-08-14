create table orders
(
    order_id         bigint not null
        constraint orders_pkey
            primary key,
    date_of_creation timestamp,
    status           varchar(255),
    car_id           bigint
        constraint fkd2p23ixwrrt395glgi9nnbj23
            references cars,
    customer_id      bigint
        constraint fkpxtb8awmi0dk6smoh2vp1litg
            references customers
);


create sequence orders_seq START 1;
