# Gestión de Hospital

## Descripción del problema:

Un hospital necesita gestionar información sobre pacientes, doctores, citas y tratamientos. Los requisitos del sistema son los siguientes:

## Entidades y Atributos:

- **Pacientes**: número de historia clínica, nombre, fecha de nacimiento, dirección, teléfono.
- **Doctores**: ID de doctor, nombre, especialidad, teléfono, correo electrónico.
- **Citas**: número de cita, fecha, motivo, ID de paciente, ID de doctor.
- **Tratamientos**: ID de tratamiento, nombre, descripción, costo.
- **Recetas**: ID de receta, número de cita, ID de tratamiento, cantidad, instrucciones.

## Relaciones:

- Un paciente puede tener muchas citas, y cada cita está asociada a un doctor (relación 1 a N entre Pacientes y Citas, y 1 a N entre Doctores y Citas).
- Una cita puede estar relacionada con múltiples tratamientos a través de recetas (relación 1 a N entre Citas y Recetas).

## Cardinalidades:

- **Pacientes-Citas**: Un paciente puede tener varias citas, pero cada cita corresponde a un solo paciente.
- **Doctores-Citas**: Un doctor puede atender a muchos pacientes a través de citas.
- **Citas-Recetas**: Una cita puede generar una o más recetas, y una receta está relacionada con un solo tratamiento.
