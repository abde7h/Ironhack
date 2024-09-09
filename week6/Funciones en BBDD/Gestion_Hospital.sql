CREATE DATABASE IF NOT EXIST gestionhospital_db;

USE gestionhospital_db;

CREATE TABLE Pacientes (
    numero_historia_clinica INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(15) NOT NULL
);

CREATE TABLE Doctores (
    id_doctor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL
);

CREATE TABLE Citas (
    numero_cita INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    id_paciente INT NOT NULL,
    id_doctor INT NOT NULL,
    FOREIGN KEY (id_paciente) REFERENCES Pacientes(numero_historia_clinica),
    FOREIGN KEY (id_doctor) REFERENCES Doctores(id_doctor)
);

CREATE TABLE Tratamientos (
    id_tratamiento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    costo DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Recetas (
    id_receta INT AUTO_INCREMENT PRIMARY KEY,
    numero_cita INT NOT NULL,
    id_tratamiento INT NOT NULL,
    cantidad INT NOT NULL,
    instrucciones TEXT NOT NULL,
    FOREIGN KEY (numero_cita) REFERENCES Citas(numero_cita),
    FOREIGN KEY (id_tratamiento) REFERENCES Tratamientos(id_tratamiento)
);
