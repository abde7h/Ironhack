# Normalización de Bases de Datos

En este ejercicio, vamos a descomponer las tablas proporcionadas en varias tablas más pequeñas y especializadas para cumplir con las reglas de normalización hasta alcanzar la Tercera Forma Normal (3FN). La normalización ayuda a eliminar redundancias y dependencias no deseadas.

## Ejercicio 1: Base de Datos de Películas

### Tabla Original: Peliculas

| id_pelicula | titulo                   | director             | año_estreno | genero | actor_principal | actor_secundario | pais_origen |
| ----------- | ------------------------ | -------------------- | ----------- | ------ | --------------- | ---------------- | ----------- |
| 1           | The Shawshank Redemption | Frank Darabont       | 1994        | Drama  | Tim Robbins     | Morgan Freeman   | USA         |
| 2           | The Godfather            | Francis Ford Coppola | 1972        | Crime  | Marlon Brando   | Al Pacino        | USA         |
| 3           | The Dark Knight          | Christopher Nolan    | 2008        | Action | Christian Bale  | Heath Ledger     | USA         |
| ...         | ...                      | ...                  | ...         | ...    | ...             | ...              | ...         |

### Problemas Identificados

- **Redundancia de Actores**: Un actor puede actuar en múltiples películas. Almacenamos cada actor como un atributo de la película, lo que lleva a redundancia.
- **Dependencias**: El país de origen de una película no está directamente relacionado con el resto de la información de la película.

### Descomposición en 3FN

#### Tabla Peliculas

| id_pelicula | titulo                   | id_director | año_estreno | genero | pais_origen |
| ----------- | ------------------------ | ----------- | ----------- | ------ | ----------- |
| 1           | The Shawshank Redemption | 1           | 1994        | Drama  | USA         |
| 2           | The Godfather            | 2           | 1972        | Crime  | USA         |
| 3           | The Dark Knight          | 3           | 2008        | Action | USA         |
| ...         | ...                      | ...         | ...         | ...    | ...         |

#### Tabla Directores

| id_director | nombre               |
| ----------- | -------------------- |
| 1           | Frank Darabont       |
| 2           | Francis Ford Coppola |
| 3           | Christopher Nolan    |
| ...         | ...                  |

#### Tabla Actores

| id_actor | nombre         |
| -------- | -------------- |
| 1        | Tim Robbins    |
| 2        | Morgan Freeman |
| 3        | Marlon Brando  |
| ...      | ...            |

#### Tabla PeliculaActores (relaciona películas con actores)

| id_pelicula | id_actor |
| ----------- | -------- |
| 1           | 1        |
| 1           | 2        |
| 2           | 3        |
| ...         | ...      |

## Ejercicio 2: Base de Datos de Coches

### Tabla Original: Coches

| id_coche | marca  | modelo  | año  | propietario_nombre | propietario_direccion | propietario_telefono | taller_nombre   | taller_direccion        |
| -------- | ------ | ------- | ---- | ------------------ | --------------------- | -------------------- | --------------- | ----------------------- |
| 1        | Toyota | Corolla | 2018 | Juan Pérez         | Calle Principal 123   | 123-456-7890         | Taller Juan     | Avenida Central 456     |
| 2        | Honda  | Civic   | 2017 | María López        | Avenida Libertad 456  | 987-654-3210         | Taller Martínez | Calle Independencia 789 |
| ...      | ...    | ...     | ...  | ...                | ...                   | ...                  | ...             | ...                     |

### Problemas Identificados

- **Redundancia de Propietario y Taller**: Un propietario o taller puede estar asociado a múltiples coches.
- **Dependencias**: La información del propietario y del taller no está relacionada directamente con el coche, sino con el coche a través de las columnas.

### Descomposición en 3FN

#### Tabla Coches

| id_coche | marca  | modelo  | año  | id_propietario | id_taller |
| -------- | ------ | ------- | ---- | -------------- | --------- |
| 1        | Toyota | Corolla | 2018 | 1              | 1         |
| 2        | Honda  | Civic   | 2017 | 2              | 2         |
| ...      | ...    | ...     | ...  | ...            | ...       |

#### Tabla Propietarios

| id_propietario | nombre      | direccion            | telefono     |
| -------------- | ----------- | -------------------- | ------------ |
| 1              | Juan Pérez  | Calle Principal 123  | 123-456-7890 |
| 2              | María López | Avenida Libertad 456 | 987-654-3210 |
| ...            | ...         | ...                  | ...          |

#### Tabla Talleres

| id_taller | nombre          | direccion               |
| --------- | --------------- | ----------------------- |
| 1         | Taller Juan     | Avenida Central 456     |
| 2         | Taller Martínez | Calle Independencia 789 |
| ...       | ...             | ...                     |

## Ejercicio 3: Base de Datos de Equipos de Fútbol

### Tabla Original: EquiposFutbol

| id_equipo | nombre_equipo | estadio           | entrenador      | ciudad    | jugador1      | jugador2     | jugador3        |
| --------- | ------------- | ----------------- | --------------- | --------- | ------------- | ------------ | --------------- |
| 1         | Real Madrid   | Santiago Bernabéu | Carlo Ancelotti | Madrid    | Karim Benzema | Luka Modric  | Sergio Ramos    |
| 2         | FC Barcelona  | Camp Nou          | Ronald Koeman   | Barcelona | Lionel Messi  | Gerard Piqué | Sergio Busquets |
| ...       | ...           | ...               | ...             | ...       | ...           | ...          | ...             |

