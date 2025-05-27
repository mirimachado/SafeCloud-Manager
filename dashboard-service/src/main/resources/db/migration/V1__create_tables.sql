CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE dashboard (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID NOT NULL,
    config_json TEXT NOT NULL,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE health_check (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    service_name VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    checked_at TIMESTAMP
);
