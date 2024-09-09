CREATE DATABASE IF NOT EXISTS supermercado_db;

USE supermercado_db;

CREATE TABLE Proveedores (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL
);

CREATE TABLE Productos (
    codigo_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    id_proveedor INT NOT NULL,
    FOREIGN KEY (id_proveedor) REFERENCES Proveedores(id_proveedor)
);

CREATE TABLE Clientes (
    numero_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL
);

CREATE TABLE Ventas (
    numero_venta INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(numero_cliente)
);

CREATE TABLE Detalles_Venta (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    numero_venta INT NOT NULL,
    codigo_producto INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (numero_venta) REFERENCES Ventas(numero_venta),
    FOREIGN KEY (codigo_producto) REFERENCES Productos(codigo_producto)
);
