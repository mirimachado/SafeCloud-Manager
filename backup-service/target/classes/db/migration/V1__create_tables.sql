-- Habilita extensão para UUIDs
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE backup (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID NOT NULL,
    file_path VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    file_name VARCHAR(255) NOT NULL,
    file_size BIGINT NOT NULL,
    file_type VARCHAR(100) NOT NULL,
    storage_location VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    hash_checksum VARCHAR(256) NOT NULL UNIQUE,
    expires_at TIMESTAMP,
    last_verified_at TIMESTAMP,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    notes VARCHAR(500)
);
