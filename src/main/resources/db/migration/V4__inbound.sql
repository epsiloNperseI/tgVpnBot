CREATE TABLE inbound (
                         id BIGINT PRIMARY KEY,
                         user_id BIGINT NOT NULL,
                         inbound_id TEXT NOT NULL UNIQUE,
                         remark TEXT,
                         protocol TEXT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE inbound_seq INCREMENT BY 1 START WITH 1;