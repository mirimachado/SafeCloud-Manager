CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE vault (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID NOT NULL,
    data_key VARCHAR(255) NOT NULL,
    data_value TEXT NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

CREATE TABLE file (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    size BIGINT NOT NULL,
    upload_date TIMESTAMP WITHOUT TIME ZONE,
    owner_id UUID NOT NULL
);

CREATE TABLE file_meta_data (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    file_id UUID UNIQUE,
    key VARCHAR(255) NOT NULL,
    value TEXT NOT NULL,
    CONSTRAINT fk_file_meta_data_file FOREIGN KEY (file_id) REFERENCES file(id)
);
