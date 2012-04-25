drop table Device;
drop table Component;
drop sequence com_sq;
drop sequence dev_sq;

create table Component (
  id_component Integer not null,
  title varchar(50) not null,
  description varchar(1000),
  producer varchar(100) not null,
  weight decimal,
  img varchar(100),
  price decimal
);

create sequence com_sq start with 10; 

create table Device (
  id_device Integer not null,
  id_prev Integer,
  id_component Integer not null,
  title varchar(50) not null
);

create sequence dev_sq start with 1000; 

ALTER TABLE Component ADD PRIMARY KEY (id_component);
ALTER TABLE Device ADD PRIMARY KEY (id_device);
ALTER TABLE Device ADD FOREIGN KEY (id_component) REFERENCES Component (id_component) on delete Cascade;
ALTER TABLE Device ADD CONSTRAINT fk_Self FOREIGN KEY (id_prev) REFERENCES Device (id_device) ON DELETE CASCADE;

commit;