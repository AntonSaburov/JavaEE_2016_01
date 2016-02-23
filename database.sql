create table jc_region
(
   region_id     SERIAL,
   region_name   varchar(255) not null,
   primary key (region_id)
);

insert into jc_region (region_name) values ('Moscow');
insert into jc_region (region_name) values ('Voronezh');
insert into jc_region (region_name) values ('Altai');
insert into jc_region (region_name) values ('Komi');
insert into jc_region (region_name) values ('Krasnodar');

create table jc_city
(
   city_id       SERIAL,
   city_name     varchar(255) not null,
   region_id     int not null,
   primary key (city_id)
);

create index region_index on jc_city(region_id);

alter table jc_city add constraint ref_region_constraint 
   foreign key (region_id) 
   references jc_region(region_id);

insert into jc_city (city_name, region_id) values ('Kirov', 1);
insert into jc_city (city_name, region_id) values ('Arkhipovsk', 1);
insert into jc_city (city_name, region_id) values ('Lipetsk', 1);
insert into jc_city (city_name, region_id) values ('Kamensk', 2);
insert into jc_city (city_name, region_id) values ('Novovoronezh', 2);
insert into jc_city (city_name, region_id) values ('Sochi', 5);
insert into jc_city (city_name, region_id) values ('Kropotkin', 5);
