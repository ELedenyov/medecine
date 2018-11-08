--liquibase formatted sql

--changeset fertigi:4
ALTER TABLE patients
  ADD created_by INT(11),
  ADD CONSTRAINT fk_patients_user_create FOREIGN KEY (created_by) REFERENCES user (id),
  ADD updated_by INT(11),
  ADD CONSTRAINT fk_patients_user_update FOREIGN KEY (updated_by) REFERENCES user (id),
  ADD created_date TIMESTAMP,
  ADD updated_date TIMESTAMP NULL;


--rollback ALTER TABLE patients DROP FOREIGN KEY fk_patients_user_create, DROP INDEX fk_patients_user_create, DROP COLUMN created_by, DROP FOREIGN KEY fk_patients_user_update, DROP INDEX fk_patients_user_update, DROP COLUMN updated_by, DROP COLUMN created_date, DROP COLUMN updated_date;
