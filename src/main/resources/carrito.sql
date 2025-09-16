-- Script de creación de tablas para PostgreSQL
-- Aplicación CarritoApp

-- Tabla: roles
CREATE TABLE roles (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255),
    status VARCHAR(1) NOT NULL DEFAULT '1',
    created_by VARCHAR(12) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(12),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla: users
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    document_type VARCHAR(1) NOT NULL,
    identity_document VARCHAR(12) UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(70) NOT NULL,
    mother_last_name VARCHAR(70) NOT NULL,
    phone VARCHAR(12),
    status VARCHAR(1) NOT NULL DEFAULT '1',
    created_by VARCHAR(12) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(12),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla: user_roles
CREATE TABLE user_roles (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    status VARCHAR(1) NOT NULL DEFAULT '1',
    created_by VARCHAR(12) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(12),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_user_roles_role FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- Índices para mejorar rendimiento
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_identity_document ON users(identity_document);
CREATE INDEX idx_roles_name ON roles(name);
CREATE INDEX idx_user_roles_user_id ON user_roles(user_id);
CREATE INDEX idx_user_roles_role_id ON user_roles(role_id);

-- Comentarios para documentación
COMMENT ON TABLE roles IS 'Table that stores system roles';
COMMENT ON COLUMN roles.status IS 'Record status: 0=Inactive, 1=Active, 2=Deleted';

COMMENT ON TABLE users IS 'Table that stores user information';
COMMENT ON COLUMN users.document_type IS 'Identity document type';
COMMENT ON COLUMN users.status IS 'Record status: 0=Inactive, 1=Active, 2=Deleted';

COMMENT ON TABLE user_roles IS 'Many-to-many relationship table between users and roles';
COMMENT ON COLUMN user_roles.status IS 'Record status: 0=Inactive, 1=Active, 2=Deleted';

-- Datos iniciales (opcional)
INSERT INTO roles (name, description, created_by) VALUES
('ADMIN', 'System administrator', 'SYSTEM'),
('USER', 'Standard user', 'SYSTEM'),
('MODERATOR', 'System moderator', 'SYSTEM');
