create table cars
(
    car_id bigint not null
        primary key,
    car_name varchar(255) null,
    car_color varchar(255) null,
    car_type_id bigint null,
    price_id bigint null
);

create index FK1itgarrpxn99j57gfqhlotuel
	on cars (price_id);

create index FKcki51tfk2udss8oujqvpu1mpj
	on cars (car_type_id);

create table cars_seq
(
    next_val bigint
);

insert into cars_seq values (1);

