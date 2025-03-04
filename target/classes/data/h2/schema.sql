-- Libro Table
CREATE TABLE IF NOT EXISTS libro (
    isbn VARCHAR(50) PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    categoria VARCHAR(100),
    cantidad INTEGER
    );

-- Estanteria Table
CREATE TABLE IF NOT EXISTS estanteria (
    estanteria_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
    );

-- Estante Table
CREATE TABLE IF NOT EXISTS estante (
    estante_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(50) NOT NULL,
    estanteria_id BIGINT,
    FOREIGN KEY (isbn) REFERENCES libro(isbn),
    FOREIGN KEY (estanteria_id) REFERENCES estanteria(estanteria_id)
    );

-- Usuario Table
CREATE TABLE IF NOT EXISTS usuario (
    dni VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    contrasenya VARCHAR(255) NOT NULL,
    correo_electronico VARCHAR(255) NOT NULL UNIQUE
    );

-- Historial Table
CREATE TABLE IF NOT EXISTS historial (
    historial_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(50) NOT NULL,
    isbn VARCHAR(50) NOT NULL,
    FOREIGN KEY (dni) REFERENCES usuario(dni),
    FOREIGN KEY (isbn) REFERENCES libro(isbn)
    );