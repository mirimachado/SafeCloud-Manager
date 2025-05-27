CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE notification (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    user_id UUID NOT NULL,
    read BOOLEAN,
    sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE notification_config (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID NOT NULL,
    email_enabled BOOLEAN NOT NULL,
    sms_enabled BOOLEAN NOT NULL,
    push_enabled BOOLEAN NOT NULL
);
