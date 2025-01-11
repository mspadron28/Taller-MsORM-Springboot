# Proyecto de Gestión de Cursos y Estudiantes

Este proyecto es una aplicación desarrollada en Spring Boot que permite la gestión de cursos y estudiantes, incluyendo la creación, actualización, eliminación y consulta de estos recursos. Se encuentra dockerizado para facilitar su despliegue.

## Requisitos Previos

1. **Java**: Oracle OpenJDK 23.0.1 (o superior).
2. **Maven**: Herramienta para gestionar las dependencias y construir el proyecto.
3. **Docker**: Para ejecutar los contenedores de la aplicación y la base de datos.
4. **MySQL**: Base de datos relacional para almacenar la información.

---

## Estructura del Proyecto

- **Lenguaje**: Java 17
- **Tipo**: Maven
- **Empaquetado**: JAR
- **Grupo Base**: `com.espe.cursos`

### Dependencias Incluidas

1. Spring Web
2. Spring Data JPA
3. Spring Boot DevTools
4. Validation
5. MySQL Driver

### Paquetes

El proyecto se organiza en los siguientes paquetes principales:

- **`controllers`**: Controladores de la aplicación.
  - `CursoController`
  - `EstudianteController`

- **`model.entities`**: Entidades que representan las tablas en la base de datos.
  - `Curso`
  - `Estudiante`

- **`repositories`**: Interfaces para operaciones CRUD sobre las entidades.
  - `CursoRepository`
  - `EstudianteRepository`

- **`services`**: Lógica de negocio.
  - Interfaces: `CursoService`, `EstudianteService`
  - Implementaciones: `CursoServiceImpl`, `EstudianteServiceImpl`

---

## Configuración del Proyecto

### Configuración de `application.properties`

El archivo `application.properties` debe configurarse para la conexión a la base de datos MySQL. Ejemplo de configuración:

```properties
spring.datasource.url=jdbc:mysql://mysql-cursos-ac:3306/nombre_base_datos
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Dockerización

1. **Generación del Build:** Ejecutar el siguiente comando para generar el archivo `.jar` del proyecto, omitiendo las pruebas:

   ```bash
   mvn clean package -DskipTests
   ```

2. **Creación del Dockerfile:** Utiliza el `.jar` generado para construir la imagen Docker.

3. **Archivo `docker-compose.yml`:** Configura los servicios necesarios, como el contenedor de MySQL y el de la aplicación Spring Boot.

4. **Ejecución de Docker Compose:**

   ```bash
   docker-compose up --build
   ```

   Este comando construye y ejecuta los contenedores.

---

## Ejecución del Proyecto

### Localmente

1. Compila y ejecuta el proyecto con Maven:

   ```bash
   mvn spring-boot:run
   ```

2. La aplicación estará disponible en `http://localhost:8002`.

### Con Docker

1. Asegúrate de que Docker esté instalado y en ejecución.
2. Corre el comando:

   ```bash
   docker-compose up --build
   ```

3. Accede a la aplicación en `http://localhost:8080`.

---

## Pruebas de API con Postman

Una vez que los contenedores estén en ejecución:

1. Usa Postman para probar los endpoints de la aplicación (ejemplo: creación de estudiantes y cursos).
2. Verifica que los datos se guarden correctamente en la base de datos.

---

## Autor

Proyecto desarrollado por Cantuña David, León William, Padrón Matías y Mateo Román

