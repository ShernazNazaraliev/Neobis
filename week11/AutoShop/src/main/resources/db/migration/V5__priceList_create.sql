create table price_list
(
    price_id bigint not null
    primary key,
    price double not null
);

create table price_list_seq
(
    next_val bigint null
);

insert into price_list_seq values ( 1 );


