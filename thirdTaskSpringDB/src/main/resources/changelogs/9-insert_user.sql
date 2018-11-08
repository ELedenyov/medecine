--liquibase formatted sql

--changeset fertigi:9

insert into user (login, email, password) values ('adm','123@123.ru', '$2a$10$TaOYwJXDRN1ygwjW9DbFCOduG5q6PrvZ/nrwkAaNCtf4qhgnB5.A.');

--rollback delete from user WHERE user.login = 'adm';