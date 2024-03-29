CREATE TABLE APP_ROLE
(
    ID   BIGINT       NOT NULL,
    NAME VARCHAR(32) NOT NULL,
    CREATED_AT TIMESTAMP,
    UPDATED_AT TIMESTAMP
);

ALTER TABLE APP_ROLE ADD CONSTRAINT PK_APP_ROLE PRIMARY KEY (ID);

CREATE TABLE ROLES_PRIVILEGES
(
    PRIVILEGE_ID BIGINT NOT NULL,
    ROLE_ID      BIGINT NOT NULL,
    CONSTRAINT PK_ROLES_PRIVILEGES PRIMARY KEY (PRIVILEGE_ID, ROLE_ID)
);

ALTER TABLE APP_ROLE  ADD CONSTRAINT UC_APP_ROLE_NAME UNIQUE (NAME);

ALTER TABLE ROLES_PRIVILEGES  ADD CONSTRAINT FK_ROLPRI_ON_PRIVILEGE FOREIGN KEY (privilege_id) REFERENCES APP_PRIVILEGE (ID);

ALTER TABLE ROLES_PRIVILEGES ADD CONSTRAINT FK_ROLPRI_ON_ROLE FOREIGN KEY (role_id) REFERENCES APP_ROLE (ID);