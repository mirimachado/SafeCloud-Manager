CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE discovery_server (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    service_name VARCHAR(255) NOT NULL,
    endpoint VARCHAR(255),
    last_seen TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