### Problemas Identificados

- **Redundancia de Jugadores**: Un jugador puede estar en varios equipos.
- **Dependencias**: La información de los jugadores y el entrenador no está directamente relacionada con la tabla principal de equipos.

### Descomposición en 3FN

#### Tabla Equipos

| id_equipo | nombre_equipo | estadio           | entrenador_id | ciudad    |
| --------- | ------------- | ----------------- | ------------- | --------- |
| 1         | Real Madrid   | Santiago Bernabéu | 1             | Madrid    |
| 2         | FC Barcelona  | Camp Nou          | 2             | Barcelona |
| ...       | ...           | ...               | ...           | ...       |

#### Tabla Entrenadores

| id_entrenador | nombre          |
| ------------- | --------------- |
| 1             | Carlo Ancelotti |
| 2             | Ronald Koeman   |
| ...           | ...             |

#### Tabla Jugadores

| id_jugador | nombre        |
| ---------- | ------------- |
| 1          | Karim Benzema |
| 2          | Luka Modric   |
| 3          | Sergio Ramos  |
| ...        | ...           |

#### Tabla EquipoJugadores (relaciona equipos con jugadores)

| id_equipo | id_jugador |
| --------- | ---------- |
| 1         | 1          |
| 1         | 2          |
| 1         | 3          |
| ...       | ...        |

## Ejercicio 4: Base de Datos de Canciones

### Tabla Original: Canciones

| id_cancion | titulo            | artista    | album                | año_lanzamiento | genero | duracion | compositor      |
| ---------- | ----------------- | ---------- | -------------------- | --------------- | ------ | -------- | --------------- |
| 1          | Bohemian Rhapsody | Queen      | A Night at the Opera | 1975            | Rock   | 00:05:55 | Freddie Mercury |
| 2          | Shape of You      | Ed Sheeran | ÷                    | 2017            | Pop    | 00:03:53 | Ed Sheeran      |
| ...        | ...               | ...        | ...                  | ...             | ...    | ...      | ...             |

### Problemas Identificados

- **Redundancia de Artistas y Compositores**: Un artista puede haber creado múltiples canciones.
- **Dependencias**: La información del artista y del compositor puede estar duplicada.

### Descomposición en 3FN

#### Tabla Canciones

| id_cancion | titulo            | album                | año_lanzamiento | genero | duracion | compositor_id | id_artista |
| ---------- | ----------------- | -------------------- | --------------- | ------ | -------- | ------------- | ---------- |
| 1          | Bohemian Rhapsody | A Night at the Opera | 1975            | Rock   | 00:05:55 | 1             | 1          |
| 2          | Shape of You      | ÷                    | 2017            | Pop    | 00:03:53 | 2             | 2          |
| ...        | ...               | ...                  | ...             | ...    | ...      | ...           | ...        |

#### Tabla Compositores

| id_compositor | nombre          |
| ------------- | --------------- |
| 1             | Freddie Mercury |
| 2             | Ed Sheeran      |
| ...           | ...             |

#### Tabla Artista

| id_artista | nombre     |
| ---------- | ---------- |
| 1          | Queen      |
| 2          | Ed Sheeran |
| ...        | ...        |

## Ejercicio 5: Base de Datos de Animales

### Tabla Original: Animales

| id_animal | nombre   | especie | edad | propietario_nombre | propietario_direccion | veterinario_nombre | veterinario_direccion |
| --------- | -------- | ------- | ---- | ------------------ | --------------------- | ------------------ | --------------------- |
| 1         | Max      | Perro   | 5    | Ana Martínez       | Calle Principal 123   | Dr. Pérez          | Avenida Central 456   |
| 2         | Whiskers | Gato    | 3    | Luisa Rodríguez    | Calle Libertad 456    | Dr. Gómez          | Avenida Sur 789       |
| ...       | ...      | ...     | ...  | ...                | ...                   | ...                | ...                   |

### Problemas Identificados

- **Redundancia de Propietarios y Veterinarios**: Un propietario o veterinario puede estar asociado a múltiples animales.
- **Dependencias**: La información del propietario y del veterinario puede estar duplicada.

### Descomposición en 3FN

#### Tabla Animales

| id_animal | nombre   | especie | edad | id_propietario | id_veterinario |
| --------- | -------- | ------- | ---- | -------------- | -------------- |
| 1         | Max      | Perro   | 5    | 1              | 1              |
| 2         | Whiskers | Gato    | 3    | 2              | 2              |
| ...       | ...      | ...     | ...  | ...            | ...            |

#### Tabla Propietarios

| id_propietario | nombre          | direccion           |
| -------------- | --------------- | ------------------- |
| 1              | Ana Martínez    | Calle Principal 123 |
| 2              | Luisa Rodríguez | Calle Libertad 456  |
| ...            | ...             | ...                 |

#### Tabla Veterinarios

| id_veterinario | nombre    | direccion           |
| -------------- | --------- | ------------------- |
| 1              | Dr. Pérez | Avenida Central 456 |
| 2              | Dr. Gómez | Avenida Sur 789     |
| ...            | ...       | ...                 |
