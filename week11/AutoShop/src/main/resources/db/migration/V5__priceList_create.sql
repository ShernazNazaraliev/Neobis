create table if not exists price_list
(
    price_id bigint not null
    primary key,
    price double not null
);

create table if not exists price_list_seq
(
    next_val bigint null
);


