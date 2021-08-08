create table orders
(
    order_id bigint not null
        primary key,
    date_of_creation datetime null,
    status varchar(255) null,
    car_id bigint null,
    customer_id bigint null
);

create index FKd2p23ixwrrt395glgi9nnbj23
	on orders (car_id);

create index FKpxtb8awmi0dk6smoh2vp1litg
	on orders (customer_id);

create table orders_seq
(
    next_val bigint
);

insert into orders_seq values(1);