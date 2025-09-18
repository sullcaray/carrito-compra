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
('ROLE_ADMIN', 'System administrator', '48484848'),
('ROLE_USER', 'Standard user', '48484848'),
('ROLE_MODERATOR', 'System moderator', '48484848');


-- Datos de prueba de usuarios
-- Contraseña para todos: admin2025 (encriptada con BCrypt)
INSERT INTO users (username, email, password, document_type, identity_document, first_name, last_name, mother_last_name, phone, created_by) VALUES
('admin', 'admin@carritoapp.com', '$2a$12$023ly6Mcks.e1dsGog/EpuIB2fdwJyg1QavbJ9GvaI/JRgipGJNBK', '1', '12345678', 'Administrator', 'Sistema', 'Admin', '987654321', '48484848'),
('johndoe', 'john@gmail.com', '$2a$12$023ly6Mcks.e1dsGog/EpuIB2fdwJyg1QavbJ9GvaI/JRgipGJNBK', '1', '87654321', 'John', 'Doe', 'Smith', '123456789', '48484848'),
('janedoe', 'jane@gmail.com', '$2a$12$023ly6Mcks.e1dsGog/EpuIB2fdwJyg1QavbJ9GvaI/JRgipGJNBK', '1', '11223344', 'Jane', 'Doe', 'Johnson', '456789123', '48484848');

-- Asignar roles a usuarios
INSERT INTO user_roles (user_id, role_id, created_by) VALUES
(1, 1, '48484848'), -- admin tiene rol ADMIN
(1, 2, '48484848'), -- admin también tiene rol USER
(2, 2, '48484848'), -- johndoe tiene rol USER
(3, 2, '48484848'), -- janedoe tiene rol USER
(3, 3, '48484848'); -- janedoe también tiene rol MODERATOR
