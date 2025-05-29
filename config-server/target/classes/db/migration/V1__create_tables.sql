CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE config_server (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    environment VARCHAR(255),
    config_repo_url VARCHAR(255)
);

CREATE TABLE system_settings (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    key VARCHAR(255) NOT NULL,
    value VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP
);
