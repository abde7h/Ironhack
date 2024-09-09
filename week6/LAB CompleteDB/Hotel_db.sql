CREATE DATABASE IF NOT EXISTS gestionHotel_db;

USE gestionHotel_db;

CREATE TABLE hotel (
    id_hotel INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre varchar(255),
    direccion varchar(255)
);

CREATE TABLE habitacion(
    id_habitacion INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    numero INT,
    tipo varchar(255),
    FOREIGN KEY (id_hotel) REFERENCES hotel(id_hotel),
    estado ENUM('Disponible','No Disponible')
);

CREATE TABLE cliente (
    id_cliente INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE reserva (
    id_reserva INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    id_habitacion INT NOT NULL,
    fecha_inicio DATETIME,
    fecha_fin DATETIME,
    estado ENUM('Disponible','No Disponible'),
    fecha_checkin DATETIME,
    fecha_checkout DATETIME,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente), 
    FOREIGN KEY (id_habitacion) REFERENCES habitacion(id_habitacion) 

);

CREATE TABLE servicio (
    id_servicio INT PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion VARCHAR(500)
);

CREATE TABLE reserva_Servicio(
    id_reserva INT,
    id_servicio INT,
    FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva),
    FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio)
);