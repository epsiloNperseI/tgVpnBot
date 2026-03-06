CREATE TABLE client (
                        id BIGINT PRIMARY KEY,
                        user_id BIGINT NOT NULL,
                        inbound_id BIGINT NOT NULL REFERENCES inbound(id),
                        client_id TEXT NOT NULL,
                        email TEXT,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE client_seq INCREMENT BY 1 START WITH 1;