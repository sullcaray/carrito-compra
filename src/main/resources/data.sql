-- Datos iniciales para PharmaCare+
-- Este archivo se ejecuta después de carrito.sql

-- Datos adicionales de productos (si no existen ya)
INSERT INTO products (name, description, price, stock, category_id, created_by) VALUES
('Acetaminofen 500mg', 'Analgésico y antipirético de acción rápida', 6.50, 150, 1, '48484848'),
('Diclofenaco Gel', 'Antiinflamatorio tópico para dolores musculares', 18.50, 85, 4, '48484848'),
('Loratadina 10mg', 'Antihistamínico para alergias', 12.00, 120, 5, '48484848'),
('Suero Oral', 'Rehidratante para diarrea y vómitos', 4.50, 200, 6, '48484848'),
('Termómetro Digital', 'Termómetro de lectura rápida', 25.00, 40, 7, '48484848')
ON CONFLICT (name) DO NOTHING;

-- Usuario adicional de prueba (si no existe)
INSERT INTO users (username, email, password, document_type, identity_document, first_name, last_name, mother_last_name, phone, created_by) VALUES
('testuser', 'test@pharmacare.com', '$2a$12$023ly6Mcks.e1dsGog/EpuIB2fdwJyg1QavbJ9GvaI/JRgipGJNBK', '1', '55667788', 'Usuario', 'Prueba', 'Test', '999888777', '48484848')
ON CONFLICT (username) DO NOTHING;

-- Asignar rol USER al usuario de prueba
INSERT INTO user_roles (user_id, role_id, created_by) VALUES
((SELECT id FROM users WHERE username = 'testuser'), (SELECT id FROM roles WHERE name = 'ROLE_USER'), '48484848')
ON CONFLICT DO NOTHING;
