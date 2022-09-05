
show databases;

/*
Esto es un comentario
de varias lineas
*/

# Crear base de datos
CREATE DATABASE utp_grupo_14;

# Consultar tablas
show tables;

# Crear tabla
CREATE TABLE users(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(30) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    email VARCHAR(250) NOT NULL,
    fecha_nacimiento TIMESTAMP NOT NULL,
    foto TEXT NOT NULL
);

# Consultar estructura de una tabla
describe users;
