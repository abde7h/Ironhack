
CREATE DATABASE IF NOT EXIST Biblioteca;

USE Biblioteca;

CREATE TABLE libros (
    id_libros INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    titulo Varchar(255),
    anio_publicacion INT,
    genero varchar(255),
    id_editorial INT,
    FOREIGN KEY (id_editorial) REFERENCES editorial(id_editorial)
);

CREATE TABLE autores(
    id_autores INT PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(255);
);

CREATE TABLE ejemplares(
    id_ejemplares INT PRIMARY KEY AUTO_INCREMENT,
    id_libros INT,
    ubicacion Varchar(255),
    estado ENUM('disponible','prestado','dañado'),
    FOREIGN KEY (id_libros) REFERENCES libros(id_libros) 
);

CREATE TABLE editoriales(
    id_editoriales INT PRIMARY KEY AUTO_INCREMENT,
    nombre Varchar(255),
    FOREIGN KEY (id_libros) REFERENCES libros(id_libros)
);

CREATE TABLE LibrosAutores(
    id_libros INT,
    id_autores INT,
    FOREIGN KEY (id_libros) REFERENCES libros(id_libros),
    FOREIGN KEY (id_autores) REFERENCES autores(id_autores)
);