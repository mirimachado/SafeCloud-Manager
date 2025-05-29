CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE shared_libs (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255),
    version VARCHAR(255)
);
