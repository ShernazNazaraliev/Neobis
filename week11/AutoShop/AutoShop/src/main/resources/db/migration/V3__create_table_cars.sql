create table cars
(
    car_id      bigint not null
        constraint cars_pkey
            primary key,
    car_name    varchar(255),
    car_color   varchar(255),
    car_type_id bigint
        constraint fkcki51tfk2udss8oujqvpu1mpj
            references car_type,
    price_id    bigint
        constraint fk1itgarrpxn99j57gfqhlotuel
            references price_list
);

create sequence cars_seq START 1;
