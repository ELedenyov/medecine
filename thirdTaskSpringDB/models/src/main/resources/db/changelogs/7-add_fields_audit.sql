--liquibase formatted sql

--changeset fertigi:7
ALTER TABLE auditoperations
  ADD user_id INT(11),
  ADD CONSTRAINT fk_audit_user FOREIGN KEY (user_id) REFERENCES user (id);


--rollback ALTER TABLE auditoperations DROP FOREIGN KEY fk_audit_user, DROP INDEX fk_audit_user, DROP COLUMN user_id;