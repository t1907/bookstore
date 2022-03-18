CREATE TABLE book
(
    id     BIGINT       NOT NULL,
    title  VARCHAR(255) NULL,
    author VARCHAR(255) NULL,
    CONSTRAINT pk_book PRIMARY KEY (id)
);

CREATE TABLE user
(
    id       BIGINT       NOT NULL,
    login    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);