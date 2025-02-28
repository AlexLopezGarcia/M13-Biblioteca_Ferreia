-- Insert sample Libro data
INSERT INTO libro (isbn, titulo, autor, categoria, cantidad) VALUES
('9780060934347', 'Don Quijote', 'Miguel de Cervantes', 'Novela clásica', 5),
('9780061120084', 'Cien Años de Soledad', 'Gabriel García Márquez', 'Realismo mágico', 3),
('9780062315007', 'El Principito', 'Antoine de Saint-Exupéry', 'Literatura infantil', 7),
('9780066515007', 'Asi es la ida', 'Jordy', 'Literatura juvenil', 1);


-- Insert sample Estanteria data
INSERT INTO estanteria (nombre) VALUES
('Estantería Principal'),
('Estantería Secundaria');

-- Insert sample Estante data
INSERT INTO estante (isbn, estanteria_id) VALUES
('9780060934347', 1),
('9780061120084', 1),
('9780062315007', 2);

-- Insert sample Usuario data
INSERT INTO usuario (dni, nombre, contrasenya, correo_electronico) VALUES
('12345678A', 'Juan Pérez', 'password123', 'juan.perez@example.com'),
('87654321B', 'María García', 'securepass', 'maria.garcia@example.com');

-- Insert sample Historial data
INSERT INTO historial (dni, isbn) VALUES
('12345678A', '9780060934347'),
('87654321B', '9780061120084');