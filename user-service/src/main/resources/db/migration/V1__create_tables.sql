CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE configuration (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    key VARCHAR(255) NOT NULL,
    value VARCHAR(255) NOT NULL,
    system BOOLEAN
);

CREATE TABLE organization (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    active BOOLEAN,
    logo_url VARCHAR(255),
    contact_email VARCHAR(255) NOT NULL,
    contact_phone VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(100) NOT NULL,
    role VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    token VARCHAR(255) UNIQUE,
    organization_id UUID,
    CONSTRAINT fk_users_organization FOREIGN KEY (organization_id) REFERENCES organization(id),
    timestamp_created_at DATE,
    timestamp_updated_at DATE
);

CREATE TABLE team (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    organization_id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    description TEXT,
    CONSTRAINT fk_team_organization FOREIGN KEY (organization_id) REFERENCES organization(id)
);

CREATE TABLE team_member (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    team_id UUID,
    user_id UUID,
    role VARCHAR(255) NOT NULL,
    description TEXT,
    CONSTRAINT fk_team_member_team FOREIGN KEY (team_id) REFERENCES team(id),
    CONSTRAINT fk_team_member_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE user_settings (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID,
    theme VARCHAR(255) NOT NULL,
    language VARCHAR(255) NOT NULL,
    CONSTRAINT fk_user_settings_user FOREIGN KEY (user_id) REFERENCES users(id)
);
