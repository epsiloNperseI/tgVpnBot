CREATE TABLE session (
                         id BIGINT PRIMARY KEY,
                         user_id BIGINT NOT NULL,
                         session_id TEXT NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE session_seq INCREMENT BY 1 START WITH 1;