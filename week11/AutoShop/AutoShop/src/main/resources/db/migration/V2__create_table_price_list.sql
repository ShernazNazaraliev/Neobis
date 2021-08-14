create table price_list
(
    price_id bigint not null
        constraint price_list_pkey
            primary key,
    price    double precision
);

create sequence price_list_seq START 6;
