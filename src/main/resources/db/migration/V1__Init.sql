CREATE TABLE telegram_settings (
                                   id bigint PRIMARY KEY,
                                   bot_token text NOT NULL,
                                   admin_id text,
                                   notification_frequency text DEFAULT '@daily',
                                   backup_enabled BOOLEAN DEFAULT FALSE,
                                   login_notification_enabled BOOLEAN DEFAULT TRUE
);

create sequence telegram_settings_seq increment 2;

CREATE TABLE telegram_logs (
                               id bigint PRIMARY KEY,
                               user_id text,
                               action TEXT,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create sequence telegram_logs_seq increment 2;
