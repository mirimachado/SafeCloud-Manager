CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE logging (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    level VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    source VARCHAR(255)
);

CREATE TABLE error_report (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID NOT NULL,
    error_message TEXT NOT NULL,
    stack_trace TEXT NOT NULL,
    created_at TIMESTAMP
);

CREATE TABLE system_log (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    level VARCHAR(50) NOT NULL, -- enum LevelLog como string
    message TEXT NOT NULL,
    timestamp TIMESTAMP,
    user_id UUID NOT NULL
);
