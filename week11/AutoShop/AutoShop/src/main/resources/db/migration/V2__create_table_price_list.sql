create table price_list
(
    price_id bigint not null
        primary key,
    price double null
);

create table price_list_seq
(
    next_val bigint
);

insert into price_list_seq values (6);