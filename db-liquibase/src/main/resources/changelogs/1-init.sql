--liquibase formatted sql

--changeset fertigi:1

create table states
(
  id int auto_increment
    primary key,
  name varchar(255) not null,
  code varchar(255) not null,
  constraint states_name_uindex
  unique (name),
  constraint states_nm_uindex
  unique (code)
)
;

create table patients
(
  id int auto_increment
    primary key,
  phone varchar(255) not null,
  state_id int not null,
  constraint patients_phone_uindex
  unique (phone),
  constraint patients_states_id_fk
  foreign key (state_id) references states (id)
)
;

create table products
(
  id int auto_increment
    primary key,
  name varchar(255) not null,
  state_id int not null,
  constraint products_name_uindex
  unique (name),
  constraint products_states_id_fk
  foreign key (state_id) references states (id)
)
;

create table auditoperations
(
  id int auto_increment
    primary key,
  date date not null,
  status varchar(255) not null,
  action varchar(255) not null
)
;

create table transactions
(
  id int auto_increment
    primary key,
  patient_id int not null,
  product_id int not null,
  date date not null,
  constraint transactions_patients_id_fk
  foreign key (patient_id) references patients (id),
  constraint transactions_products_id_fk
  foreign key (product_id) references products (id)
)
;

--rollback drop schema medicines;