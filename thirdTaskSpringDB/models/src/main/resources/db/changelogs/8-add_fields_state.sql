--liquibase formatted sql

--changeset fertigi:8
ALTER TABLE states
  ADD created_by INT(11),
  ADD CONSTRAINT fk_states_user_create FOREIGN KEY (created_by) REFERENCES user (id),
  ADD created_date TIMESTAMP,
  ADD updated_by INT(11),
  ADD CONSTRAINT fk_states_user_update FOREIGN KEY (updated_by) REFERENCES user (id),
  ADD updated_date TIMESTAMP NULL;


--rollback ALTER TABLE states DROP FOREIGN KEY fk_states_user_create, DROP INDEX fk_states_user_create, DROP COLUMN created_by, DROP FOREIGN KEY fk_states_user_update, DROP INDEX fk_states_user_update, DROP COLUMN updated_by, DROP COLUMN created_date, DROP COLUMN updated_date;
