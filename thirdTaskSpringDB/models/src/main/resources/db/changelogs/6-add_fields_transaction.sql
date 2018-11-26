--liquibase formatted sql

--changeset fertigi:6
ALTER TABLE transactions
  ADD created_by INT(11),
  ADD CONSTRAINT fk_transactions_user_create FOREIGN KEY (created_by) REFERENCES user (id),
  ADD updated_by INT(11),
  ADD CONSTRAINT fk_transactions_user_update FOREIGN KEY (updated_by) REFERENCES user (id),
  ADD created_date TIMESTAMP,
  ADD updated_date TIMESTAMP NULL;


--rollback ALTER TABLE transactions DROP FOREIGN KEY fk_transactions_user_create, DROP INDEX fk_transactions_user_create, DROP COLUMN created_by, DROP FOREIGN KEY fk_transactions_user_update, DROP INDEX fk_transactions_user_update, DROP COLUMN updated_by, DROP COLUMN created_date, DROP COLUMN updated_date;
