DROP TABLE IF EXISTS order_update;

CREATE TABLE order_update
(
    order_update_id        BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    order_id               BIGINT,
    status                 VARCHAR(20),
    created_date           timestamp not null default current_timestamp,
    last_modified_date     timestamp not null default current_timestamp,
    created_by             VARCHAR(20),
    last_modified_by       VARCHAR(20),
    version                BIGINT
);