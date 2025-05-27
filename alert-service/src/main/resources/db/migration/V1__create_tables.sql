CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE alert_service (
    id UUID PRIMARY KEY,
    message VARCHAR(255) NOT NULL,
    severity VARCHAR(255) NOT NULL,
    timestamp_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    resolved BOOLEAN NOT NULL,
    resolved_at TIMESTAMP,
    resolution_note VARCHAR(1000),
    source VARCHAR(255),
    category VARCHAR(100),
    context VARCHAR(1000),
    assigned_to VARCHAR(255),
    code VARCHAR(100) UNIQUE,
    related_entity_id VARCHAR(255),
    related_entity_type VARCHAR(100),
    priority INTEGER
);
