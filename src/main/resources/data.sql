INSERT INTO clients (first_name, last_name, email) VALUES ('John', 'Doe', 'john.doe@example.com');

INSERT INTO categories (name) VALUES ('Pastillas');
INSERT INTO categories (name) VALUES ('Jarabes');

INSERT INTO products (name, description, price, stock, category_id) VALUES ('Panadol', 'Pastilla para el resfrio', 10.0, 100, 1);
INSERT INTO products (name, description, price, stock, category_id) VALUES ('Ibuprofeno', 'Pastilla para la inflamación', 20.0, 100, 1);
INSERT INTO products (name, description, price, stock, category_id) VALUES ('PaltoMiel', 'Jarabe para gripe', 30.0, 100, 2);
