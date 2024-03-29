CREATE TABLE APP_PRIVILEGE
(
    ID   BIGINT       NOT NULL,
    NAME VARCHAR(32) NOT NULL,
    CREATED_AT TIMESTAMP,
    UPDATED_AT TIMESTAMP
);

ALTER TABLE APP_PRIVILEGE ADD CONSTRAINT PK_APP_PRIVILEGE PRIMARY KEY (ID);

ALTER TABLE APP_PRIVILEGE ADD CONSTRAINT UC_APP_PRIVILEGE_NAME UNIQUE (NAME);