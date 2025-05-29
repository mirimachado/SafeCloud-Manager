CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE audit_logs (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID NOT NULL,
    action VARCHAR(255) NOT NULL,
    timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    details VARCHAR(255) NOT NULL,
    ip_address VARCHAR(100),
    user_agent VARCHAR(500),
    entity_affected VARCHAR(100),
    entity_id VARCHAR(100),
    success BOOLEAN NOT NULL,
    method VARCHAR(50),
    module VARCHAR(100),
    error_message VARCHAR(1000)
);
