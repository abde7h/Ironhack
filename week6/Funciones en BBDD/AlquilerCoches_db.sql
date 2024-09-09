CREATE DATABASE AlquilerCoches;

USE AlquilerCoches;

CREATE TABLE vehiculos (
    id_vehiculo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    marca varchar(255),
    modelo varchar(255),
    anio_fabricacion YEAR,
    tipo varchar(255),
    matricula Varchar(255),
    estado ENUM('disponible','no disponible')
);

CREATE TABLE clientes (
    id_cliente INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre varchar(255),
    direccion varchar(255),
    telefono INT,
    correo_electronico varchar(255),
    licencia_conducir varchar(255)
);

CREATE TABLE alquileres (
    id_alquiler INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fecha_inicio DATETIME
    fecha_fin DATETIME,
    FOREIGN KEY id_vehiculo REFERENCES vehiculos(id_vehiculo),
    FOREIGN KEY id_cliente REFERENCES clientes(id_cliente),
    precio INT
);

CREATE TABLE devoluciones (
    id_devolucion INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fecha_devolucion DATETIME,
    observaciones varchar(500),
    FOREIGN KEY id_alquiler REFERENCES alquileres(id_alquiler)
)