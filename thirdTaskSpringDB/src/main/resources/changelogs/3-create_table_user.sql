--liquibase formatted sql

--changeset fertigi:3

create table user
(
  id int auto_increment primary key,
  login varchar(255) not null UNIQUE,
  email varchar(255) not null,
  password varchar(255) not null
)
;
--rollback drop table user;