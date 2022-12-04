insert into sensor (name)
values ('Датчик Шереметьево');

insert into sensor (name)
values ('Датчик Внуково');

insert into sensor (name)
values ('Датчик Домодедово');

insert into sensor (name)
values ('Датчик Phuket');

insert into sensor (name)
values ('Датчик Antalya');

insert into sensor (name)
values ('Датчик Hurghada');

insert into measurement (value, raining, sensor_id, created_at)
values (27.8, false, 2, current_timestamp);
insert into measurement (value, raining, sensor_id, created_at)
values (24.78, true, 5, current_timestamp);
insert into measurement (value, raining, sensor_id, created_at)
values (22.349, false, 3, current_timestamp);
insert into measurement (value, raining, sensor_id, created_at)
values (21.0, true, 1, current_timestamp);
insert into measurement (value, raining, sensor_id, created_at)
values (31, false, 6, current_timestamp);
