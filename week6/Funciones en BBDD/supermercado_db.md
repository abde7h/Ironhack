# Supermercado

## Descripción del problema:
Un supermercado necesita gestionar información sobre productos, proveedores, clientes y ventas. Los requisitos del sistema son los siguientes:

## Entidades y Atributos:
- **Productos**: código de producto, nombre, precio, fecha de vencimiento, categoría.
- **Proveedores**: ID del proveedor, nombre, dirección, teléfono, correo electrónico.
- **Clientes**: número de cliente, nombre, dirección, teléfono, correo electrónico.
- **Ventas**: número de venta, fecha, total, ID del cliente.
- **Detalles de Venta**: ID de detalle, número de venta, código de producto, cantidad, subtotal.

## Relaciones:
- Un proveedor puede suministrar varios productos, pero un producto solo tiene un proveedor (relación 1 a N entre Proveedores y Productos).
- Un cliente puede realizar varias ventas, y cada venta corresponde a un cliente (relación 1 a N entre Clientes y Ventas).
- Una venta puede incluir varios productos (relación 1 a N entre Ventas y Detalles de Venta), y un producto puede aparecer en varias ventas.

## Cardinalidades:
- **Proveedores-Productos**: Un proveedor suministra uno o más productos, un producto pertenece a un proveedor.
- **Clientes-Ventas**: Un cliente puede realizar varias ventas, pero una venta solo está asociada a un cliente.
- **Ventas-Detalles de Venta**: Una venta incluye uno o más productos (detalles de venta).
